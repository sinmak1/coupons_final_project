package com.NikitaDrozdinski.finalProject.services;

import java.util.List;

import com.NikitaDrozdinski.finalProject.Entity.Coupon;

import Exceptions.EntityNotPresetException;

public interface CouponsService {

	List<Coupon> getAll();

	Coupon findById(Long couponId) throws EntityNotPresetException;

	Coupon save(Coupon coupon);

	Coupon delete(Long couponId) throws EntityNotPresetException;

}