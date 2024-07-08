package com.sinch.cpass.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.sinch.cpass.entity.Customer;



public class AddressOrderRowMapper implements RowMapper<Customer> {

	@Override
	public Customer mapRow(ResultSet rs, int rowNum) throws SQLException {
		Customer customer = new Customer();
		String formattedPhone = rs.getString("phone").toString().replaceAll("[^0-9]", "");
		customer.setFirstName(rs.getString("first_name"));
		customer.setMiddleName(rs.getString("middle_name"));
		customer.setLastName(rs.getString("last_name"));
		customer.setEmail(rs.getString("email"));
		customer.setPhone(formattedPhone);
		customer.setAddress1(rs.getString("address1"));
		customer.setAddress2(rs.getString("address2"));
		customer.setCity(rs.getString("city"));
		customer.setState(rs.getString("state"));
		customer.setZip(rs.getString("zip"));
		customer.setCountry(rs.getString("country"));
		customer.setCompanyName(rs.getString("company_name"));
		customer.setExternalOrderId(rs.getString("order_number"));
		customer.setExternalCustomerId(rs.getString("order_number"));
		customer.setAccountType(rs.getString("name"));
		customer.setActive(true);
		customer.setCallForwarding(false);
		/*
		// set business name
		if (rs.getInt("is_direct_routing_order") == 1) {
			customer.setBusinessName(MSTeamsConstants.BUSINESS_NAME_MSTEAMS);
			customer.setActive(false);
		} else if (rs.getInt("is_ccp_order") == 1){
			customer.setBusinessName(Constants.BUSINESS_NAME_CCP);
		}
		// for operator connect
		else if (rs.getInt("is_operator_connect") == 1) {
			customer.setBusinessName(Constants.BUSINESS_NAME_OPERATORCONNECT);
		}
		//for esip
		else if(rs.getInt("is_esip_order") == 1) {
		  customer.setBusinessName(Constants.BUSINESS_NAME_ESIP);
          customer.setActive(false);
		}
		// for Zoom
		else if (rs.getInt("is_zoom_order") == 1) {
			customer.setBusinessName(Constants.BUSINESS_NAME_ZOOM);
		}
		*/
		return customer;
	}

}
