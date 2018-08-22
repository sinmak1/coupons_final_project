package com.NikitaDrozdinski.finalProject.Facade;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.NikitaDrozdinski.finalProject.Entity.Company;
import com.NikitaDrozdinski.finalProject.Entity.Coupon;
import com.NikitaDrozdinski.finalProject.Entity.CouponType;
import com.NikitaDrozdinski.finalProject.services.CompanyService;
import com.NikitaDrozdinski.finalProject.services.CouponsService;

import Exceptions.EntityNotPresetException;

@Service
public class CompanyFacade implements CouponClientFacade {
	
	@Autowired
	private CompanyService companyServis;

	@Autowired
	private CouponsService couponsService;

	@Override
	public CouponClientFacade login(String name, String password, ClientType type) throws ClassNotFoundException {
		if (companyServis.userExists(name, password)) {
			return this;
		}else {
			throw new ClassNotFoundException("Company name or password inkorect");
		}
	}

	public Coupon createCoupon(Long companyId, Coupon coupon) throws EntityNotPresetException {
		Company company = companyServis.findById(companyId);
		couponsService.save(coupon);
		company.getCoupons().add(coupon);
		companyServis.save(company);
		return coupon;

	}

	// public Coupon removeCoupon(Long couponId , Long companyId ) {
	//
	// Coupon coupon = couponsService.findById(couponId);
	// Company company = companyServis.findById(companyId);
	// company.getCoupons().remove(coupon);
	// companyServis.save(company);
	// return couponsService.delete(couponId);
	// }

	public Coupon removeCoupon(Long couponId) throws EntityNotPresetException {
		return couponsService.delete(couponId);
	}

	public Coupon updateCoupon(Coupon coupon) {
		return couponsService.save(coupon);
	}

	public Coupon getCoupon(Long couponId) throws EntityNotPresetException {
		return couponsService.findById(couponId);
	}

	public List<Coupon> getAllCoupon(Long companyId) throws EntityNotPresetException {
		Company company = companyServis.findById(companyId);
		return new ArrayList<Coupon>(company.getCoupons());
	}

	public List<Coupon> getCouponByTypes(CouponType couponTypes, Long companyId) throws EntityNotPresetException {
		List<Coupon> coupons = getAllCoupon(companyId);
		List<Coupon> couponsByType = new ArrayList<>();
		for (Coupon coupon : coupons) {
			if (coupon.getCouponType() == couponTypes) {
				couponsByType.add(coupon);
			}
		}
		return couponsByType;
		
//		return getAllCoupon(companyId).stream().filter(coupon -> coupon.getCouponType() == couponTypes).collect(Collectors.toList());
		
	}
}
