package com.alipay.sofa.jraft.rhea.client;

import com.alipay.sofa.jraft.rhea.config.Configs;
import com.alipay.sofa.jraft.rhea.options.PlacementDriverOptions;
import com.alipay.sofa.jraft.rhea.options.RegionRouteTableOptions;
import com.alipay.sofa.jraft.rhea.options.RheaKVStoreOptions;
import com.alipay.sofa.jraft.rhea.options.configured.MultiRegionRouteTableOptionsConfigured;
import com.alipay.sofa.jraft.rhea.options.configured.PlacementDriverOptionsConfigured;
import com.alipay.sofa.jraft.rhea.options.configured.RheaKVStoreOptionsConfigured;

import java.util.List;

/**
 *
 * @author jiachun.fjc
 */
public class Client {

    private final RheaKVStore rheaKVStore = new DefaultRheaKVStore();

    public void init() {
        final List<RegionRouteTableOptions> regionRouteTableOptionsList = MultiRegionRouteTableOptionsConfigured
            .newConfigured() //
            .withInitialServerList(-1L /* default id */, Configs.ALL_NODE_ADDRESSES) //
            .config();
        final PlacementDriverOptions pdOpts = PlacementDriverOptionsConfigured.newConfigured() //
            .withFake(true) //
            .withRegionRouteTableOptionsList(regionRouteTableOptionsList) //
            .config();
        final RheaKVStoreOptions opts = RheaKVStoreOptionsConfigured.newConfigured() //
            .withClusterName(Configs.CLUSTER_NAME) //
            .withPlacementDriverOptions(pdOpts) //
            .config();
        System.out.println(opts);
        rheaKVStore.init(opts);
    }

    public void shutdown() {
        this.rheaKVStore.shutdown();
    }

    public RheaKVStore getRheaKVStore() {
        return rheaKVStore;
    }
}
