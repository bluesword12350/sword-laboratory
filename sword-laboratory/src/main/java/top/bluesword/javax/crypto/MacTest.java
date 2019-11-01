package top.bluesword.javax.crypto;

import org.junit.jupiter.api.Test;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

class MacTest {

    @Test
    void macTest() throws NoSuchAlgorithmException, InvalidKeyException {
        Mac mac = Mac.getInstance("HmacSHA256");
        byte[] secret = "secret".getBytes();
        SecretKeySpec secretKey = new SecretKeySpec(secret, "RAW");
        mac.init(secretKey);
        byte[] data = "data".getBytes();
        byte[] bytes1 = mac.doFinal(data);
        System.out.print("[");
        System.out.print(bytes1[0] & 0x0FF);
        for (int i = 1; i < bytes1.length; i++) {
            System.out.print(" ");
            System.out.print(bytes1[i] & 0x0FF);
        }
        System.out.println("]");
    }
}
