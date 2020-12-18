package top.bluesword.web.laboratory.service;

import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import top.bluesword.util.exception.SwordRuntimeException;
import top.bluesword.web.laboratory.dao.LTestMapper;
import top.bluesword.web.laboratory.entity.LTest;

import java.util.Random;

/**
 * @author 李林峰
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class TransactionalTestService {

    @Autowired LTestMapper mapper;

    public LTest getOne(){
        PageHelper.startPage(1,1);
        return mapper.selectAll().get(0);
    }

    public void updateValue(String testId){
        long start = System.currentTimeMillis();
        LTest lTest = new LTest();
        lTest.setTestId(testId);
        save(start, lTest, "1");
        start += 5000;
        save(start, lTest, "2");
        start += 5000;
        save(start, lTest, "3");
        start += 5000;
        if (new Random().nextBoolean()) throw new SwordRuntimeException("随机异常");
        save(start, lTest, "4");
        start += 5000;
        save(start, lTest, "5");
    }

    private void save(long start, LTest lTest, String s) {
        long now;
        do {
            now = System.currentTimeMillis();
        } while (now < start);
        lTest.setTestValue(s);
        mapper.updateByPrimaryKey(lTest);
    }
}
