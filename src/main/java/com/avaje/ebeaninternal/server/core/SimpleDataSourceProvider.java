package com.avaje.ebeaninternal.server.core;

import javax.sql.DataSource;
import java.util.function.Supplier;

/**
 * Simple DataSource supplier when no multi-tenancy used.
 */
class SimpleDataSourceProvider implements Supplier<DataSource> {

  private final DataSource dataSource;

  SimpleDataSourceProvider(DataSource dataSource) {
    this.dataSource = dataSource;
  }

  @Override
  public DataSource get() {
    return dataSource;
  }
}
