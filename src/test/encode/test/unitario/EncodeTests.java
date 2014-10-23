package encode.test.unitario;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import encode.MD5Criptografia;
import encode.Sha1;

public class EncodeTests {
	MD5Criptografia md5;
	private String test;
	private String result;

	@SuppressWarnings("static-access")
	@Test
	public void testMD5() throws Exception {
		test = "123";
		result = "202cb962ac59075b964b07152d234b70";
		assertEquals(result, md5.Md5hash(test));
	}

	@Test
	public void testSha1() throws Exception {
		test = "123";
		result = "40bd001563085fc35165329ea1ff5c5ecbdbbeef";
		assertEquals(result, Sha1.SHA1Hash(test));
	}

}
