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
import com.NikitaDrozdinski.finalProject.Entity.Coupon;
import com.NikitaDrozdinski.finalProject.Facade.CompanyFacade;
import Exceptions.EntityNotPresetException;

@RestController
@RequestMapping("/company")
public class CompanyController {

	@Autowired
	private CompanyFacade companyFacade;

	@PostMapping("/create-coupon/{id}")
	public Coupon createCoupon(@PathVariable("id") Long companyId, @RequestBody Coupon coupon)
			throws EntityNotPresetException {
		return companyFacade.createCoupon(companyId, coupon);

	}

	@DeleteMapping("/remove-coupon/{id}")
	public Coupon removeCoupon(@PathVariable("id") Long couponId) throws EntityNotPresetException {
		return companyFacade.removeCoupon(couponId);

	}

	@PostMapping("/update-coupon")
	public Coupon updateCoupon(@RequestBody Coupon coupon) {
		return companyFacade.updateCoupon(coupon);

	}

	@GetMapping("/get-coupon/{id}")
	public Coupon getCoupon(@PathVariable("id") Long couponId) throws EntityNotPresetException {
		return companyFacade.getCoupon(couponId);
	}

	@GetMapping("get-all-coupon/{id}")
	public List<Coupon> getAllCoupon(@PathVariable("id") Long companyId) throws EntityNotPresetException {
		return companyFacade.getAllCoupon(companyId);
	}
}
