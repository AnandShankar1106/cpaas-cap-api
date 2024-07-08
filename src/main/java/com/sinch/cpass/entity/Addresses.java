package com.sinch.cpass.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "addresses")
public class Addresses extends Base {

	@Column(name = "first_name")
	private String firstName;

	@Column(name = "middle_name")
	private String middleName;

	@Column(name = "last_name")
	private String lastName;

	@Column(name = "phone")
	private String phone;

	@Column(name = "email")
	private String email;

	@Column(name = "address1")
	private String address1;

	@Column(name = "address2")
	private String address2;

	@Column(name = "city")
	private String city;

	@Column(name = "state")
	private String state;

	@Column(name = "country")
	private String country;

	@Column(name = "zip")
	private String zip;

	@Column(name = "pcode")
	private String pcode;

	@Column(name = "is_skipped")
	private Boolean isSkipped;

	@Column(name = "address_type")
	private String addressType;

	@Column(name = "business_name")
	private String businessName;

	@Column(name = "latitude")
	private Float latitude;

	@Column(name = "longitude")
	private Float longitude;

}
