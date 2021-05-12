package dao;

import java.util.List;

import entity.Customer;


public interface CustomerDAO {
int save(Customer customer);
void delete(int id);
Customer get(int id);
List<Customer> findAll();
List<Customer> findByName(String name);
Customer checkLogin(String username, String password);
void update(Customer customer);
Customer findCustomerByName(String username);
}
