package com.customerPortal.CustomerManage.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.customerPortal.CustomerManage.model.CustomerDetails;
import com.customerPortal.CustomerManage.model.CustomerGroup;
import com.customerPortal.CustomerManage.service.CustomerDetailsService;
import com.customerPortal.CustomerManage.service.CustomerGroupService;

@Controller
public class CustomerDetailGroupController {
	
	@Autowired
	private CustomerDetailsService custDetailService;
	
	@Autowired
	private CustomerGroupService custGroupService;
	
	@GetMapping("/")
	public String home(Model model)
	{
		
		return "index";
	}
	@RequestMapping(value="/newCustomer")
	public String newCustomer(Model model)
	{
		model.addAttribute("customer",new CustomerDetails());
		return "newCustomer";
		
	}
	@RequestMapping(value="/saveCustomer",method=RequestMethod.POST)
	public String saveCustomer(@ModelAttribute("customer") CustomerDetails custDetail)
	{
		custDetailService.saveDetails(custDetail);
		return "redirect:/";
		
	}
	
	@GetMapping("/check")
	public String check() {
		custDetailService.check()
;		
		return "redirect:/";
	}
	@RequestMapping(value="/viewAll")
	public String viewAll(Model model)
	{
		List<CustomerDetails> custList=new ArrayList<>();
		List<CustomerGroup>    groupList=new ArrayList<>();
		custList=custDetailService.getAll();
		groupList=custGroupService.findAll();
		model.addAttribute("groupList",groupList);
		model.addAttribute("custList",custList);
		
		return "viewAll";
	}
	@Scheduled(cron="0 29 14 * * ?")
	public void customerGroupBifurcation()
	{
		System.out.println("in cron scheduler");
		List<CustomerDetails> customerList=new ArrayList<>();
		customerList=custDetailService.findAll();
		
		for(CustomerDetails i: customerList)
		{
			CustomerGroup custGroup=new CustomerGroup();
			System.out.println("in bifurcation:"+i.getFirstName());
			int age=i.getAge();
			if(age<=15)
			{
				custGroup.setAgeGroup("Child");
				custGroup.setCustomerId(i.getCustomerId());
				//custGroupService.saveCustomerGroup(custGroup);
			}
			else if(age>15 && age<=24)
			{
				custGroup.setAgeGroup("Youth");
				custGroup.setCustomerId(i.getCustomerId());
				//custGroupService.saveCustomerGroup(custGroup);
				
			}
			else if(age>25 && age<=64)
			{
				custGroup.setAgeGroup("Adults");
				custGroup.setCustomerId(i.getCustomerId());
				//custGroupService.saveCustomerGroup(custGroup);
				
			}
			else if(age>64)
			{
				System.out.println("in senoir0");
				custGroup.setAgeGroup("Senior");
				custGroup.setCustomerId(i.getCustomerId());
				
				//custGroupService.saveCustomerGroup(custGroup);
				System.out.println("data"+custGroup.getAgeGroup()+" "+custGroup.getCustomerId()+" "+custGroup.getGroupId() );

				
				
			}
			if(custGroupService.isPresent(i.getCustomerId()))
			{
			custGroupService.saveCustomerGroup(custGroup);
			}
			
				
		}
		
		
		
	}

}
