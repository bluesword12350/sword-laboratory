package top.bluesword.java.util;

import cn.hutool.core.io.resource.ClassPathResource;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Base64;

class Base64Test {

	@Test
	void encodeTest() {
		byte[] data = null;
		try (InputStream inputStream = new ClassPathResource("swords.ico").getStream()) {
			data = new byte[inputStream.available()];
			System.out.println(inputStream.read(data));
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		String encodeToString = Base64.getEncoder().encodeToString(data);
		System.out.println("data:image/png;base64," + encodeToString);
	}
}