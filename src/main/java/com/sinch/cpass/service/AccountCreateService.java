package com.sinch.cpass.service;

import java.time.Duration;
import java.time.Instant;
import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.fasterxml.jackson.databind.JsonNode;
import com.sinch.cpass.client.PartnerApiClient;
import com.sinch.cpass.common.Constants;
import com.sinch.cpass.dao.AddressOrderDao;
import com.sinch.cpass.dto.request.AccountCreateRequest;
import com.sinch.cpass.dto.request.Order;
import com.sinch.cpass.dto.response.ResponseMessage;
import com.sinch.cpass.entity.Customer;
import com.sinch.cpass.exception.BadRequestException;
import com.sinch.cpass.repo.CustomerRepository;
import com.sinch.cpass.utils.CommonUtils;

@Service
public class AccountCreateService {
	
	@Autowired
	CustomerRepository customerRepository;
	
	@Autowired
	PartnerApiClient partnerApiClient;
	
	@Autowired
	AddressOrderDao addressDao;
	
	@Value("${trial.period}")
	Long TRIAL_PERIOD;

	public ResponseMessage accountCreate(AccountCreateRequest accountCreateRequest) {
		try {
			if (!StringUtils.hasText(accountCreateRequest.getOrderId()))
				throw new BadRequestException("OrderId cannot be null");
			
			String formattedOrderId = CommonUtils.replaceLast(accountCreateRequest.getOrderId(), "O", "Q");


			Customer customer = customerRepository.findByExternalOrderId(accountCreateRequest.getOrderId());
			if (customer != null)
			throw new BadRequestException("Customer already exists");

			Customer cust = addressDao.findOrderAndAddress(formattedOrderId);/* todo - exceptioncheck */
			Order order = addressDao.findOrderByOrderID(formattedOrderId);/* todo -exceptioncheck */

			if (order == null)
				throw new BadRequestException("Order not found");

			cust.setExternalOrderId(accountCreateRequest.getOrderId());
			JsonNode partnerDetails = partnerApiClient.getPartnersData(order.getPartnerId());
			JsonNode parentPartnerDetails = partnerDetails;
			if (!order.getPartnerId().equals(order.getParentPartnerId())) {
				parentPartnerDetails = partnerApiClient.getPartnersData(order.getParentPartnerId());
			}
			if (Constants.TRIAL.equalsIgnoreCase(cust.getAccountType())) {
				cust.setTrialEndDate(Date.from(Instant.now().plus(Duration.ofDays(TRIAL_PERIOD))));
			}
			cust.setParentPartnerId(CommonUtils.uuid(parentPartnerDetails.path("uuid").asText()));
			cust.setPartnerId(CommonUtils.uuid(partnerDetails.path("uuid").asText()));
			cust.setServiceProviderId(parentPartnerDetails.get("partner_id").textValue());
			cust.setCreatedBy(accountCreateRequest.getUserId());
			cust.setUpdatedBy(accountCreateRequest.getUserId());
			cust.setBillingId(customerRepository.getNextValCustBillSeq());
			cust.setDnsAccountId(customerRepository.getNextValDnsAccountIdSeq());
			cust.setTeamsType(order.getOrderCategory().toUpperCase());
			
			if(Constants.BUSINESS_NAME_ESIP.equals(cust.getBusinessName())) {
			  cust.setEsipCustType(order.getEsipCustType());
			  cust.setCustAbbr(generateCustomerAbbr());
			}
			else if (Constants.BUSINESS_NAME_ZOOM.equals(cust.getBusinessName()))
				cust.setZoomCustType(order.getZoomCustType());
			customerRepository.save(cust);
			if(cust.getActive()) {
			 // kafkaPublisher.orderEvents(new OrderEventRequest(orderId,cust.getId().toString()));
			}
			return ResponseMessage.okMessage("Success");
		} catch (Exception e) {
			e.printStackTrace();
			throw new BadRequestException(e.getMessage());
		}

	}
	

	// customer abbr generated used during the customer creation
	public String generateCustomerAbbr() {
		String customerAbbr = null;
		Optional<Customer> customer = customerRepository.findTopByCustAbbrNotNullOrderByCustAbbrDesc();

		if (customer.isPresent()) {
			customerAbbr = customer.get().getCustAbbr();

			int maxCount = 99;
			int count = Integer.parseInt(customerAbbr.substring(2));
			char beginChar = customerAbbr.charAt(0);
			char endChar = customerAbbr.charAt(1);

			if (count < maxCount) {
				count++;
			} else if ('Z' != endChar) {
				count = 0;
				endChar += 1;
			} else {
				count = 0;
				endChar = 'A';
				beginChar += 1;
			}

			customerAbbr = (beginChar + "" + endChar).concat(String.format("%02d", count));
		} else
			customerAbbr = "AA00";

		return customerAbbr;
	}

}
