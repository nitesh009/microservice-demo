package com.nk.demo.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.nk.demo.domain.Product;

@Repository
public interface ProductRepository extends CrudRepository<Product, Integer> {
	
	Product findById(int id);
	List<Product> findAll();

}
