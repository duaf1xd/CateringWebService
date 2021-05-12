package util;

import java.math.BigInteger;
import java.security.MessageDigest;

public class PasswordUtil {
public static String encrytpPassword(String pass) {
	StringBuilder builder = new StringBuilder();
	MessageDigest digest;
	try {
		digest = MessageDigest.getInstance("SHA-256");
		digest.reset();
		digest.update(pass.getBytes());
		BigInteger integer = new BigInteger(1, digest.digest());
		builder.append(integer.toString());
	} catch(Exception e) {
		e.printStackTrace();
	}
	return builder.toString();
}

}
