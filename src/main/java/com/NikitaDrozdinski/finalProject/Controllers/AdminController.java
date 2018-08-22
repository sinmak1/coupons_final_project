package com.NikitaDrozdinski.finalProject.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.NikitaDrozdinski.finalProject.Entity.Company;
import com.NikitaDrozdinski.finalProject.Entity.Customer;
import com.NikitaDrozdinski.finalProject.Facade.AdminFacade;

import Exceptions.EntityNotPresetException;

@RestController
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	private AdminFacade adminFacade;
	
	@PostMapping("/create-company")
	public Company createCompany(@RequestBody Company company) {
		return adminFacade.createCompany(company);
		
	}

	@DeleteMapping("/delete-company/{id}")
	public Company removeCompany(@PathVariable("id") Long companyId) throws EntityNotPresetException {
		return adminFacade.removeCompany(companyId);
		
	}
	@PostMapping("/update-company")
	public Company updateCompany(@RequestBody Company company) {
		return adminFacade.updateCompany(company);
	}
	@GetMapping("/get-company/{id}")
	public Company getCompany(@PathVariable("id") Long companyId) throws EntityNotPresetException {
		return adminFacade.getCompany(companyId);
	}
	@GetMapping("/get-all-company")
	public List<Company> getAllCompany(){
		return adminFacade.getAllCompany();
	}
	@PostMapping("/create-customer")
	public Customer createCustomer(@RequestBody Customer customer) {
		return adminFacade.createCustomer(customer);
	}
	@DeleteMapping("/delete-customer/{id}")
	public Customer removeCustomer(@PathVariable("id") Long customerId) throws EntityNotPresetException {
		return adminFacade.removeCustomer(customerId);
	}
	@PostMapping("/update-customer")
	public Customer updateCustomer(@RequestBody Customer customer) {
		return adminFacade.updateCustomer(customer);
	}
	@GetMapping("/get-customer/{id}")
	public Customer getCustomer(@PathVariable("id") Long customerId) throws EntityNotPresetException {
		return adminFacade.getCustomer(customerId);
	}
	@GetMapping("/get-all-customer")
	public List<Customer> getAllCustomer(){
		return adminFacade.getAllCustomer();
	}
}













