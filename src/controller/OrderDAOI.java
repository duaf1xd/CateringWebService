package controller;



import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import dao.OrderDAO;
import db.HibernateUtil;
import entity.Item;
import entity.Request;

public class OrderDAOI implements OrderDAO {

	@Override
	public void update(Request request) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		session.merge(request);
		session.getTransaction().commit();
		session.close();
	}

	@Override
	public void delete(int id) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();		
		Item item = new Item();
		item.setId(id);
		session.delete(item);
		session.getTransaction().commit();
		session.close();
		
	}

	@Override
	public void deleteUnpaidRequest() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		Query query = session.createQuery("DELETE FROM Request where status = 0");
		query.executeUpdate();
		session.getTransaction().commit();
		session.close();
		
	}
	public void deletePaidItems() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		Query query = session.createQuery("DELETE FROM Request where status = 1");
		query.executeUpdate();
		session.getTransaction().commit();
		session.close();
	}

	@Override
	public void deleteRequest(int id) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();		
		Request request = new Request();
		request.setId(id);
		session.delete(request);
		session.getTransaction().commit();
		session.close();
		
	}
	
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Request> findAll() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Query query = session.createQuery("FROM Request order by requestTime asc");
		return query.list();
		
	}
	
	@SuppressWarnings("unchecked")
	public List<Request> sortByAscStatus(String orderBy) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		String hql = "FROM Request order by status ";
		if(orderBy.equals("asc")) {
			hql += "asc";
		} else {
			hql += "desc";
		}
		Query query = session.createQuery(hql);
		return query.list();
	}

	@Override
	public List<Request> findByCustomerId(int cusId) {
	Session session = HibernateUtil.getSessionFactory().openSession();
	Query query = session.createQuery("FROM Request WHERE customer_id = :cusId order by id");
	query.setParameter("cusId", cusId);
	return (List<Request>) query.list();
	
	}

	@Override
	public void insert(Item item) {
		
		
	}
	
	@Override
	public Request findById(int id) {
		return (Request) HibernateUtil.getSessionFactory().openSession().get(Request.class, id);
	}

	@Override
	public void deleteAll() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		Query query = session.createQuery("DELETE FROM Request where status = 0");
		query.executeUpdate();
		session.getTransaction().commit();
		session.close();
		
	}



	@Override
	public List<Item> getItemByRequestId(int id) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Query query = session.createQuery("FROM Item WHERE request_id = :request_id order by id");
		query.setParameter("request_id", id);
		return (List<Item>) query.list();
	}

	@Override
	public void insert(Request request) {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		session.save(request);
		session.getTransaction().commit();
		session.close();
		
	}
	
	

}
