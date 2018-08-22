package com.NikitaDrozdinski.finalProject.Facade;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.NikitaDrozdinski.finalProject.Entity.Coupon;
import com.NikitaDrozdinski.finalProject.Entity.CouponType;
import com.NikitaDrozdinski.finalProject.Entity.Customer;
import com.NikitaDrozdinski.finalProject.services.CouponsService;
import com.NikitaDrozdinski.finalProject.services.CustomerService;

import Exceptions.CouponTypeAlreadPurchasedException;
import Exceptions.EntityNotPresetException;

@Service
public class CustomerFacade implements CouponClientFacade {

	@Autowired
	private CustomerService customerService;
	
	@Autowired
	private CouponsService couponsService;

	@Override
	public CouponClientFacade login(String name, String password, ClientType type) throws ClassNotFoundException {
		if (customerService.userExists(name,password)) {
			return this;
		}else {
			throw new ClassNotFoundException("Customer Name or password not found");
		}
	}

	
	public Coupon purchaseCoupon(Long couponId, Long customerId) throws EntityNotPresetException, CouponTypeAlreadPurchasedException {
		Coupon coupon = couponsService.findById(couponId);
		Customer customer = customerService.findById(customerId);
		List<Coupon> coupons = getAllPurchasedCoupon(customerId);	
		for (Coupon c : coupons) {
			if (c.getCouponType().equals(coupon.getCouponType())) {
				throw new CouponTypeAlreadPurchasedException("Coupon with type " + c.getCouponType() + " already pyrchased");
			}
		}
		customer.getCoupons().add(coupon);
		return coupon;
	}

	public List<Coupon> getAllPurchasedCoupon(Long customerId) throws EntityNotPresetException {
		Customer customer = customerService.findById(customerId);
		return new ArrayList<Coupon>(customer.getCoupons());

	}

	public List<Coupon> getAllPurchasedCouponByType(CouponType couponType, Long customerId)
			throws EntityNotPresetException {
		List<Coupon> coupons = getAllPurchasedCoupon(customerId);
		List<Coupon> couponsByType = new ArrayList<>();
		for (Coupon coupon : coupons) {
			if (couponType == coupon.getCouponType()) {
				couponsByType.add(coupon);

			}

		}

		return couponsByType;
	}

}
