package com.masai.service;

import java.util.ArrayList;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.masai.entities.Product;
import com.masai.entities.Vendor;
import com.masai.exception.NotFoundException;
import com.masai.repository.ProductDAO;
import com.masai.repository.VendorDAO;

@Service
public class VendorServiceImpl implements VendorServiceIntr{

	@Autowired
	private VendorDAO vDao;
	
	
	
	@Autowired
	private ProductDAO pDao;
	@Override
	public Vendor createVendor(Vendor vendor) {
		// TODO Auto-generated method stub
		
		List<Product> products = vendor.getProductList();
		
		
		for(Product product:products) {
			product.getVendors().add(vendor);
		}
		
		
		return vDao.save(vendor);
	}

	@Override
	public List<Vendor> getVendorByName(String vendorName) {
		// TODO Auto-generated method stub
		List<Vendor> vlist =  vDao.searchByNameLike(vendorName);
		if(vlist.isEmpty()) {
			throw new NotFoundException("No Vender Found With This Name");
		}
		
		return vlist;
	}
	
	
	@Override
	public List<Vendor> getVendorList() {
		// TODO Auto-generated method stub
		List<Vendor> v = vDao.findAll();
		if(v.isEmpty()) {
			throw new NotFoundException("There Is No Vendor Found");
		}
		return v;
	}

}
