package com.customerPortal.CustomerManage.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.customerPortal.CustomerManage.model.CustomerGroup;


@Repository
public interface CustomerGroupRepository extends JpaRepository<CustomerGroup,Integer> {

	@Query(value="select * from  customer_group where customer_id= :id",nativeQuery=true)
	List<CustomerGroup> findByCustomerId(@Param("id") int id);
}
