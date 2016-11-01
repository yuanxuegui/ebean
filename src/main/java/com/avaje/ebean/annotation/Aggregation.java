package com.avaje.ebean.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Specify a property to be an aggregation formula.
 * <p>
 * </p>
 *
 * <h3>Example:</h3>
 * <pre>{@code
 *
 * @Aggregation("count(details)")
 * Long totalCount;
 *
 * @Aggregation("sum(details.quantity*details.unitPrice)")
 * Long totalAmount;
 *
 * }</pre>
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface Aggregation {

  /**
   * Aggregation formula using sum, count, avg, min, max.
   */
  String value();
}
