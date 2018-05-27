package com.nk.demo.web;

import java.net.URI;
import java.util.List;

import javax.annotation.PostConstruct;

import org.apache.tomcat.util.http.parser.MediaType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.nk.demo.dao.ProductDAO;
import com.nk.demo.dao.ProductRepository;
import com.nk.demo.domain.Product;

@RestController
public class ProductResource {
	
	
	// resource url should be noun always 
	@Autowired
	ProductRepository productDAO;
	
	@PostConstruct
	public void seedDB() {
		Product p = new Product("sampleName",999);
		productDAO.save(p);
	}
	
	@RequestMapping(value="/products", method = RequestMethod.GET)
	public List<Product> findAll() {
		return productDAO.findAll();
	}
	
	@RequestMapping(value="/products/{id}", method = RequestMethod.GET)
	public ResponseEntity<Product> findById(@PathVariable("id") int id) {
		Product p = productDAO.findById(id);
		if (p == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Product>(p,HttpStatus.OK); 
		
	}

	@RequestMapping(value="/products", method = RequestMethod.POST, consumes = {"application/json"})
	public ResponseEntity<Product> save(@RequestBody Product p) {
		Product saved = productDAO.save(p);
		int id = saved.getId();
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(URI.create("/products/"+id));
		return new ResponseEntity<>(headers,HttpStatus.CREATED);
	}

}
