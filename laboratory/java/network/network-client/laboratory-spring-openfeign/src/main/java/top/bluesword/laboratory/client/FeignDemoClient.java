package top.bluesword.laboratory.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import top.bluesword.laboratory.model.RequestData;

/**
 * @author 李林峰
 */
@FeignClient(name = "feignDemoClient",url = "https://www.baidu.com")
public interface FeignDemoClient {

    /**
     * 测试请求
     * @param requestData 请求参数
     */
    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    void test(RequestData requestData);

}
