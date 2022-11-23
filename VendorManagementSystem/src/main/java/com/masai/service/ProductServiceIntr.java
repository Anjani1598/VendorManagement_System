package com.masai.service;

import java.util.List;


import org.springframework.stereotype.Service;

//import com.masai.DTO.ProductResponseDto;
import com.masai.entities.Product;

@Service
public interface ProductServiceIntr {
	
	public Product registerProductToVendor(Integer vendorId, Product product);

	
	public Product updateProduct(Integer pId,Product product);
	
	public List<Product> poductsByName(String productname);
	
	public List<Product> getAllProducts();
}
