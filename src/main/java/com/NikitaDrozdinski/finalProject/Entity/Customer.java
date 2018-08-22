package com.NikitaDrozdinski.finalProject.Entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.JoinColumn;

@Entity @Table(name = "CUSTOMERS")
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "CUSTOMER_ID")
	private long customerId;
	
	private String customerName;
	private String customerPassword;
	
	 @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	    @JoinTable(name = "CUSTOMER_COUPON",
	            joinColumns = @JoinColumn(name = "CUSTOMER_ID"), // this class
	            inverseJoinColumns = @JoinColumn(name = "COUPON_ID") // the other class
	    )
	    private Set<Coupon> coupons = new HashSet<>();


	public long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCustomerPassword() {
		return customerPassword;
	}

	public void setCustomerPassword(String customerPassword) {
		this.customerPassword = customerPassword;
	}

	@Override
	public String toString() {
		return "Customers [customerId=" + customerId + ", customerName=" + customerName + ", customerPassword="
				+ customerPassword + "]";
	}
	 public Set<Coupon> getCoupons() {
	        return coupons;
	    }
	 
	public void setCoupons(Set<Coupon> coupons) {
        this.coupons = coupons;
    }

}
