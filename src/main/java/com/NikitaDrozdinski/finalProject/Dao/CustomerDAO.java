package com.NikitaDrozdinski.finalProject.Dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.NikitaDrozdinski.finalProject.Entity.Customer;

public interface CustomerDAO extends JpaRepository<Customer, Long> {
	
	List<Customer> findByCustomerNameAndCustomerPassword(String customerName ,String customerPassword);

}
