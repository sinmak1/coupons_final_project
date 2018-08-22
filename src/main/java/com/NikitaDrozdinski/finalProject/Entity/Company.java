package com.NikitaDrozdinski.finalProject.Entity;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.JoinColumn;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity @Table(name = "Companys")
public class Company {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "COMPANY_ID")
	private long companyId;
	
	private String companyName;
	private String companyPassword;
	private String companyEmail;
	
	@ManyToMany(cascade = CascadeType.REMOVE)
    @JoinTable(name = "COMPANY_COUPON",
            joinColumns = @JoinColumn(name = "COMPANY_ID"), // this class
            inverseJoinColumns = @JoinColumn(name = "COUPON_ID") // the other class
    )
    private Set<Coupon> coupons = new HashSet<>();


	

	public long getCompanyId() {
		return companyId;
	}

	public void setCompanyId(int companyId) {
		this.companyId = companyId;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getCompanyPassword() {
		return companyPassword;
	}

	public void setCompanyPassword(String companyPassword) {
		this.companyPassword = companyPassword;
	}

	public String getCompanyEmail() {
		return companyEmail;
	}

	public void setCompanyEmail(String companyEmail) {
		this.companyEmail = companyEmail;
	}
	
	public Set<Coupon> getCoupons() {
        return coupons;
    }
	
	  public void setCoupons(Set<Coupon> coupons) {
	        this.coupons = coupons;
	    }

	@Override
	public String toString() {
		return "Company [companyId=" + companyId + ", companyName=" + companyName + ", companyPassword="
				+ companyPassword + ", companyEmail=" + companyEmail + "]";
	}

}
