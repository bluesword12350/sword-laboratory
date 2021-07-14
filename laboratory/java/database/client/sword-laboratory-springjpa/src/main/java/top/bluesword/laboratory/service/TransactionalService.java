package top.bluesword.laboratory.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.ObjectOptimisticLockingFailureException;
import org.springframework.retry.annotation.Retryable;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;
import top.bluesword.laboratory.domain.DataModel;
import top.bluesword.laboratory.repository.DataJpaRepository;

import java.util.Objects;
import java.util.Optional;
import java.util.concurrent.Future;

import static org.springframework.transaction.annotation.Propagation.REQUIRES_NEW;

/**
 * @author 李林峰
 */
@Slf4j
@Service
public class TransactionalService {

    @Autowired
    private DataJpaRepository dataJpaRepository;

    /**
     * 默认事务，当乐观锁冲突时会抛出StaleObjectStateException异常
     * @param id id
     */
    @Async
    @Transactional(rollbackFor = Exception.class)
    public void defaultIsolation(Long id,int waitingTime){
        String addition = "默认事务；";
        nameAddition(id, addition,waitingTime);
    }

    /**
     * 新事务
     * Retryable 失败重试
     * @param id id
     */
    @Async
    @Retryable(value = ObjectOptimisticLockingFailureException.class)
    @Transactional(rollbackFor = Exception.class,propagation = REQUIRES_NEW)
    public Future<Boolean> requiresNewPropagation(Long id, int waitingTime){
        String addition = "新事务；";
        nameAddition(id, addition,waitingTime);
        return new AsyncResult<>(true);
    }

    /**
     * 可以读取已提交数据事务，当乐观锁冲突时会抛出StaleObjectStateException异常
     * @param id id
     * @param waitingTime 等待时间
     */
    @Async
    @Transactional(rollbackFor = Exception.class,isolation = Isolation.READ_COMMITTED)
    public void readCommittedIsolation(Long id,int waitingTime){
        String addition = "可以读取已提交取事务；";
        nameAddition(id, addition,waitingTime);
    }

    public void nameAddition(Long id, String addition,int waitingTime) {
        log.info("开始追加：{}",addition);
        Optional<DataModel> dataModelOptional = dataJpaRepository.findById(id);
        if (dataModelOptional.isEmpty()) {
            return;
        }
        waitingRandomTime(waitingTime);
        DataModel dataModel = dataModelOptional.get();
        String name = dataModel.getName();
        if (Objects.isNull(name)) {
            name = "";
        }
        dataModel.setName(name+ addition);
        dataJpaRepository.save(dataModel);
        log.info("追加完成：{}",addition);
    }

    public void nameClear(Long id){
        Optional<DataModel> dataModelOptional = dataJpaRepository.findById(id);
        if (dataModelOptional.isEmpty()) {
            return;
        }
        DataModel dataModel = dataModelOptional.get();
        dataModel.setName(null);
        dataJpaRepository.save(dataModel);
    }

    public void waitingRandomTime(int waitingTime){
        long now = System.currentTimeMillis();
        for (long time = System.currentTimeMillis();time<now+waitingTime;){
            time = System.currentTimeMillis();
        }
    }
}
