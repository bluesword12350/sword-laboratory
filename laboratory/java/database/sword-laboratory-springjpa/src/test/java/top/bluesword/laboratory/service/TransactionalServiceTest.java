package top.bluesword.laboratory.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

@SpringBootTest
class TransactionalServiceTest {

    @Autowired
    private TransactionalService transactionalService;

    @Test
    void main() throws ExecutionException, InterruptedException {
        Long id = 1L;
        int index = 0;
        transactionalService.nameClear(id);
        transactionalService.nameAddition(id,index++ +";",1000);
        Future<Boolean> booleanFuture = transactionalService.requiresNewPropagation(id, 5000);
        transactionalService.nameAddition(id,index++ +";",1000);
        System.out.println(booleanFuture.get());
        System.out.println(index);
    }

}