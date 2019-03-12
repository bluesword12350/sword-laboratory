package org.apache.commons.codec.digest;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

class DigestUtilsTest {

	@Test
	void md5HexTest() {
		String md5Hex = DigestUtils.md5Hex("1").substring(9, 25);
		System.out.println(md5Hex);
		System.out.println(md5Hex.length());
	}

	@Test
	void sha1(){
		System.out.println(Arrays.toString(DigestUtils.sha1("214")));
	}
}