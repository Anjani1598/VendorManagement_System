package com.masai.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Vendor {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer vId;
	private String vendorName;
	private String contactNumber;
	private String city;
	private String state;
	private String country;
    
	
	
	@ManyToMany(cascade = CascadeType.ALL , mappedBy = "vendors")
	private List<Product> productList;
}
