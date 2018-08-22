package com.NikitaDrozdinski.finalProject.Facade;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.NikitaDrozdinski.finalProject.Entity.Company;
import com.NikitaDrozdinski.finalProject.Entity.Customer;
import com.NikitaDrozdinski.finalProject.services.CompanyService;
import com.NikitaDrozdinski.finalProject.services.CustomerService;

import Exceptions.ClinetNotFoundException;
import Exceptions.EntityNotPresetException;

@Service
public class AdminFacade implements CouponClientFacade {

	@Autowired
	private CompanyService companyService;

	@Autowired
	private CustomerService customerService;

	@Override
	public CouponClientFacade login(String name, String password, ClientType type) throws ClinetNotFoundException {
		if (name == "admin" && password == "1234") {
			return this;
		}else {
			throw new ClinetNotFoundException ("admin name or password incorrect");
		}
		
	}

	public Company createCompany(Company company) {
		return companyService.save(company);
	}

	public Company removeCompany(Long companyId) throws EntityNotPresetException {
		return companyService.delete(companyId);
	}

	public Company updateCompany(Company company) {
		return companyService.save(company);
	}

	public Company getCompany(Long companyId) throws EntityNotPresetException {
		return companyService.findById(companyId);
	}

	public List<Company> getAllCompany() {
		return companyService.getAll();
	}

	public Customer createCustomer(Customer customer) {
		return customerService.save(customer);
	}

	public Customer removeCustomer(Long customerId) throws EntityNotPresetException {
		return customerService.delete(customerId);
	}

	public Customer updateCustomer(Customer customer) {
		return customerService.save(customer);
	}

	public Customer getCustomer(Long customerId) throws EntityNotPresetException {
		return customerService.findById(customerId);
	}

	public List<Customer> getAllCustomer() {
		return customerService.getAll();
	}
}
