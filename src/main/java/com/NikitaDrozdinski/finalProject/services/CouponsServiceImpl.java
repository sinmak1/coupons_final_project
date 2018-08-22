package com.NikitaDrozdinski.finalProject.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.NikitaDrozdinski.finalProject.Dao.CouponDAO;
import com.NikitaDrozdinski.finalProject.Entity.Coupon;

import Exceptions.EntityNotPresetException;

@Service
public class CouponsServiceImpl implements CouponsService {

	@Autowired
	private CouponDAO couponDAO;

	@Override
	public List<Coupon> getAll() {
		return couponDAO.findAll();
	}

	@Override
	public Coupon findById(Long couponId) throws EntityNotPresetException {
		Optional<Coupon> optCoupon = couponDAO.findById(couponId);
		if (!optCoupon.isPresent()) {
			throw new EntityNotPresetException("Coupon id " + couponId + " not found");
			
		}
		return optCoupon.get();
	}

	@Override
	public Coupon save(Coupon coupon) {
		return couponDAO.save(coupon);
	}

	@Override
	public Coupon delete(Long couponId) throws EntityNotPresetException {
	Coupon coupon = findById(couponId);
	couponDAO.delete(coupon);
	return coupon;
	}

}
