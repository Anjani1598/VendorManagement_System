package com.masai.service;

import java.util.ArrayList;



import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.entities.Product;
import com.masai.entities.Vendor;
import com.masai.exception.NotFoundException;
import com.masai.repository.ProductDAO;
import com.masai.repository.VendorDAO;



@Service
public class ProductServiceImpl implements ProductServiceIntr{

	@Autowired
	private VendorDAO vDao;
	
	@Autowired
	private ProductDAO pDao;
	
	
	
	@Override
	public Product registerProductToVendor(Integer vendorId, Product product) {
		// TODO Auto-generated method stub
		
		Optional<Vendor> opt = vDao.findById(vendorId);
		
		if(opt.isEmpty()) {
			throw new NotFoundException("Vendor with this id is not found");
		}
		Vendor vendor = opt.get();
		List<Product> list = new ArrayList<>();
		list.add(product);
		vendor.
		product.getVendors().add(vendor);
		
		return pDao.save(product);
	}
	
	
	@Override
	public Product updateProduct(Integer pId, Product product) {
		// TODO Auto-generated method stub
		Optional<Product> opt = pDao.findById(pId);
		if(opt.isEmpty()) {
			throw new NotFoundException("Product Not Found With This Id");
		}
		Product  p = new Product();
		p.setProductName(product.getProductName());
		p.setDescription(product.getDescription());
		p.setPrice(product.getPrice());
		p.setBrand(product.getBrand());
		
		return pDao.save(p);
	}

	@Override
	public List<Product> poductsByName(String productname) {
		// TODO Auto-generated method stub
		List<Product> plist = pDao.searchByNameLike(productname);
		if(plist.isEmpty()) {
			throw new NotFoundException("Product With This Name Is Not Found");
		}
		
		
		
		return plist;
	}


	@Override
	public List<Product> getAllProducts() {
		// TODO Auto-generated method stub
		
		if(pDao.findAll().size()==0) throw new NotFoundException("No Products Found");
		return pDao.findAll(); 
	}

	
	
}
