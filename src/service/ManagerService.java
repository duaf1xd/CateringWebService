package service;

import controller.ManagerDAOI;
import dao.ManagerDAO;
import entity.Manager;

public class ManagerService {
private ManagerDAO managerDao;
public ManagerService() {
	managerDao = new ManagerDAOI();
}
public Manager checkLogin(String username, String password) {
	return managerDao.checkLogin(username, password);
}
}
