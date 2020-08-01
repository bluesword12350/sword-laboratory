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
 * @author baozi
 */
public class ReverseScanExample {

    private static final Logger LOG = LoggerFactory.getLogger(ReverseScanExample.class);

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

        final byte[] firstKey = keys.get(keys.size() - 1);
        final byte[] lastKey = keys.get(0);
        final String firstKeyString = readUtf8(firstKey);
        final String lastKeyString = readUtf8(lastKey);

        // async scan
        final CompletableFuture<List<KVEntry>> f1 = rheaKVStore.reverseScan(firstKey, lastKey);
        final CompletableFuture<List<KVEntry>> f2 = rheaKVStore.reverseScan(firstKey, lastKey, false);
        final CompletableFuture<List<KVEntry>> f3 = rheaKVStore.reverseScan(firstKeyString, lastKeyString);
        final CompletableFuture<List<KVEntry>> f4 = rheaKVStore.reverseScan(firstKeyString, lastKeyString, false);
        CompletableFuture.allOf(f1, f2, f3, f4).join();
        for (final CompletableFuture<List<KVEntry>> f : new CompletableFuture[] { f1, f2, f3, f4 }) {
            for (final KVEntry kv : f.join()) {
                LOG.info("Async reverseScan: key={}, value={}", readUtf8(kv.getKey()), readUtf8(kv.getValue()));
            }
        }

        // sync scan
        final List<KVEntry> l1 = rheaKVStore.bReverseScan(firstKey, lastKey);
        final List<KVEntry> l2 = rheaKVStore.bReverseScan(firstKey, lastKey, false);
        final List<KVEntry> l3 = rheaKVStore.bReverseScan(firstKeyString, lastKeyString);
        final List<KVEntry> l4 = rheaKVStore.bReverseScan(firstKeyString, lastKeyString, false);
        for (final List<KVEntry> l : new List[] { l1, l2, l3, l4 }) {
            for (final KVEntry kv : l) {
                LOG.info("sync reverseScan: key={}, value={}", readUtf8(kv.getKey()), readUtf8(kv.getValue()));
            }
        }
    }
}
