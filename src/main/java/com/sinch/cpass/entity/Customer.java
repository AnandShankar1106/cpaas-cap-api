package com.sinch.cpass.entity;

import lombok.Data;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigInteger;
import java.util.Date;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

@Data
@Entity
@Table(name = "customers")
public class Customer extends Base {
    @Column(name = "first_name")
    private String firstName;

    @Column(name = "middle_name")
    private String middleName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email")
    private String email;

    @Column(name = "phone")
    private String phone;

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

    @Column(name = "company_name")
    private String companyName;

    @Column(name = "partner_id")
    private UUID partnerId;

    @Column(name = "parent_partner_id")
    private UUID parentPartnerId;

    @Column(name = "external_order_id")
    private String externalOrderId;

    @Column(name = "network_class_of_service")
    private String networkClassOfService;

    @Column(name = "external_customer_id")
    private String externalCustomerId;

    @Column(name = "international_calling")
    private Boolean internationalCalling;

    @Column(name = "service_provider_id")
    private String serviceProviderId;

    @Column(name = "primary_contact_id")
    private UUID primaryContactId;

    @Column(name = "contract_start_date")
    private Date contractStartDate;

    @Column(name = "contract_term")
    private Integer contractTerm;

    @Column(name = "customer_since_date")
    private Date customerSinceDate;

    @Column(name = "contract_end_date")
    private Date contractEndDate;
    
    @Column(name = "created_by")
    private String createdBy;
    
    @Column(name = "updated_by")
    private String updatedBy;
    
    @Column(name = "billing_id")
    private BigInteger billingId;
    
    @Column(name = "account_type")
    private String accountType;

    @Column(name = "trial_end_date")
    private Date trialEndDate;
    
    @Column(name = "business_name")
	private String businessName;
    
    @Column(name = "active")
	private Boolean active;
    
    @Column(name = "dns_accountid")
    private BigInteger dnsAccountId ;
    
    @Column(name = "teams_type")
    private String teamsType ;
    
    @Column(name = "external_tenant_id")
    private String externalTenantId;
    
    @Column(name = "esip_cust_type")
    private String esipCustType;

    @Column(name = "call_forwarding")
    private Boolean callForwarding;
    
    @Column(name = "status")
    private String status;
    
    @Transient
    @JsonProperty("trunkGroup")
    private String trunkGroup;
    
    @Transient
    @JsonProperty("routeLabel")
    private String routeLabel;
    
    @Column(name = "custAbbr")
    private String custAbbr;

    @Column(name = "zoom_cust_type")
    private String zoomCustType;

}
