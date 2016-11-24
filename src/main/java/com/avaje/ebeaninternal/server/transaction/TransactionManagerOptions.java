package com.avaje.ebeaninternal.server.transaction;

import com.avaje.ebean.BackgroundExecutor;
import com.avaje.ebean.config.ServerConfig;
import com.avaje.ebeaninternal.server.cluster.ClusterManager;
import com.avaje.ebeaninternal.server.deploy.BeanDescriptorManager;
import com.avaje.ebeanservice.docstore.api.DocStoreUpdateProcessor;

import javax.sql.DataSource;
import java.util.function.Supplier;

/**
 * Objects supplied for constructing the TransactionManager.
 */
public class TransactionManagerOptions {

  final boolean localL2Caching;
  final ServerConfig config;
  final ClusterManager clusterManager;
  final BackgroundExecutor backgroundExecutor;

  final DocStoreUpdateProcessor docStoreUpdateProcessor;
  final BeanDescriptorManager descMgr;
  final Supplier<DataSource> dataSourceSupplier;


  public TransactionManagerOptions(boolean localL2Caching, ServerConfig config, ClusterManager clusterManager, BackgroundExecutor backgroundExecutor,
                            DocStoreUpdateProcessor docStoreUpdateProcessor, BeanDescriptorManager descMgr, Supplier<DataSource> dataSourceSupplier) {

    this.localL2Caching = localL2Caching;
    this.config = config;
    this.clusterManager = clusterManager;
    this.backgroundExecutor = backgroundExecutor;
    this.docStoreUpdateProcessor = docStoreUpdateProcessor;
    this.descMgr = descMgr;
    this.dataSourceSupplier = dataSourceSupplier;
  }

}
