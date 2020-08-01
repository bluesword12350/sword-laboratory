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
public class PutIfAbsentExample {

    private static final Logger LOG = LoggerFactory.getLogger(PutIfAbsentExample.class);

    public static void main(final String[] args) {
        final Client client = new Client();
        client.init();
        putIfAbsent(client.getRheaKVStore());
        client.shutdown();
    }

    public static void putIfAbsent(final RheaKVStore rheaKVStore) {
        final CompletableFuture<byte[]> r1 = rheaKVStore.putIfAbsent(writeUtf8("putIfAbsent1"), writeUtf8("1"));
        LOG.info("Async putIfAbsent, prev value={}", readUtf8(FutureHelper.get(r1)));
        final CompletableFuture<byte[]> r2 = rheaKVStore.putIfAbsent("putIfAbsent1", writeUtf8("2"));
        LOG.info("Async putIfAbsent, prev value={}", readUtf8(FutureHelper.get(r2)));

        final byte[] b1 = rheaKVStore.bPutIfAbsent(writeUtf8("putIfAbsent2"), writeUtf8("3"));
        LOG.info("Sync putIfAbsent, prev value={}", readUtf8(b1));
        final byte[] b2 = rheaKVStore.bPutIfAbsent(writeUtf8("putIfAbsent2"), writeUtf8("4"));
        LOG.info("Sync putIfAbsent, prev value={}", readUtf8(b2));
    }
}
