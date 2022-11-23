package com.masai.service;

import java.util.List;


import org.springframework.stereotype.Service;


import com.masai.entities.Vendor;

@Service
public interface VendorServiceIntr {

	public Vendor createVendor(Vendor vendor);
	
	public List<Vendor> getVendorByName(String vendorName);
	
	
	public List<Vendor> getVendorList();

}
