package top.bluesword.laboratory.client;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import top.bluesword.laboratory.model.RequestData;

@SpringBootTest
class FeignDemoClientTest {

    @Autowired
    private FeignDemoClient feignDemoClient;

    @Test
    void test(){
        RequestData requestData = new RequestData();
        requestData.setKey("测试");
        feignDemoClient.test(requestData);
    }

}