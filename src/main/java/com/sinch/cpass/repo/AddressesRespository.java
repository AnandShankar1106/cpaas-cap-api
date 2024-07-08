package com.sinch.cpass.repo;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sinch.cpass.entity.Addresses;


@Repository
public interface AddressesRespository extends JpaRepository<Addresses, UUID> {

}
