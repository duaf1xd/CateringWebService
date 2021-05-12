package dao;

import entity.Manager;

public interface ManagerDAO {
	Manager checkLogin(String username, String password);
}
