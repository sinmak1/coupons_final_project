package com.NikitaDrozdinski.finalProject.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.NikitaDrozdinski.finalProject.Dao.CompanyDAO;
import com.NikitaDrozdinski.finalProject.Entity.Company;

import Exceptions.EntityNotPresetException;

@Service
public class CompanyServiceImpl implements CompanyService {

	@Autowired
	
	private CompanyDAO companyDAO;
	
	@Override
	public List<Company> getAll() {
		return companyDAO.findAll();
	}

	@Override
	public Company findById(Long companyId) throws EntityNotPresetException {
		Optional<Company> optCompany=companyDAO.findById(companyId);
		if (!optCompany.isPresent()) {
			throw new EntityNotPresetException("Company with id= "+ companyId + " not found!");
		}
		
		return optCompany.get();
	}

	@Override
	public Company save(Company company) {
		return companyDAO.save(company);
	}

	@Override
	public Company delete(Long companyId) throws EntityNotPresetException {
		Company company = findById(companyId);
		companyDAO.delete(company);
		return company;
	}

	@Override
	public boolean userExists(String companyName, String companyPassword) {
		if (companyDAO.findByCompanyNameAndCompanyPassword(companyName, companyPassword).isEmpty()) {
			return false;
		}else {
			return true;
		}

	}

}
