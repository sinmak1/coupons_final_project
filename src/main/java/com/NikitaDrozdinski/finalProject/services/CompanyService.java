package com.NikitaDrozdinski.finalProject.services;

import java.util.List;

import com.NikitaDrozdinski.finalProject.Entity.Company;

import Exceptions.EntityNotPresetException;

public interface CompanyService {

	List<Company> getAll();

	Company findById(Long companyId) throws EntityNotPresetException;

	Company save(Company company);

	Company delete(Long companyId) throws EntityNotPresetException;

	boolean userExists(String companyName, String companyPassword);

}
