package com.sinch.cpass.dto.request;


import lombok.Data;

@Data
public class AccountCreateRequest {
	private String orderId;
	private String userId;
}