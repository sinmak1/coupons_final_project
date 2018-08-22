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
import com.NikitaDrozdinski.finalProject.services.CouponsService;

import Exceptions.EntityNotPresetException;

@RestController
@RequestMapping("/coupons")
public class CouponsController {

	@Autowired
	private CouponsService couponsService;

	@GetMapping("/")
	public List<Coupon> getAll() {
		return couponsService.getAll();
	}

	@GetMapping("/{id}")
	public Coupon findById(@PathVariable("id") Long couponId) throws EntityNotPresetException {
		return couponsService.findById(couponId);
	}

	@PostMapping("/")
	public Coupon create(@RequestBody Coupon coupon) {
		return couponsService.save(coupon);

	}

	@DeleteMapping("/{id}")
	public Coupon delete(@PathVariable("id") Long couponId) throws EntityNotPresetException {
		return couponsService.delete(couponId);
	}
}
