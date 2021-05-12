package controller;






import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import dao.CouponDAO;
import db.HibernateUtil;
import entity.Coupon;
import entity.Customer;
import entity.Item;


public class CouponDAOI implements CouponDAO{
	
	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public Coupon findById(int id) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Coupon coupon = (Coupon) session.get(Coupon.class, id);
		return coupon;
	}
	
	@Override
	public List<Coupon> findAll() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Query query = session.createQuery("FROM Coupon c ORDER BY c.id");
		List<Coupon> couponList = query.list();
		return couponList;
	}
	
	@Override
	public void update(Coupon coupon) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		session.update(coupon);
		session.getTransaction().commit();
		session.close();
	}
	
	@Override
	public void delete(int id) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();		
		Coupon coupon = new Coupon();
		coupon.setId(id);
		session.delete(coupon);
		session.getTransaction().commit();
		session.close();
	}

	@Override
	public Coupon getAvailableCoupon() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Query query = session.createQuery("FROM Coupon WHERE current_usage_count < max_usage_count");
	Coupon coupon = (Coupon) query.uniqueResult();
	return coupon;
	}

	public Coupon findCouponByCode(String code) {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.getSessionFactory().openSession();
		Query query = session.createQuery("FROM Coupon WHERE code = :code");
		query.setParameter("code", code);
		return (Coupon) query.uniqueResult();
	}

	public void useCoupon(String code) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		Query query = session.createQuery("UPDATE Coupon SET current_usage_count= current_usage_count+1 WHERE code = :code");
		query.setParameter("code", code);
		query.executeUpdate();
		session.getTransaction().commit();
	}
	
	@Override
	public void insert(Coupon coupon) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		session.save(coupon);
		session.getTransaction().commit();
		session.close();
	}
//	@Override
//	public Coupon get() {
//		Session session = HibernateUtil.getSessionFactory().openSession();
//		Query query = session.createQuery("FROM Coupon WHERE current_usage_count < max_usage_count");
//		return (Coupon) query.uniqueResult();
//		 
//	}
	
//	public Coupon getByRequestId(int id) {
//		Session session = HibernateUtil.getSessionFactory().openSession();
//		Query query = session.createQuery("FROM Coupon where item = :item");
//		Item item = new Item();
//		item.setId(id);
//		query.setParameter("item", item);
//		return (Coupon) query.uniqueResult();
//	}
	

}
