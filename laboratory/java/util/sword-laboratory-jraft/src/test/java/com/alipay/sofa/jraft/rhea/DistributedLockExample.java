package com.alipay.sofa.jraft.rhea;

import com.alipay.sofa.jraft.rhea.client.Client;
import com.alipay.sofa.jraft.rhea.client.RheaKVStore;
import com.alipay.sofa.jraft.rhea.util.concurrent.DistributedLock;
import com.alipay.sofa.jraft.util.ExecutorServiceHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author jiachun.fjc
 */
public class DistributedLockExample {

    private static final Logger LOG = LoggerFactory.getLogger(DistributedLockExample.class);

    public static void main(final String[] args) {
        final Client client = new Client();
        client.init();
        lock(client.getRheaKVStore());
        lockAndAutoKeepLease(client.getRheaKVStore());
        client.shutdown();
    }

    public static void lock(final RheaKVStore rheaKVStore) {
        final String lockKey = "lock_example";
        final DistributedLock<byte[]> lock = rheaKVStore.getDistributedLock(lockKey, 3, TimeUnit.SECONDS);
        if (lock.tryLock()) {
            try {
                LOG.info("Lock success with: {}", lockKey);
            } finally {
                lock.unlock();
            }
        } else {
            LOG.info("Fail to lock with: {}", lockKey);
        }
    }

    public static void lockAndAutoKeepLease(final RheaKVStore rheaKVStore) {
        final ScheduledExecutorService watchdog = Executors.newSingleThreadScheduledExecutor();
        final String lockKey = "lock_example1";
        final DistributedLock<byte[]> lock = rheaKVStore.getDistributedLock(lockKey, 3, TimeUnit.SECONDS, watchdog);
        if (lock.tryLock()) {
            try {
                LOG.info("Lock success with: {}", lockKey);
            } finally {
                lock.unlock();
            }
        } else {
            LOG.info("Fail to lock with: {}", lockKey);
        }
        ExecutorServiceHelper.shutdownAndAwaitTermination(watchdog);
    }
}
