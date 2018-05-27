package com.nk.demo.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ProductCountService {
	
	
	// use can feign etc for accessing other service (similar to CrudRepository for DB it internally uses DiscoveryClient)
	@Autowired
	DiscoveryClient client;
	
	@GetMapping
	@RequestMapping(value="/productcount")
	public String getCount() {
		List<ServiceInstance> list = client.getInstances("productService");
		String uri = list.get(0).getUri().toString();
		Product[] ps = new RestTemplate().getForObject(uri+"/products", Product[].class);
		return ""+ps.length;
	}
}


