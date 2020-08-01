package com.alipay.sofa.jraft.rhea.service;

import com.alipay.sofa.jraft.rhea.client.DefaultRheaKVStore;
import com.alipay.sofa.jraft.rhea.client.RheaKVStore;
import com.alipay.sofa.jraft.rhea.options.RheaKVStoreOptions;

/**
 *
 * @author jiachun.fjc
 */
public class Node {

    private final RheaKVStoreOptions options;

    private RheaKVStore rheaKVStore;

    public Node(RheaKVStoreOptions options) {
        this.options = options;
    }

    public void start() {
        this.rheaKVStore = new DefaultRheaKVStore();
        this.rheaKVStore.init(this.options);
    }

    public void stop() {
        this.rheaKVStore.shutdown();
    }

}
