package com.NikitaDrozdinski.finalProject.services;

import java.util.List;

import com.NikitaDrozdinski.finalProject.Entity.Customer;

import Exceptions.EntityNotPresetException;

public interface CustomerService {

	List<Customer> getAll();

	Customer findById(Long customerId) throws EntityNotPresetException;

	Customer save(Customer customer);

	Customer delete(Long customerId) throws EntityNotPresetException;

	boolean userExists(String name, String password);

}
