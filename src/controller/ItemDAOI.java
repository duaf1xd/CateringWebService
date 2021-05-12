package controller;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import dao.ItemDAO;
import db.HibernateUtil;
import entity.Customer;
import entity.Item;

public class ItemDAOI implements ItemDAO{
	
	@Override
	public void insert(Item item) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		session.save(item);
		session.getTransaction().commit();
		session.close();
	}

	@Override
	public void update(Item item) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		session.update(item);
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
	public Item findById(int id) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Item item = (Item) session.get(Item.class, id);
		return item;
	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int save(Item item) {
		// TODO Auto-generated method stub
		return 0;
	}



	@Override
	public Item get(int id) {
		// TODO Auto-generated method stub
		return (Item) HibernateUtil.getSessionFactory().openSession().get(Item.class, id);
	}

	@Override
	public List<Item> findAll() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Query query = session.createQuery("FROM Item order by id asc");
		List<Item> itemList = query.list();
		return itemList;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Item> findAllAvailable() {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.getSessionFactory().openSession();

		Query query = session.createQuery("FROM Item where in_stock=1 order by id asc");
		return query.list();
	}

	@Override
	public List<Item> findByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

}
