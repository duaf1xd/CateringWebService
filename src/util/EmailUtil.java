package util;


import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;

public class EmailUtil {
//	public static final String HOST_NAME = "smtp.gmail.com";
//	 
//    public static final int SSL_PORT = 465; // Port for SSL
// 
//    public static final int TSL_PORT = 587; // Port for TLS/STARTTLS
// 
//    public static final String APP_EMAIL = "winddra777@gmail.com"; // your email
// 
//    public static final String APP_PASSWORD = "vzhqmgxvmzxcsdci"; // your password

public static void sendCouponCode(String receiveEmail, String code, String hostName, int sslPort, int tslPort, String gmail, String password) throws EmailException {
	Email email = new SimpleEmail();
	email.setHostName(hostName);
	email.setSmtpPort(sslPort);
	email.setAuthentication(gmail, password);
	email.setSSLOnConnect(true);
	email.setFrom(gmail);
	email.addTo(receiveEmail);
	email.setSubject("Coupon code");
	email.setMsg(code);
	email.send();
	
}
}
