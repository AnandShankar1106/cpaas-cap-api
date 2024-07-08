package com.sinch.cpass.dto.request;

import java.util.Date;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Address {

	private int id;
	private String address1;
	private String address2;
	private String city;
	private String state;
	private String country;
	private String zip;
	private String address_type;
	private byte uuid;
	private String company_name;
	private String first_name;
	private String middle_name;
	private String last_name;
	private String phone;
	private String email;
	private Date created_at;
	private Date updated_at;
	private int order_id;
	private String latitude;
	private String longitude;
	private String a_type;
	private int add_on_address_change;
	private String valid_address;
	private String user_uniq_id;
	private String sf_id;
	private String pcode;
	private int is_skipped;
	private String county;

}
