package com.sinch.cpass.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.sinch.cpass.dto.request.Order;


public class OrderRowMapper implements RowMapper<Order> {

	@Override
	public Order mapRow(ResultSet rs, int rowNum) throws SQLException {
		Order order = new Order();
		order.setId(rs.getInt("id"));
		order.setOrderNumber(rs.getString("order_number"));
		order.setShippingAddressId(rs.getInt("shipping_address_id"));
		order.setBillingAddressId(rs.getInt("billing_address_id"));
		order.setEquipmentInvoiceAddressId(rs.getInt("equipment_invoice_address_id"));
		order.setAddressId(rs.getString("address_id"));
		order.setServiceInvoiceAddressId(rs.getInt("service_invoice_address_id"));
		order.setTimeZone(rs.getString("time_zone"));
		order.setNetPrice(rs.getString("net_price"));
		order.setTaxPrice(rs.getString("tax_price"));
		order.setShippingPrice(rs.getString("shipping_price"));
		order.setOrderedAt(rs.getDate("ordered_at"));
		order.setPartnerId(rs.getString("setid"));
		order.setParentPartnerId(rs.getString("sec_setid"));
		order.setLocationLabel(rs.getString("location_label"));
		order.setIsCcpOrder(rs.getInt("is_ccp_order"));
		order.setIsDirectRoutingOrder(rs.getInt("is_direct_routing_order"));
		order.setOrderCategory(rs.getString("order_category"));
		order.setExternalTenantId(rs.getString("external_tenant_id"));
		if(rs.getInt("is_esip_order") == 1)
		  order.setEsipCustType(rs.getString("esip_cust_type"));
		if(rs.getInt("is_zoom_order") == 1)
			  order.setZoomCustType(rs.getString("zoom_cust_type"));
		return order;
	}

}