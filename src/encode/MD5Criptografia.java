package encode;

import java.math.BigInteger;
import java.security.MessageDigest;

public class MD5Criptografia {
	public static String Md5hash(String input) throws Exception {
		MessageDigest m = MessageDigest.getInstance("MD5");
		m.update(input.getBytes(), 0, input.length());
		return new BigInteger(1, m.digest()).toString(16);
	}

}
