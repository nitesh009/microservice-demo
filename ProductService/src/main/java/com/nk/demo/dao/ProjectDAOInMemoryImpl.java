package com.nk.demo.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.stereotype.Component;

import com.nk.demo.domain.Product;


// if you are creating singleton, its your responsiblity to make it thread safe...
@Component
public class ProjectDAOInMemoryImpl implements ProductDAO {
	
	Map<Integer,Product> db = new ConcurrentHashMap<>(); // thread safe
	AtomicInteger idSeq = new AtomicInteger(0); // thread safe
	
	/* (non-Javadoc)
	 * @see com.nk.demo.dao.ProductDAO#findAll()
	 */
	@Override
	public List<Product> findAll() {
		return new ArrayList<Product>(db.values());
	}
	
	/* (non-Javadoc)
	 * @see com.nk.demo.dao.ProductDAO#findById(int)
	 */
	@Override
	public Product findById(int id) {
		return db.get(id);
	}

	/* (non-Javadoc)
	 * @see com.nk.demo.dao.ProductDAO#save(com.nk.demo.domain.Product)
	 */
	@Override
	public Product save(Product p) {
		int id = idSeq.incrementAndGet();
		p.setId(id);
		db.put(id, p);
		return p;	
	}
}
