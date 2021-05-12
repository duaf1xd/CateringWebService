package dao;

import java.util.List;
import entity.Coupon;

public interface CouponDAO {
	void insert(Coupon coupon);
	void update(Coupon coupon);
	void delete(int id);
	List<Coupon> findAll();
	Coupon findById(int id);
	void deleteAll();
	Coupon getAvailableCoupon();
}
