package com.alipay.sofa.jraft.rhea.config;

import java.io.File;

/**
 * @author jiachun.fjc
 */
public class Configs {

    public static String DB_PATH            = "rhea_db" + File.separator;

    public static String RAFT_DATA_PATH     = "raft_data" + File.separator;

    public static String ALL_NODE_ADDRESSES = "127.0.0.1:8181,127.0.0.1:8182,127.0.0.1:8183";

    public static String CLUSTER_NAME       = "rhea_example";
}
