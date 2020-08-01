package com.alipay.sofa.jraft.rhea;

import com.alipay.sofa.jraft.rhea.client.Client;
import com.alipay.sofa.jraft.rhea.client.RheaKVStore;
import com.alipay.sofa.jraft.rhea.storage.KVEntry;
import com.alipay.sofa.jraft.rhea.util.Lists;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import static com.alipay.sofa.jraft.util.BytesUtil.readUtf8;
import static com.alipay.sofa.jraft.util.BytesUtil.writeUtf8;

/**
 *
 * @author jiachun.fjc
 */
public class ScanExample {

    private static final Logger LOG = LoggerFactory.getLogger(ScanExample.class);

    public static void main(final String[] args) {
        final Client client = new Client();
        client.init();
        scan(client.getRheaKVStore());
        client.shutdown();
    }

    @SuppressWarnings("unchecked")
    public static void scan(final RheaKVStore rheaKVStore) {
        final List<byte[]> keys = Lists.newArrayList();
        for (int i = 0; i < 10; i++) {
            final byte[] bytes = writeUtf8("scan_demo_" + i);
            keys.add(bytes);
            rheaKVStore.bPut(bytes, bytes);
        }

        final byte[] firstKey = keys.get(0);
        final byte[] lastKey = keys.get(keys.size() - 1);
        final String firstKeyString = readUtf8(firstKey);
        final String lastKeyString = readUtf8(lastKey);

        // async scan
        final CompletableFuture<List<KVEntry>> f1 = rheaKVStore.scan(firstKey, lastKey);
        final CompletableFuture<List<KVEntry>> f2 = rheaKVStore.scan(firstKey, lastKey, false);
        final CompletableFuture<List<KVEntry>> f3 = rheaKVStore.scan(firstKeyString, lastKeyString);
        final CompletableFuture<List<KVEntry>> f4 = rheaKVStore.scan(firstKeyString, lastKeyString, false);
        CompletableFuture.allOf(f1, f2, f3, f4).join();
        for (final CompletableFuture<List<KVEntry>> f : new CompletableFuture[] { f1, f2, f3, f4 }) {
            for (final KVEntry kv : f.join()) {
                LOG.info("Async scan: key={}, value={}", readUtf8(kv.getKey()), readUtf8(kv.getValue()));
            }
        }

        // sync scan
        final List<KVEntry> l1 = rheaKVStore.bScan(firstKey, lastKey);
        final List<KVEntry> l2 = rheaKVStore.bScan(firstKey, lastKey, false);
        final List<KVEntry> l3 = rheaKVStore.bScan(firstKeyString, lastKeyString);
        final List<KVEntry> l4 = rheaKVStore.bScan(firstKeyString, lastKeyString, false);
        for (final List<KVEntry> l : new List[] { l1, l2, l3, l4 }) {
            for (final KVEntry kv : l) {
                LOG.info("sync scan: key={}, value={}", readUtf8(kv.getKey()), readUtf8(kv.getValue()));
            }
        }
    }
}
