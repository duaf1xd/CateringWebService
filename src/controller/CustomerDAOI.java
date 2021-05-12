package controller;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Order;

import dao.CustomerDAO;
import db.HibernateUtil;
import entity.Customer;
import util.PasswordUtil;





public class CustomerDAOI implements CustomerDAO{

	public int save(Customer customer) {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		int id = (int) session.save(customer);
		session.getTransaction().commit();
		session.close();
		return id;
		
	}

	public void delete(int id) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		Customer customer = new Customer();
		customer.setId(id);
		session.delete(customer);
		session.getTransaction().commit();
		session.close();
		
	}

	public Customer get(int id) {
		// TODO Auto-generated method stub
		return (Customer) HibernateUtil.getSessionFactory().openSession().get(Customer.class, id);
		
	}

	@SuppressWarnings("unchecked")
	public List<Customer> findAll() {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.getSessionFactory().openSession();

		Query query = session.createQuery("FROM Customer order by name asc");
		return query.list();
	}

	@SuppressWarnings("unchecked")
	public List<Customer> findByName(String name) {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.getSessionFactory().openSession();
		Query query = session.createQuery("FROM Customer where name = :name");
		query.setParameter("name", name);
		return query.list();
	}


	public Customer checkLogin(String username, String password) {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.getSessionFactory().openSession();
		Query query = session.createQuery("FROM Customer where username = :username and password = :password");
		query.setParameter("username", username);
		query.setParameter("password", PasswordUtil.encrytpPassword(password));
		return (Customer) query.uniqueResult();
	}
	
	public void update(Customer customer) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		session.update(customer);
		session.getTransaction().commit();
		session.close();
	}
	
	public List<Customer> sortByCriteria(String criteria) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Criteria cr = session.createCriteria(Customer.class);
		cr.addOrder(Order.asc(criteria));
		return cr.list();
	}

	@Override
	public Customer findCustomerByName(String username) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Query query = session.createQuery("FROM Customer where username = :username");
		query.setParameter("username", username);
		return (Customer) query.uniqueResult();
	}


	

}
