package top.bluesword.laboratory.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DataFragmentRepositoryTest {

    @Autowired
    private DataFragmentRepository dataFragmentRepository;

    @Test
    void findAll(){
        System.out.println(dataFragmentRepository.findAll());
    }

}