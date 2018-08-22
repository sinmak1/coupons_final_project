package com.NikitaDrozdinski.finalProject.Sistem;

import org.springframework.beans.factory.annotation.Autowired;

import com.NikitaDrozdinski.finalProject.Facade.AdminFacade;
import com.NikitaDrozdinski.finalProject.Facade.ClientType;
import com.NikitaDrozdinski.finalProject.Facade.CompanyFacade;
import com.NikitaDrozdinski.finalProject.Facade.CouponClientFacade;
import com.NikitaDrozdinski.finalProject.Facade.CustomerFacade;

import Exceptions.ClinetNotFoundException;

public class CouponSistem {
	
	@Autowired
	private AdminFacade adminFacade;
	@Autowired
	private CustomerFacade customerFacade;
	@Autowired
	private CompanyFacade comapnyFacade;
	
	
	public CouponClientFacade login(String name , String password , ClientType type) throws ClinetNotFoundException, ClassNotFoundException {
		if (type == ClientType.ADMIN) {
			return adminFacade.login(name, password, type);
		}else if(type == ClientType.COMPANY) {
			return comapnyFacade.login(name, password, type);
		}else if(type == ClientType.CUSTOMER) {
			return customerFacade.login(name, password, type);
		}
		return null;
	}

}
