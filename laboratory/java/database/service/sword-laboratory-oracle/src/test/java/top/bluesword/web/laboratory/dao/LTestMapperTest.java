package top.bluesword.web.laboratory.dao;

import com.alibaba.fastjson.JSON;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import top.bluesword.web.laboratory.entity.LTest;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class LTestMapperTest {

    private final Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    LTestMapper mapper;

    @Test
    public void insertList() {
        try {
            List<LTest> list = new ArrayList<>();
            for (int i = 0; i < 5000; i++) {
                LTest lTest = new LTest();
                lTest.setTestValue("测试"+i);
                list.add(lTest);
            }
            log.info("{}",mapper.insertList(list));
        } catch (Exception e) {
            log.info("{}",e);
        }

    }

    @Test
    public void selectList() {
        List<String> list = mapper.selectValueList();
        log.info("{}",list);
        log.info("{}",list.size());
    }

    @Test
    public void selectListByValues() {
        String s = JSON.toJSONString(mapper.selectListByValues(mapper.selectValueList()));
        log.info(s);
    }
}