package com.NikitaDrozdinski.finalProject.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.NikitaDrozdinski.finalProject.Dao.CustomerDAO;
import com.NikitaDrozdinski.finalProject.Entity.Customer;

import Exceptions.EntityNotPresetException;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerDAO customerDAO;

	@Override
	public List<Customer> getAll() {
		return customerDAO.findAll();
	}

	@Override
	public Customer findById(Long customerId) throws EntityNotPresetException {
		Optional<Customer> optCustomer = customerDAO.findById(customerId);
		if (!optCustomer.isPresent()) {
			throw new EntityNotPresetException("The customer id " + customerId + "not  not found!");

		}
		return customerDAO.findById(customerId).get();
	}

	@Override
	public Customer save(Customer customer) {
		return customerDAO.save(customer);
	}

	@Override
	public Customer delete(Long customerId) throws EntityNotPresetException {
		Customer customer = findById(customerId);
		customerDAO.delete(customer);
		return customer;
	}

	@Override
	public boolean userExists(String name, String password) {
		if (customerDAO.findByCustomerNameAndCustomerPassword(name, password).isEmpty()) {
			return false;
		} else {
			return true;
		}
	}
}
