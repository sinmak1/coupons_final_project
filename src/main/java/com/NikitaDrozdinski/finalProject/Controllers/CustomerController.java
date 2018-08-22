package com.NikitaDrozdinski.finalProject.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.NikitaDrozdinski.finalProject.Entity.Coupon;
import com.NikitaDrozdinski.finalProject.Entity.CouponType;
import com.NikitaDrozdinski.finalProject.Facade.CustomerFacade;
import Exceptions.CouponTypeAlreadPurchasedException;
import Exceptions.EntityNotPresetException;

@RestController
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	private CustomerFacade customerFacade;
	
	

	@PostMapping("/purchase-coupon/{customerId}/{couponId}")
	public Coupon purchaseCoupon(@PathVariable("couponId") Long couponId, @PathVariable("customerId") Long customerId)
			throws EntityNotPresetException, CouponTypeAlreadPurchasedException {
		return customerFacade.purchaseCoupon(couponId, customerId);

	}

	@GetMapping("/get-all-coupon/{id}")
	public List<Coupon> getAllPurchasedCoupon(@PathVariable("id") Long customerId) throws EntityNotPresetException {
		return customerFacade.getAllPurchasedCoupon(customerId);

	}

	@GetMapping("/getAllPurchasedCouponByType/{id}/{type}")
	public List<Coupon> getAllPurchasedCouponByType(@PathVariable("type") CouponType couponType,
			@PathVariable("id") Long customerId) throws EntityNotPresetException {
		return customerFacade.getAllPurchasedCouponByType(couponType, customerId);

	}
}
