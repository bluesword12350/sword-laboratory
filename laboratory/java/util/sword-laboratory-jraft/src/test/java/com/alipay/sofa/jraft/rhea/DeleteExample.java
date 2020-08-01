package com.alipay.sofa.jraft.rhea;

import com.alipay.sofa.jraft.rhea.client.Client;
import com.alipay.sofa.jraft.rhea.client.FutureHelper;
import com.alipay.sofa.jraft.rhea.client.RheaKVStore;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.CompletableFuture;

import static com.alipay.sofa.jraft.util.BytesUtil.readUtf8;
import static com.alipay.sofa.jraft.util.BytesUtil.writeUtf8;

/**
 *
 * @author jiachun.fjc
 */
public class DeleteExample {

    private static final Logger LOG = LoggerFactory.getLogger(DeleteExample.class);

    public static void main(final String[] args) {
        final Client client = new Client();
        client.init();
        delete(client.getRheaKVStore());
        client.shutdown();
    }

    public static void delete(final RheaKVStore rheaKVStore) {
        rheaKVStore.bPut("delete_test", writeUtf8("1"));
        LOG.info("Value={}", readUtf8(rheaKVStore.bGet("delete_test")));
        final CompletableFuture<Boolean> f1 = rheaKVStore.delete(writeUtf8("delete_test"));
        FutureHelper.get(f1);
        LOG.info("Value={}", readUtf8(rheaKVStore.bGet("delete_test")));

        rheaKVStore.bPut("delete_test", writeUtf8("1"));
        LOG.info("Value={}", readUtf8(rheaKVStore.bGet("delete_test")));
        final CompletableFuture<Boolean> f2 = rheaKVStore.delete("delete_test");
        FutureHelper.get(f2);
        LOG.info("Value={}", readUtf8(rheaKVStore.bGet("delete_test")));

        rheaKVStore.bPut("delete_test", writeUtf8("1"));
        LOG.info("Value={}", readUtf8(rheaKVStore.bGet("delete_test")));
        rheaKVStore.bDelete(writeUtf8("delete_test"));
        LOG.info("Value={}", readUtf8(rheaKVStore.bGet("delete_test")));

        rheaKVStore.bPut("delete_test", writeUtf8("1"));
        LOG.info("Value={}", readUtf8(rheaKVStore.bGet("delete_test")));
        rheaKVStore.bDelete("delete_test");
        LOG.info("Value={}", readUtf8(rheaKVStore.bGet("delete_test")));
    }
}
