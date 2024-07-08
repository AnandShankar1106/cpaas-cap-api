package com.sinch.cpass.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.sinch.cpass.dto.request.Address;


public class AddressRowMapper implements RowMapper<Address> {

	@Override
	public Address mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		Address address = new Address();

		address.setId(rs.getInt("id"));
		address.setAddress1(rs.getString("address1"));
		address.setAddress2(rs.getString("address2"));
		address.setCity(rs.getString("city"));
		address.setState(rs.getString("state"));
		address.setCountry(rs.getString("country"));
		address.setZip(rs.getString("zip"));
		address.setAddress_type(rs.getString("address_type"));
		//address.setUuid(rs.getByte("uuid"));
		address.setCompany_name(rs.getString("company_name"));
		address.setFirst_name(rs.getString("first_name"));
		address.setMiddle_name(rs.getString("middle_name"));
		address.setLast_name(rs.getString("last_name"));
		address.setPhone(rs.getString("phone"));
		address.setEmail(rs.getString("email"));
		address.setCreated_at(rs.getDate("created_at"));
		address.setUpdated_at(rs.getDate("updated_at"));
		address.setOrder_id(rs.getInt("order_id"));
		address.setLatitude(rs.getString("latitude"));
		address.setLongitude(rs.getString("longitude"));
		address.setA_type(rs.getString("a_type"));
		address.setAdd_on_address_change(rs.getInt("add_on_address_change"));
		address.setValid_address(rs.getString("valid_address"));
		address.setUser_uniq_id(rs.getString("user_uniq_id"));
		address.setSf_id(rs.getString("sf_id"));
		address.setPcode(rs.getString("pcode"));
		address.setIs_skipped(rs.getInt("is_skipped"));
		address.setCounty(rs.getString("county"));

		return address;
	}

}
