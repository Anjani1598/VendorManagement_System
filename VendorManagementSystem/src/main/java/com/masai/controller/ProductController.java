package com.masai.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

//import com.masai.DTO.ProductResponseDto;
import com.masai.entities.Product;

import com.masai.service.ProductServiceIntr;
import com.masai.service.VendorServiceIntr;
@RestController
public class ProductController {

	@Autowired
	private VendorServiceIntr vService;
	
	@Autowired
	private ProductServiceIntr pService;

	
	@PostMapping("/vendor/products/{vId}")
	public ResponseEntity<Product> saveVendorProduct(@PathVariable("vId") Integer vId, @RequestBody Product product){
		Product c = pService.registerProductToVendor(vId, product);	
		return new ResponseEntity<Product>(c,HttpStatus.CREATED);
	}
	
	@PutMapping("/vendor/products/{id}")
	public ResponseEntity<Product> updateVendorProducts(@PathVariable("id") Integer id, @RequestBody Product product){
		Product c = pService.updateProduct(id, product);	
		return new ResponseEntity<Product>(c,HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/vendor/products/{name}")
	public ResponseEntity<List<Product>> getVendorProduct(@PathVariable("name") String name){
		List<Product> vlist = pService.poductsByName(name);	
		return new ResponseEntity<List<Product>>(vlist,HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/vendor/allproducts")
	public ResponseEntity<List<Product>> getAllProducts(){
		List<Product> vlist = pService.getAllProducts();	
		return new ResponseEntity<List<Product>>(vlist,HttpStatus.ACCEPTED);
	}
	
}
