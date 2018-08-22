package com.NikitaDrozdinski.finalProject.Utils;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.NikitaDrozdinski.finalProject.Dao.CouponDAO;
import com.NikitaDrozdinski.finalProject.Entity.Coupon;

public class DeleteExpiredCoupons implements Runnable {

	@Autowired
	private CouponDAO couponDAO;

	@Override
	public void run() {
		while (true) {
			List<Coupon> coupons = couponDAO.findAll();
			List<Coupon> expiredCoupons = new ArrayList<>();
			for (Coupon coupon : coupons) {
				if (coupon.getCouponEndDate().isBefore(LocalDate.now())) {
					expiredCoupons.add(coupon);
				}

			}
			try {
				Thread.sleep(1000 * 60 * 60 * 24);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			couponDAO.deleteAll(expiredCoupons);
		}

	}

}
