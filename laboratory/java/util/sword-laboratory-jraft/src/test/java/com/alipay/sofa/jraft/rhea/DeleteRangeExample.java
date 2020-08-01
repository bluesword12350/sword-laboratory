package com.alipay.sofa.jraft.rhea;

import com.alipay.sofa.jraft.rhea.client.Client;
import com.alipay.sofa.jraft.rhea.client.FutureHelper;
import com.alipay.sofa.jraft.rhea.client.RheaKVStore;

import java.util.concurrent.CompletableFuture;

import static com.alipay.sofa.jraft.util.BytesUtil.writeUtf8;

/**
 *
 * @author jiachun.fjc
 */
public class DeleteRangeExample {

    public static void main(final String[] args) {
        final Client client = new Client();
        client.init();
        deleteRange(client.getRheaKVStore());
        client.shutdown();
    }

    public static void deleteRange(final RheaKVStore rheaKVStore) {
        for (int i = 0; i < 10; i++) {
            rheaKVStore.bPut("delete_range_example_" + i, writeUtf8("1"));
        }
        final byte[] start = writeUtf8("delete_range_example_0");
        final byte[] end = writeUtf8("delete_range_example_9");
        final CompletableFuture<Boolean> f1 = rheaKVStore.deleteRange(start, end);
        FutureHelper.get(f1);

        for (int i = 0; i < 10; i++) {
            rheaKVStore.bPut("delete_range_example_" + i, writeUtf8("1"));
        }
        final CompletableFuture<Boolean> f2 = rheaKVStore.deleteRange("delete_range_example_0",
            "delete_range_example_9");
        FutureHelper.get(f2);

        for (int i = 0; i < 10; i++) {
            rheaKVStore.bPut("delete_range_example_" + i, writeUtf8("1"));
        }
        rheaKVStore.bDeleteRange(start, end);

        for (int i = 0; i < 10; i++) {
            rheaKVStore.bPut("delete_range_example_" + i, writeUtf8("1"));
        }
        rheaKVStore.bDeleteRange("delete_range_example_0", "delete_range_example_9");
    }
}
