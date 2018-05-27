package com.nk.demo.dao;

import java.util.List;

import com.nk.demo.domain.Product;

public interface ProductDAO {

	List<Product> findAll();

	Product findById(int id);

	Product save(Product p);

}