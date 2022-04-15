package com.customerPortal.CustomerManage.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.customerPortal.CustomerManage.model.CustomerGroup;
import com.customerPortal.CustomerManage.repository.CustomerGroupRepository;

@Service
public class CustomerGroupService  {
	
	@Autowired 
	private CustomerGroupRepository grpRepo;
	
	
	
	public void saveCustomerGroup(CustomerGroup grp)
	{
		grpRepo.save(grp);
	}
	
	public List<CustomerGroup> findAll()
	{
		return grpRepo.findAll()
;	}
	
	public boolean isPresent(int id)
	{
		
		List<CustomerGroup> grpList=new ArrayList<>();
		grpList=grpRepo.findByCustomerId(id);
		boolean ans=grpList.isEmpty();
		System.out.println("ind id check"+id+"result:"+ans);
		return ans;
		
	}
	

	
	
	

}
