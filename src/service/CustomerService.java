package service;

import java.util.List;

import controller.CustomerDAOI;
import dao.CustomerDAO;
import entity.Customer;

public class CustomerService {
private CustomerDAO customerDao;
public CustomerService() {
	customerDao = new CustomerDAOI();
}
public int save(Customer customer) {
	return customerDao.save(customer);
}
public void delete(int id) {
	customerDao.delete(id);
}
public Customer get(int id) {
	return customerDao.get(id);
}
public List<Customer> findAll() {
	return customerDao.findAll();
}
public List<Customer> findByName(String name) {
	return customerDao.findByName(name);
}
public Customer checkLogin(String username, String password) {
	return customerDao.checkLogin(username, password);
}
public void update(Customer customer) {
	customerDao.update(customer);
}
public  Customer findCustomerByName(String username) {
	return customerDao.findCustomerByName(username);
}


}
