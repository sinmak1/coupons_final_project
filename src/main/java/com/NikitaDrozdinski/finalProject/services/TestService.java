package com.NikitaDrozdinski.finalProject.services;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.Set;
import java.time.LocalDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.NikitaDrozdinski.finalProject.Dao.CompanyDAO;
import com.NikitaDrozdinski.finalProject.Dao.CouponDAO;
import com.NikitaDrozdinski.finalProject.Dao.CustomerDAO;
import com.NikitaDrozdinski.finalProject.Entity.Company;
import com.NikitaDrozdinski.finalProject.Entity.Coupon;
import com.NikitaDrozdinski.finalProject.Entity.Customer;

@Service
public class TestService {
	private final CustomerDAO customerDao;
	private final CouponDAO couponDao;
	private final CompanyDAO companyDao;

	private Random random = new Random();
	
	@Autowired
	private CompanyDAO cDao;
	
	public Company getCompany(Long id) {
		Optional<Company> opt = cDao.findById(id);
		if (opt.isPresent()) {
			return opt.get();
		} else {
			return null;
		}
	}
	
	@Autowired
	public TestService(CustomerDAO customerDao, CouponDAO couponDao, CompanyDAO companyDao) {
		this.customerDao = customerDao;
		this.couponDao = couponDao;
		this.companyDao = companyDao;
	}

	public Customer testCustomer(int couponsNumber) {
		Set<Coupon> coupons = getRandomCoupons(couponsNumber);
		Customer customer = createCustomer(null);
		customer.getCoupons().addAll(coupons);
		customerDao.save(customer);
		final Optional<Customer> customerFromDB = customerDao.findById(customer.getCustomerId());
		return customerFromDB.get();
	}

	public Company testCompany(int couponsNumber) {
		Set<Coupon> coupons = getRandomCoupons(couponsNumber);
		Company company = createCompany(null);
		company.getCoupons().addAll(coupons);
		companyDao.save(company);
		final Optional<Company> companyFromDB = companyDao.findById(company.getCompanyId());
		return companyFromDB.get();
	}

	private Set<Coupon> getRandomCoupons(int couponsNumber) {
		final List<Coupon> all = couponDao.findAll();
		Set<Integer> numbers = new HashSet<>(couponsNumber);
		while (numbers.size() < couponsNumber) {
			numbers.add(random.nextInt(all.size()));
		}
		Set<Coupon> coupons = new HashSet<>(couponsNumber);
		numbers.forEach(i -> coupons.add(all.get(i)));
		return coupons;
	}

	private Company createCompany(Coupon coupon) {
		final Company company = new Company();
		company.setCompanyName(createString("company"));
		company.setCompanyPassword(createPassword());
		if (coupon != null) {
			company.getCoupons().add(coupon);
		}
		return company;
	}

	private Customer createCustomer(Coupon coupon) {
		Customer customer = new Customer();
		customer.setCustomerName(createString("customer"));
		customer.setCustomerPassword(createPassword());
		if (coupon != null) {
			customer.getCoupons().add(coupon);
		}
		return customer;
	}

	private Coupon createCoupon() {
		final Coupon coupon = new Coupon();
		coupon.setCouponStartDate(LocalDate.now().minusDays(random.nextInt(100)));
		coupon.setCouponEndDate(LocalDate.now().plusDays(random.nextInt(100)));
		coupon.setCouponTitle(createString("title"));
		return coupon;
	}

	private String createPassword() {
		return String.valueOf(random.nextInt(1000000) + 10000);
	}

	private String createString(String prefix) {
		return prefix + "-" + random.nextInt(100000);
	}

	public Set<Coupon> generateCoupons() {
		for (int i = 0; i < 100; i++) {
			couponDao.save(createCoupon());
		}
		return new HashSet<>(couponDao.findAll());
	}
}