package org.apache.commons.codec.digest;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

class DigestUtilsTest {

	@Test
	void md5Hex() {
		String md5Hex = DigestUtils.md5Hex("SKa7Zj7E#P");
		System.out.println(md5Hex);
	}

	@Test
	void sha1(){
		System.out.println(Arrays.toString(DigestUtils.sha1("214")));
	}
}