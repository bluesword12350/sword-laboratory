package top.bluesword.web.laboratory.dao;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ArrayMapperTest {
    @Autowired
    ArrayMapper arrayMapper;

    @Test
    public void selectArray() throws JsonProcessingException {
        Object o = arrayMapper.selectArrayToObject();
        System.out.println(o.getClass());
        System.out.println(Integer[].class);
        System.out.println(new ObjectMapper().writeValueAsString(o));
    }
}