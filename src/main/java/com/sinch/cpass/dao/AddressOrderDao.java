package com.sinch.cpass.dao;

import java.util.UUID;

import javax.sql.DataSource;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import com.sinch.cpass.mapper.AddressOrderRowMapper;
import com.sinch.cpass.mapper.AddressRowMapper;
import com.sinch.cpass.mapper.OrderRowMapper;
import com.sinch.cpass.dto.request.Address;
import com.sinch.cpass.dto.request.Order;
import com.sinch.cpass.entity.Addresses;
import com.sinch.cpass.entity.Customer;
import com.sinch.cpass.repo.AddressesRespository;


@Repository
public class AddressOrderDao {

	JdbcTemplate jt;
	
	@Autowired
	AddressesRespository addressRepo;

	@Autowired
	public AddressOrderDao(@Qualifier("salesOrderDataSource") DataSource salesOrderDataSource) {
		jt = new JdbcTemplate(salesOrderDataSource);
	}

	private static final String GET_ADD_ORDERS = "SELECT * FROM addresses A, orders B, order_types C WHERE A.id = (SELECT address_id FROM orders WHERE order_number = '%s') and B.order_number = '%s' and C.id = B.order_type_id";
	private static final String GET_ORDER = "SELECT * FROM orders WHERE order_number = '%s'";
	private static final String UPDATE_ORDER = "UPDATE orders SET external_tenant_id='%s' WHERE order_number='%s'";	
	private static final String GET_ADDRESS = "SELECT * FROM addresses WHERE id = '%s'";
	private static final String GET_ORDER_BY_PARENT_ORDERID = "SELECT * FROM orders WHERE parent_order_id = (SELECT id FROM orders WHERE order_number = '%s') limit 1";
	private static final String GET_TENANTID_ORDERS = "SELECT * FROM orders WHERE external_tenant_id = '%s' limit 1";

	
	public Customer findOrderAndAddress(String formattedOrderId) {
		String query = String.format(GET_ADD_ORDERS, formattedOrderId, formattedOrderId);		
		Customer customer = jt.queryForObject(query, new AddressOrderRowMapper());
		return customer;
	}

	public Order findOrderByOrderID(String formattedOrderId) {
		String query = String.format(GET_ORDER, formattedOrderId);
		return jt.queryForObject(query, new OrderRowMapper());

	}
	
	public Order findOrderByExternalTenantID(String tenantId) {
		String query = String.format(GET_TENANTID_ORDERS, tenantId);
		Order order = (Order) jt.query(query,rs-> rs.next()? new OrderRowMapper().mapRow(rs, 1):null);
		
		return order;

	}
	
	
	
	public int updateOrderWithTenantID(String tenantId, String orderid) {
		String query = String.format(UPDATE_ORDER,tenantId,orderid);
		return jt.update(query);
	}
	
	
	
	
	public Order findOrderByParentOrderID(String formattedOrderId) {
		String query = String.format(GET_ORDER_BY_PARENT_ORDERID, formattedOrderId);
		return jt.queryForObject(query, new OrderRowMapper());

	}
	
	public String getExternalTenantId(String formattedOrderId) {
		String query = String.format(GET_ORDER, formattedOrderId);
		return jt.queryForObject(query, new OrderRowMapper()).getExternalTenantId();

	}

	public UUID insertAddressLocation(int addressId, String addressType, String businessName) {
		float latitude = 0;
		float longitude = 0;

		Address addDto = getAddressInfo(addressId);
		Addresses adddressEntity = addressDtoToAddressEntity(addDto);

		adddressEntity.setBusinessName(businessName);
		adddressEntity.setLatitude(latitude);
		adddressEntity.setLongitude(longitude);

		addressRepo.save(adddressEntity);

		return adddressEntity.getId();
	}

	public UUID insertAddressLocation(Address addDto, Customer customer) {
      float latitude = 0;
      float longitude = 0;

      Addresses adddressEntity = addressDtoToAddressEntity(addDto);

      adddressEntity.setFirstName(customer.getFirstName());
      adddressEntity.setLastName(customer.getLastName());
      adddressEntity.setMiddleName(customer.getMiddleName());
      adddressEntity.setPhone(customer.getPhone());
      adddressEntity.setEmail(customer.getEmail());
      adddressEntity.setBusinessName(customer.getBusinessName());
      adddressEntity.setLatitude(latitude);
      adddressEntity.setLongitude(longitude);

      addressRepo.save(adddressEntity);

      return adddressEntity.getId();
  }
	
	public Addresses addressDtoToAddressEntity(Address addDto) {
		Addresses adddressEntity = new Addresses();
		BeanUtils.copyProperties(addDto, adddressEntity);
		return adddressEntity;
	}

	public Address getAddressInfo(int addressId) {
		String query = String.format(GET_ADDRESS, addressId);
		return jt.queryForObject(query, new AddressRowMapper());

	}

}