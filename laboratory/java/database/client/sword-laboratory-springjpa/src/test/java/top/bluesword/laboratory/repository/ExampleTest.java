package top.bluesword.laboratory.repository;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Example;
import top.bluesword.laboratory.domain.DataFragment;

import java.util.List;

@Slf4j
@SpringBootTest
public class ExampleTest {

    @Autowired
    private DataFragmentRepository dataFragmentRepository;

    @Test
    void findAllByExample(){
        DataFragment dataFragment = new DataFragment();
        dataFragment.setTitle("简介");
        List<DataFragment> dataFragments = dataFragmentRepository.findAll(Example.of(dataFragment));
        log.info("dataFragments:{}",dataFragments);
    }

}
