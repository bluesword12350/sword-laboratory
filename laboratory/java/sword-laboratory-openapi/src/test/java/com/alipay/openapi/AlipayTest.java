package com.alipay.openapi;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Base64;

import org.apache.commons.codec.CharEncoding;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.domain.AlipayTradePrecreateModel;
import com.alipay.api.request.AlipayTradePrecreateRequest;
import com.alipay.api.response.AlipayTradePrecreateResponse;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;

public class AlipayTest {
	void alipayTradePrecreateTest() {
		final String APP_PRIVATE_KEY = "MIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQCVVA4k5b+xF3W6Y3s+pPHYqYGgdXLgy4F8E8IMJUPuUsu"
				+ "JSTZ/l4lrTTgkMmfWTv9ILinkRpSkxZiwIgM6aa5lSPaSf24NRnQ3jM2HxrU+OPRdFTkSLXS7/8kL2grGRL9jPwxeuX0BANM1sfxj3uPTxZjM36HLrjy"
				+ "Xsd4rPexkC1+8VRFRGhQL12r2DwTnIv5pv5OIy/srwYzcdjVHF7PtGRjoC50Nsd5mfW1qLN6RU5fZZ4jBXVSXEoZMuGgx1U8kpnYXXA40TVJosdtY313"
				+ "ZTQrxE5f5WM+ZR/URW7UI6xUTDSyvbC0L0BVy+na70cWSxw0OwaQg5+qKl9u+0vjfAgMBAAECggEADHDYTNKnScW+lSy8k9eCHp7godGnJHtP6lprDD/"
				+ "+jNhxBJsI41BornvcdYeNhxlFw2m1K8OFlsSvl9z9j9xGH0IY6NOdA5YfEJG2fd1cNDbihO7DtnP7Cb6hrU8ZHrOTjl0uVqX1eCPtdMfDUz66lGYd+NO"
				+ "Y0zNM8QZskAW0sBDx4SqXmHiq6e6Bar/1WQm6Tjia9BwfhkTz1ASXIqB+ZvtOND7KithWlf2xEGrjFUs/Rw4r+hQ7sVv+2G/tzt1ywY2slb9nY+avWjc"
				+ "dIntq1uAH1tZFUlmF+3X+le6Upjr18jjmuDd+wfFHlF+Cz63gxzEdOq+fb1pcKaXdrmUgQQKBgQDP2d6mtNjDqWbkhljAekAGlWTej/bvpZBMNbnMx5J"
				+ "8/PTGOOhapCe0oXhv5YWCCEfWhZB86BDA0wpHx2AR322LjUzboeQDLnzy47zWIvQFd0Y3kmwor4CJMR3dTE6wdcM75NxAfHyChoYExtCkSghPMMu0pUW"
				+ "76cKRI9J+RaB1VwKBgQC366FUJhbFGor/6D1LsWJXqvUwh/kSKeXCwzkqdQkC0y4FD61Zl1p1nc81fteVim/guiwMxljfRaQVzZuPlHTQ9Co91p4/wXM"
				+ "yp1mTS6YUMkFmdW+J5A/F5FIhto4dqv4EcrMJB1Jc/zE82xerGQulCA8ElqSBTQEs8+XXjbIbuQKBgBM4JipsFo8hHu6KrbI+m6UAM2+RCFhoistBPIj"
				+ "++0Crc0bRBEs9Wp6NP8G5C3tWoK3pc87Y9pOd8BlrCisc6dg5nJ3Cfn780Xj0LgXu/Xlz6f5Bf9bTQ6Nr80L/R1dxzDfBlcwwtqKrJcFTUP+gCNypumx"
				+ "dy/DwUJlzIoeikI/JAoGBAJrIMKNS0sLaTbSETGGRTQQeme5X4GNK41P/W/LBP+4ir44O3YKSf8yQHLwWnXP6Z6EmzL+LhWuRfj/jI1G4TH81nP8hyVg"
				+ "6g6pTcG0nswM4MBX8KvxO9H9EYWKB8iRBrTktFkM46DXfhh6C++5AS659k7X22Ub/+UdNk1bOpt/xAoGBAI1+yh0BpLXWqZ0Jw/TyvaGjZb4cxeTOLRC"
				+ "xhteS6cWAdnhDxmMOmKmbXLurznpees1k7xoiauw8WtvAzCnDM8gZ6hqQnP+40tEeBY/hxWXVL7pd1y4TzLZJ72gtCBS2BmjyyfAJev/lByBh63kV4RO"
				+ "Jj/1s7oANMAWouPtuoT/L";
		
		final String ALIPAY_PUBLIC_KEY = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAnOBGMcG6nqXUB4j4AsJFwIxZkVCax47/9xAPnhHlt4AT+JZ9r"
				+ "shE8o4X5rAXRq56d7cwPStocCOy+vQDN5bWk4hMWc8k7rgj+vaT9gFDEH9RMOeil4d+QW7WXqowB3U4lNS/dOVYM1QESo0UBAD85SlMdzZKVgjZJUfJJ"
				+ "wj58TrpSAYv3F0GbwgvOyXpzJJt7z439zAjlRotZxiOw/sop+KJsJbD6QOjlWgu2fEm3VHeFMxKHkErBaupiZhDevZHw3UYLPge+ez/JfqDeOVP9nRf4"
				+ "bxUTtEPTLjoJExGqPV/KBkaEzLHlXaZr7Vz6v4difwL4PmTMP9AuthrzZGHxQIDAQAB";
		
		//final String PAY_URL = "https://openapi.alipay.com/gateway.do";
		final String DEV_PAY_URL = "https://openapi.alipaydev.com/gateway.do";
		
		final String APP_ID = "2016091000482302";
		
		AlipayClient alipayClient = new DefaultAlipayClient(DEV_PAY_URL,APP_ID, APP_PRIVATE_KEY, "json", CharEncoding.UTF_8,
				ALIPAY_PUBLIC_KEY, "RSA2"); //获得初始化的AlipayClient
		AlipayTradePrecreateRequest request = new AlipayTradePrecreateRequest();//创建API对应的request类
		AlipayTradePrecreateModel model = new AlipayTradePrecreateModel();
		model.setOutTradeNo("20150320010101002");
		model.setTotalAmount("88.88");
		model.setSubject("cs");
		model.setStoreId("1");
		model.setTimeoutExpress("90m");
		request.setBizModel(model);
		
		AlipayTradePrecreateResponse response;
		String qrCode;
		
		int width = 300;
		int height = 300;
		String format = "png";
		
		BitMatrix bitMatrix;
		ByteArrayOutputStream stream = new ByteArrayOutputStream();
		
		try {
			response = alipayClient.execute(request);
			qrCode = response.getQrCode();
			System.out.println(qrCode);
			bitMatrix = new MultiFormatWriter().encode(qrCode, BarcodeFormat.QR_CODE, width, height);
			MatrixToImageWriter.writeToStream(bitMatrix, format, stream);
			String string = new String(Base64.getEncoder().encode(stream.toByteArray()));
			System.out.println("data:image/png;base64,"+string);
		} catch (AlipayApiException | WriterException | IOException e1) {
			e1.printStackTrace();
		}
	}
}
