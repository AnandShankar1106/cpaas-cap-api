package com.sinch.cpass.repo;


import java.math.BigInteger;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sinch.cpass.entity.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, UUID> {

	Customer findByExternalOrderId(String externalOrderId);

	@Query(value = "SELECT nextval('service_id')", nativeQuery = true)
	String getNextValServiceId();

	@Query(value = "SELECT nextval('account_id_seq')", nativeQuery = true)
	String getNextValAccountId();

	@Query(value = "SELECT nextval('customer_billing_sequence')", nativeQuery = true)
	BigInteger getNextValCustBillSeq();
	
	@Query(value = "SELECT nextval('customer_dns_accountid_seq')", nativeQuery = true)
	BigInteger getNextValDnsAccountIdSeq();

	Customer getById(UUID id);
	
    Optional<Customer> findTopByCustAbbrNotNullOrderByCustAbbrDesc();

	List<Customer> findByIdIn(List<UUID> ids);
	
	List<Customer> findAllByAccountTypeAndTrialEndDateBetween(String accountType, Date start, Date end);
	
}
