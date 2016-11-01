package com.avaje.tests.query.aggregation;

import com.avaje.ebean.BaseTestCase;
import com.avaje.ebean.Ebean;
import com.avaje.ebean.Query;
import com.avaje.tests.model.tevent.TEventMany;
import com.avaje.tests.model.tevent.TEventOne;
import org.junit.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class TestAggregationCount extends BaseTestCase {

  @Test
  public void test() {

    TEventOne one = new TEventOne("first");
    one.getDetails().add(new TEventMany("all", 1, 10));
    one.getDetails().add(new TEventMany("be", 2, 12.2));
    one.getDetails().add(new TEventMany("add", 3, 13));
    Ebean.save(one);

    TEventOne two = new TEventOne("second");
    two.getDetails().add(new TEventMany("at", 10, 10));
    two.getDetails().add(new TEventMany("add", 30, 13));
    two.getDetails().add(new TEventMany("alf", 30, 13));
    Ebean.save(two);


    Query<TEventOne> query = Ebean.find(TEventOne.class)
        .select("name, count, totalUnits, totalAmount")
        .where().startsWith("details.description", "a")
        .having().ge("count", 1)
        .orderBy().asc("name");

    List<TEventOne> list = query.findList();
    for (TEventOne eventOne : list) {
      System.out.println(eventOne.getId() + " " + eventOne.getName() + " count:" + eventOne.getCount() + " units:" + eventOne.getTotalUnits() + " amount:" + eventOne.getTotalAmount());
    }

    assertThat(list).isNotEmpty();
    assertThat(query.getGeneratedSql()).contains("select ");
  }

}
