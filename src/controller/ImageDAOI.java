package controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.hibernate.Session;

import db.HibernateUtil;
import entity.Item;

public class ImageDAOI {
public void save(int id) throws IOException {
	Session session = HibernateUtil.getSessionFactory().openSession();
	session.beginTransaction();
	     
	File file = new File("C:\\Users\\asus\\Pictures\\Saved Pictures\\image7.jpg");
	byte[] imageData = new byte[(int) file.length()];
	 
	try {
	    FileInputStream fileInputStream = new FileInputStream(file);
	    fileInputStream.read(imageData);
	    fileInputStream.close();
	} catch (Exception e) {
	    e.printStackTrace();
	}
	 
	Item item = (Item) session.get(Item.class, id);
	Item item2 = new Item();
	item2.setId(6);
	 item2.setDescription(item.getDescription());
	 item2.setImage(imageData);
	 item2.setInStock(item.getInStock());
	 item2.setName(item.getName());
	 item2.setUnit(item.getUnit());
	 item2.setPrice(item.getPrice());
	 
	 session.save(item2);
	
	 
	session.getTransaction().commit();
	
}

public void read() {
	Session session = HibernateUtil.getSessionFactory().openSession();
	session.beginTransaction();
	 
	Item item = (Item) session.get(Item.class, 2);
	byte[] bAvatar = item.getImage();
	try{
	    FileOutputStream fos = new FileOutputStream("D:\\1.jpg"); 
	    fos.write(bAvatar);
	    fos.close();
	}catch(Exception e){
	    e.printStackTrace();
	}
	 
	session.getTransaction().commit();
	
	
}
public static void main(String[] args) throws IOException {
	new ImageDAOI().save(0);
	
}
}
