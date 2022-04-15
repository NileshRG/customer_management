package com.customerPortal.CustomerManage.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;


@Data
@Entity(name="customer_group")
public class CustomerGroup {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int groupId;
	private int customerId;
	private String ageGroup;
	public CustomerGroup()
	{
		
	}
	public CustomerGroup(int groupId, int customerId, String ageGroup) {
		super();
		this.groupId = groupId;
		this.customerId = customerId;
		this.ageGroup = ageGroup;
	}
	public int getGroupId() {
		return groupId;
	}
	public void setGroupId(int groupId) {
		this.groupId = groupId;
	}
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public String getAgeGroup() {
		return ageGroup;
	}
	public void setAgeGroup(String ageGroup) {
		this.ageGroup = ageGroup;
	}
	
	
}
