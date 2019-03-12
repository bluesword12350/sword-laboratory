package org.apache.commons.codec.digest;

import org.junit.jupiter.api.Test;

class HmacUtilsTest {

	@Test
	void hmacSha256HexTest(){
		System.out.println(new HmacUtils(HmacAlgorithms.HMAC_SHA_256, "1").hmacHex(""));
	}
}