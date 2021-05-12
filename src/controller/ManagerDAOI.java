package controller;

import org.hibernate.Query;
import org.hibernate.Session;

import dao.ManagerDAO;
import db.HibernateUtil;
import entity.Manager;
import util.PasswordUtil;

public class ManagerDAOI implements ManagerDAO{

	@Override
	public Manager checkLogin(String username, String password) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Query query = session.createQuery("FROM Manager where username = :username and password = :password");
		query.setParameter("username", username);
		query.setParameter("password", PasswordUtil.encrytpPassword(password));
		return (Manager) query.uniqueResult();
	}

}
