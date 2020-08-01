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
public class GetAndPutExample {

    private static final Logger LOG = LoggerFactory.getLogger(GetAndPutExample.class);

    public static void main(final String[] args) {
        final Client client = new Client();
        client.init();
        put(client.getRheaKVStore());
        client.shutdown();
    }

    public static void put(final RheaKVStore rheaKVStore) {
        final CompletableFuture<byte[]> f1 = rheaKVStore.getAndPut(writeUtf8("getAndPut"), writeUtf8("getAndPutValue"));
        LOG.info("Old value: {}", readUtf8(FutureHelper.get(f1)));

        final CompletableFuture<byte[]> f2 = rheaKVStore.getAndPut("getAndPut", writeUtf8("getAndPutValue2"));
        LOG.info("Old value: {}", readUtf8(FutureHelper.get(f2)));

        final byte[] b1 = rheaKVStore.bGetAndPut(writeUtf8("getAndPut1"), writeUtf8("getAndPutValue3"));
        LOG.info("Old value: {}", readUtf8(b1));

        final byte[] b2 = rheaKVStore.bGetAndPut(writeUtf8("getAndPut1"), writeUtf8("getAndPutValue4"));
        LOG.info("Old value: {}", readUtf8(b2));
    }
}
