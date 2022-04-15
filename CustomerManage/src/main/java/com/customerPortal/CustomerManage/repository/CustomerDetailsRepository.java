package com.customerPortal.CustomerManage.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.customerPortal.CustomerManage.model.CustomerDetails;


@Repository
public interface CustomerDetailsRepository extends JpaRepository<CustomerDetails,Integer>{

//	@Query(value="select * from CustomerDetails",nativeQuery=true)
//	List<> findAllInString();
	
	
	
	

}
