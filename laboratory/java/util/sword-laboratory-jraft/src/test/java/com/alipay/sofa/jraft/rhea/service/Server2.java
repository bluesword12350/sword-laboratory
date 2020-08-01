package com.alipay.sofa.jraft.rhea.service;

import com.alipay.sofa.jraft.rhea.config.Configs;
import com.alipay.sofa.jraft.rhea.options.PlacementDriverOptions;
import com.alipay.sofa.jraft.rhea.options.RheaKVStoreOptions;
import com.alipay.sofa.jraft.rhea.options.StoreEngineOptions;
import com.alipay.sofa.jraft.rhea.options.configured.PlacementDriverOptionsConfigured;
import com.alipay.sofa.jraft.rhea.options.configured.RheaKVStoreOptionsConfigured;
import com.alipay.sofa.jraft.rhea.options.configured.RocksDBOptionsConfigured;
import com.alipay.sofa.jraft.rhea.options.configured.StoreEngineOptionsConfigured;
import com.alipay.sofa.jraft.rhea.storage.StorageType;
import com.alipay.sofa.jraft.util.Endpoint;

/**
 *
 * @author jiachun.fjc
 */
public class Server2 {

    public static void main(final String[] args) {
        final PlacementDriverOptions pdOpts = PlacementDriverOptionsConfigured.newConfigured()
                .withFake(true) // use a fake pd
                .config();
        final StoreEngineOptions storeOpts = StoreEngineOptionsConfigured.newConfigured() //
                .withStorageType(StorageType.RocksDB)
                .withRocksDBOptions(RocksDBOptionsConfigured.newConfigured().withDbPath(Configs.DB_PATH).config())
                .withRaftDataPath(Configs.RAFT_DATA_PATH)
                .withServerAddress(new Endpoint("127.0.0.1", 8182))
                .config();
        final RheaKVStoreOptions opts = RheaKVStoreOptionsConfigured.newConfigured() //
                .withClusterName(Configs.CLUSTER_NAME) //
                .withInitialServerList(Configs.ALL_NODE_ADDRESSES)
                .withStoreEngineOptions(storeOpts) //
                .withPlacementDriverOptions(pdOpts) //
                .config();
        System.out.println(opts);
        final Node node = new Node(opts);
        node.start();
        Runtime.getRuntime().addShutdownHook(new Thread(node::stop));
        System.out.println("server2 start OK");
    }
}
