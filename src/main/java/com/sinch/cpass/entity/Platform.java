package com.sinch.cpass.entity;

import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "platforms")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Platform extends Base{

	
	@Id
    @GeneratedValue
    private UUID id;

    @Column(name = "business_name")
    private String name;
    
   
}
