package com.sinch.cpass.dto.request;

import java.util.Date;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Order {

	private int id;
	private String orderNumber;
	private int shippingAddressId;
	private int billingAddressId;
	private int equipmentInvoiceAddressId;
	private String addressId;
	private int serviceInvoiceAddressId;
	private String timeZone;
	private String netPrice;
	private String taxPrice;
	private String shippingPrice;
	private Date orderedAt;
	private String partnerId;
	private String parentPartnerId;
	private String locationLabel;
	private int isDirectRoutingOrder;
	private int isCcpOrder;
	private String orderCategory;
	private String externalTenantId;
	private String esipCustType;
	private String zoomCustType;
}
