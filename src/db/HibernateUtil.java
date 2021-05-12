package db;

import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;



public class HibernateUtil {
	private static SessionFactory sessionFactory = null;
	static {
		try {
			Logger logger = Logger.getLogger("org.hibernate");
			logger.setLevel(Level.OFF);
      	    System.setProperty("org.apache.commons.logging.Log",
            	    "org.apache.commons.logging.impl.NoOpLog");
      	    ResourceBundle rb = ResourceBundle.getBundle("oracle");
      	    Configuration cfg = new Configuration();
      	    cfg.configure("hibernate.cfg.xml");
      	  cfg.setProperty("hibernate.connection.url", rb.getString("db.url"));
          cfg.setProperty("hibernate.connection.username", rb.getString("db.username"));
          cfg.setProperty("hibernate.connection.password", rb.getString("db.password"));     
          sessionFactory = cfg.buildSessionFactory();
          

		} catch(Throwable e) {
			e.printStackTrace();
		}
	}
	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}
}
