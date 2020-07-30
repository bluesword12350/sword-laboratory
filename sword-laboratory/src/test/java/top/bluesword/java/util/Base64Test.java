package top.bluesword.java.util;

import cn.hutool.core.io.resource.ClassPathResource;
import org.junit.jupiter.api.Test;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Base64;

class Base64Test {

	@Test
	void decode() throws IOException {
		byte[] data;
		InputStream inputStream = new ClassPathResource("rocket.base64").getStream();
		FileOutputStream outputStream = new FileOutputStream("rocket.ico");
		try (inputStream;outputStream) {
			data = new byte[inputStream.available()];
			if (inputStream.read(data) == -1) {
				return;
			}
			byte[] decode = Base64.getDecoder().decode(data);
			outputStream.write(decode);
		}
		printBase64(data);
	}

	private void printBase64(byte[] data) {
		String encodeToString = new String(data);
		for (int start = 0;start<encodeToString.length();){
			int end = Integer.min(start+100,encodeToString.length());
			char[] chars = new char[end-start];
			encodeToString.getChars(start,end,chars,0);
			start = end;
			System.out.println(String.copyValueOf(chars));
		}
		System.out.println("data:image/x-icon;base64," + encodeToString);
	}

}