package com.NikitaDrozdinski.finalProject.Dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.NikitaDrozdinski.finalProject.Entity.Company;

public interface CompanyDAO extends JpaRepository<Company, Long>{
	
	List<Company> findByCompanyNameAndCompanyPassword(String companyName, String companyPassword);
	
}
