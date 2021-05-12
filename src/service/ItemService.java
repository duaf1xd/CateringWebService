package service;

import java.util.List;

import controller.ItemDAOI;
import dao.ItemDAO;
import entity.Item;

public class ItemService {
	private ItemDAO itemDao;
	
	public ItemService() {
		itemDao = new ItemDAOI();
	}
	
	public void insert(Item item) {
		itemDao.insert(item);
	}
	
	public void update(Item item) {
		itemDao.update(item);
	}
	public void delete(int id) {
		itemDao.delete(id);
	}
	
	public List<Item> findAll() {
		return itemDao.findAll();
	}

	public Item findById(int id) {
		return itemDao.findById(id);
	}

	public void deleteAll() {
		itemDao.deleteAll();
	}
}
