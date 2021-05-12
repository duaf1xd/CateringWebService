package service;

import java.util.List;

import controller.OrderDAOI;
import dao.OrderDAO;
import entity.Item;
import entity.Request;

public class OrderService {
private OrderDAO orderDao;

public OrderService() {
	orderDao = new OrderDAOI();
}

public List<Request> findAll() {
	return orderDao.findAll();
}

public void update(Request request) {
	orderDao.update(request);
}
public void delete(int id) {
	orderDao.delete(id);
}
public void insert(Item item) {
	orderDao.insert(item);
}
public List<Request> findByCustomerId(int cusId) {
	return orderDao.findByCustomerId(cusId);
}
public Request findById(int id) {
	return orderDao.findById(id);
}
public void deleteUnpaidRequest() {
	orderDao.deleteUnpaidRequest();
}
public void deleteRequest(int id) {
	orderDao.deleteRequest(id);
}


public void deletePaidItems() {
	orderDao.deletePaidItems();
}

public List<Request> sortByAscStatus(String orderBy) {
	return orderDao.sortByAscStatus(orderBy);
}
}
