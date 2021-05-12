package service;

import java.util.List;

import controller.CouponDAOI;
import dao.CouponDAO;
import entity.Coupon;

public class CouponService {
	private CouponDAO couponDao;
	
	public CouponService() {
		couponDao = new CouponDAOI();
	}
	
	public void insert(Coupon coupon) {
		couponDao.insert(coupon);
	}
	
	public void update(Coupon coupon) {
		couponDao.update(coupon);
	}
	public void delete(int id) {
		couponDao.delete(id);
	}
	
	public List<Coupon> findAll() {
		return couponDao.findAll();
	}

	public Coupon findById(int id) {
		return couponDao.findById(id);
	}

	public void deleteAll() {
		couponDao.deleteAll();
	}
}
