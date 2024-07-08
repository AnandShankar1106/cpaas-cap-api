package com.sinch.cpass.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.fasterxml.jackson.databind.JsonNode;

@FeignClient(name = "partner-api-client", url = "${external_apis.partner_api}")
public interface PartnerApiClient {

    @RequestMapping(method = RequestMethod.GET, value = "/partners/{partnerId}", consumes = "application/json")
    JsonNode getPartnersData(@PathVariable String partnerId);
    
 

}
