package com.sinch.cpass.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sinch.cpass.dto.request.AccountCreateRequest;
import com.sinch.cpass.dto.response.ResponseMessage;
import com.sinch.cpass.service.AccountCreateService;

import lombok.extern.slf4j.Slf4j;


@Slf4j
@RestController
@RequestMapping("/ccp/account")
public class AccountCreateContoller {
	
	@Autowired
	AccountCreateService accountCreateService;

	@PostMapping("/create")
	public ResponseMessage accountCreate(@RequestBody AccountCreateRequest accountCreateRequest) {
		log.info("Create Customer Request: {}", accountCreateRequest);
		return accountCreateService.accountCreate(accountCreateRequest);
	}
	
}
