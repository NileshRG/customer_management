package com.customerPortal.CustomerManage.service;

import java.util.ArrayList;

import java.util.List;

import javax.persistence.Cacheable;
import javax.swing.text.html.HTMLDocument.Iterator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Service;

import com.customerPortal.CustomerManage.model.CustomerDetails;
import com.customerPortal.CustomerManage.repository.CustomerDetailsRepository;

@Service
public class CustomerDetailsService {
	
	@Autowired
	private CustomerDetailsRepository custRepo;
	
	public void saveDetails(CustomerDetails cus)
	{
		clearCache();
		System.out.println("in save nad clear cache");
		
		custRepo.save(cus);
	}
	
	public List<CustomerDetails> findAll()
	{
		return custRepo.findAll();
	}
	
	public void check()
	{
		List<CustomerDetails> lis=new ArrayList<>();
		lis=custRepo.findAll();
		for (CustomerDetails i : lis) {
            System.out.println("data"+i.getFirstName());
        }
		
		
	}
	@org.springframework.cache.annotation.Cacheable(value="customerDetails")
	public List<CustomerDetails> getAll()
	{
		//clearCache();
		System.out.println("in get all");
		return custRepo.findAll();
	}
	@Autowired
    private CacheManager cacheManager;      // autowire cache manager
    // clear all cache using cache manager
    
    public void clearCache(){
    	System.out.println("in clear cache");
       // for(String name:cacheManager.getCacheNames()){
            cacheManager.getCache("customerDetails").clear();            // clear cache by name
        
    }
	
	

}
