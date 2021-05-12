package dao;

import java.util.List;

import entity.Item;

public interface ItemDAO {
	void insert(Item item);
	void update(Item item);
	void delete(int id);
	List<Item> findAllAvailable();
	Item findById(int id);
	void deleteAll();
	int save(Item item);
	Item get(int id);
	List<Item> findByName(String name);
	List<Item> findAll();
}
