package com.NikitaDrozdinski.finalProject.Dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.NikitaDrozdinski.finalProject.Entity.Coupon;

public interface CouponDAO extends JpaRepository<Coupon, Long> {

}
