package com.auth0.jwt;

import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.junit.jupiter.api.Test;

import java.util.Base64;

class JwtTest {

    @Test
    void decode(){
        String token = "eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCJ9." +
                "eyJjb3VudHJ5X2NvZGUiOiJDTiIsImxvY2FsZV9jb2RlIjoiZW5fVVMiLCJ1c2VyX25hbWUiOiJDaXNzeS5DdWlAcW9ydm8uY29t" +
                "Iiwic2NvcGUiOlsiZm9vIiwicmVhZCIsIndyaXRlIl0sImFwcGxpY2F0aW9uX2NvZGUiOiJJREVBUyIsImV4cCI6MTU4MzkzMzQ0" +
                "OCwidXNlcmFjY291bnRfaWQiOiJVQUMxMDExNDQiLCJqdGkiOiJkMGQxMDE2MC04MDM5LTQ4MDUtODE5Yi02MmRhZjIyZDhjMTgi" +
                "LCJncmFudF9hcHBsaWNhdGlvbl9jb2RlcyI6WyJJREVBUyIsIkNQX1RFTkFOVCJdLCJjbGllbnRfaWQiOiJjbGllbnQiLCJ0ZW5h" +
                "bnRfY29kZSI6IlFPUlZPIn0." +
                "VQgCGEYK9JfvaLi4II7Y8-Ssqq1FMKDr1fY3vtxC0aJ9QVBZBTsep_dFQhR2L7Axvx9NjOqFkD6KstUxEZ0r9HTdXZQKE-3LXlKHFl" +
                "LNxhwo8S3_fpsLEKhlGM839Yobgt7BLyGkBWM-HMZhp497Qd77t4B7JbXumVp9FgI2fC1l9TbqcAv404jboOuls27-3iVYBhUOwO6A" +
                "dVt6maArCjI98SlF1YaYq30QjAMPFjfpaK3QFK7AVLEyjIKRpQUw-YxtB-B7kf8YurmK_4VOjmCKFS_oiaHIZS6l-UpZfHksoxFND4" +
                "XyvYK9tZzrYcs1E-Nl_hm-53L7gBxnFfuqZw";
        DecodedJWT decode = JWT.decode(token);
        String payload = decode.getPayload();
        String info = new String(Base64.getDecoder().decode(payload));
        System.out.println(info);
    }

    @Test
    void create(){
        System.out.println(JWT.create().withIssuer("123").sign(Algorithm.none()));
    }

    @Test
    void test(){
        String token = "eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCJ9." +
                "eyJjb3VudHJ5X2NvZGUiOiJDTiIsImxvY2FsZV9jb2RlIjoiZW5fVVMiLCJ1c2VyX25hbWUiOiJDaXNzeS5DdWlAcW9ydm8uY29t" +
                "Iiwic2NvcGUiOlsiZm9vIiwicmVhZCIsIndyaXRlIl0sImFwcGxpY2F0aW9uX2NvZGUiOiJJREVBUyIsImV4cCI6MTU4MzkzMzQ0" +
                "OCwidXNlcmFjY291bnRfaWQiOiJVQUMxMDExNDQiLCJqdGkiOiJkMGQxMDE2MC04MDM5LTQ4MDUtODE5Yi02MmRhZjIyZDhjMTgi" +
                "LCJncmFudF9hcHBsaWNhdGlvbl9jb2RlcyI6WyJJREVBUyIsIkNQX1RFTkFOVCJdLCJjbGllbnRfaWQiOiJjbGllbnQiLCJ0ZW5h" +
                "bnRfY29kZSI6IlFPUlZPIn0." +
                "VQgCGEYK9JfvaLi4II7Y8-Ssqq1FMKDr1fY3vtxC0aJ9QVBZBTsep_dFQhR2L7Axvx9NjOqFkD6KstUxEZ0r9HTdXZQKE-3LXlKHFl" +
                "LNxhwo8S3_fpsLEKhlGM839Yobgt7BLyGkBWM-HMZhp497Qd77t4B7JbXumVp9FgI2fC1l9TbqcAv404jboOuls27-3iVYBhUOwO6A" +
                "dVt6maArCjI98SlF1YaYq30QjAMPFjfpaK3QFK7AVLEyjIKRpQUw-YxtB-B7kf8YurmK_4VOjmCKFS_oiaHIZS6l-UpZfHksoxFND4" +
                "XyvYK9tZzrYcs1E-Nl_hm-53L7gBxnFfuqZw";
        DecodedJWT decode = JWT.decode(token);
        System.out.println(JWT.create().withIssuer("123").sign(Algorithm.none()));
    }
}