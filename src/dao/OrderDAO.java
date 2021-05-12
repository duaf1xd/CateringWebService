package dao;



import java.util.List;

import entity.Item;
import entity.Request;

public interface OrderDAO {
void update(Request request);
void delete(int id);
void insert(Request request);
List<Request> findByCustomerId(int cusId);
Request findById(int id);
void deleteAll();
void deleteRequest(int id);
List<Item> getItemByRequestId(int id);
List<Request> findAll();
void deleteUnpaidRequest();
void insert(Item item);
void deletePaidItems();
List<Request> sortByAscStatus(String orderBy);
}
