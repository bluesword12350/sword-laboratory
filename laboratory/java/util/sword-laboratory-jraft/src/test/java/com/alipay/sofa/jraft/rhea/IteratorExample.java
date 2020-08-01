package com.alipay.sofa.jraft.rhea;

import com.alipay.sofa.jraft.rhea.client.Client;
import com.alipay.sofa.jraft.rhea.client.RheaIterator;
import com.alipay.sofa.jraft.rhea.client.RheaKVStore;
import com.alipay.sofa.jraft.rhea.storage.KVEntry;
import com.alipay.sofa.jraft.rhea.util.Lists;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

import static com.alipay.sofa.jraft.util.BytesUtil.readUtf8;
import static com.alipay.sofa.jraft.util.BytesUtil.writeUtf8;

/**
 *
 * @author jiachun.fjc
 */
public class IteratorExample {

    private static final Logger LOG = LoggerFactory.getLogger(IteratorExample.class);

    public static void main(final String[] args) {
        final Client client = new Client();
        client.init();
        iterator(client.getRheaKVStore());
        client.shutdown();
    }

    @SuppressWarnings("unchecked")
    public static void iterator(final RheaKVStore rheaKVStore) {
        final List<byte[]> keys = Lists.newArrayList();
        for (int i = 0; i < 10; i++) {
            final byte[] bytes = writeUtf8("iterator_demo_" + i);
            keys.add(bytes);
            rheaKVStore.bPut(bytes, bytes);
        }

        final byte[] firstKey = keys.get(0);
        final byte[] lastKey = keys.get(keys.size() - 1);
        final String firstKeyString = readUtf8(firstKey);
        final String lastKeyString = readUtf8(lastKey);

        final RheaIterator<KVEntry> it1 = rheaKVStore.iterator(firstKey, lastKey, 5);
        final RheaIterator<KVEntry> it2 = rheaKVStore.iterator(firstKey, lastKey, 6, false);
        final RheaIterator<KVEntry> it3 = rheaKVStore.iterator(firstKeyString, lastKeyString, 5);
        final RheaIterator<KVEntry> it4 = rheaKVStore.iterator(firstKeyString, lastKeyString, 6, false);

        for (final RheaIterator<KVEntry> it : new RheaIterator[] { it1, it2, it3, it4 }) {
            while (it.hasNext()) {
                final KVEntry kv = it.next();
                LOG.info("Sync iterator: key={}, value={}", readUtf8(kv.getKey()), readUtf8(kv.getValue()));
            }
        }
    }
}
