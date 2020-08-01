package com.alipay.sofa.jraft.rhea;

import com.alipay.sofa.jraft.rhea.client.Client;
import com.alipay.sofa.jraft.rhea.client.RheaKVStore;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.CompletableFuture;

import static com.alipay.sofa.jraft.util.BytesUtil.readUtf8;

/**
 *
 * @author jiachun.fjc
 */
public class MergeExample {

    private static final Logger LOG = LoggerFactory.getLogger(MergeExample.class);

    public static void main(final String[] args) {
        final Client client = new Client();
        client.init();
        merge(client.getRheaKVStore());
        client.shutdown();
    }

    public static void merge(final RheaKVStore rheaKVStore) {
        final CompletableFuture<Boolean> f1 = rheaKVStore.merge("merge_example", "1");
        final CompletableFuture<Boolean> f2 = rheaKVStore.merge("merge_example", "2");
        final CompletableFuture<Boolean> f3 = rheaKVStore.merge("merge_example", "3");
        final CompletableFuture<Boolean> f4 = rheaKVStore.merge("merge_example", "4");
        final CompletableFuture<Boolean> f5 = rheaKVStore.merge("merge_example", "5");

        CompletableFuture.allOf(f1, f2, f3, f4, f5).join();
        LOG.info("Merge result is: {}", readUtf8(rheaKVStore.bGet("merge_example")));

        rheaKVStore.bMerge("merge_example1", "1");
        rheaKVStore.bMerge("merge_example1", "2");
        rheaKVStore.bMerge("merge_example1", "3");
        rheaKVStore.bMerge("merge_example1", "4");
        rheaKVStore.bMerge("merge_example1", "5");
        LOG.info("Merge result is: {}", readUtf8(rheaKVStore.bGet("merge_example1")));
    }
}
