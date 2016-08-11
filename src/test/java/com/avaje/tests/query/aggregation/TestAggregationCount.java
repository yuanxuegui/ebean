package com.avaje.tests.query.aggregation;

import com.avaje.ebean.BaseTestCase;
import com.avaje.ebean.Ebean;
import com.avaje.ebean.Query;
import com.avaje.tests.model.tevent.TEventMany;
import com.avaje.tests.model.tevent.TEventOne;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class TestAggregationCount extends BaseTestCase {

  @Test
  public void test() {

    TEventOne one = new TEventOne();
    one.setOne("one");
    one.getMany().add(new TEventMany());
    one.getMany().add(new TEventMany());

    Ebean.save(one);


    Query<TEventOne> query = Ebean.find(TEventOne.class)
        .select("one, totalCount");

    query.findList();


    assertThat(query.getGeneratedSql()).contains("select ");
  }

}
