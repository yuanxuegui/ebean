package com.avaje.ebeaninternal.server.core;

import com.avaje.ebean.config.CurrentTenantProvider;
import com.avaje.ebean.config.TenantDataSourceProvider;

import javax.sql.DataSource;
import java.util.function.Supplier;

/**
 * DataSource supplier based on DataSource per Tenant.
 */
class MultiTenantDbSupplier implements Supplier<DataSource> {

  private final CurrentTenantProvider tenantProvider;

  private final TenantDataSourceProvider dataSourceProvider;

  MultiTenantDbSupplier(CurrentTenantProvider tenantProvider, TenantDataSourceProvider dataSourceProvider) {
    this.tenantProvider = tenantProvider;
    this.dataSourceProvider = dataSourceProvider;
  }

  @Override
  public DataSource get() {
    return dataSourceProvider.dataSource(tenantProvider.currentId());
  }
}
