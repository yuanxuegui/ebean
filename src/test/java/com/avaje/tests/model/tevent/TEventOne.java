package com.avaje.tests.model.tevent;

import com.avaje.ebean.annotation.Aggregation;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Version;
import java.util.List;

@Entity
public class TEventOne {

  @Id
  Long id;

  String name;

  @Version
  Long version;

  @OneToOne
  TEvent event;

  @Aggregation("count(u1.*)")
  Long count;

  @Aggregation("sum(u1.units)")
  Double totalUnits;

  @Aggregation("sum(u1.units * u1.amount)")
  Double totalAmount;

  @OneToMany(mappedBy = "event", cascade = CascadeType.ALL)
  List<TEventMany> details;

  public TEventOne(String name) {
    this.name = name;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Long getCount() {
    return count;
  }

  public Double getTotalUnits() {
    return totalUnits;
  }

  public Double getTotalAmount() {
    return totalAmount;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Long getVersion() {
    return version;
  }

  public void setVersion(Long version) {
    this.version = version;
  }

  public TEvent getEvent() {
    return event;
  }

  public void setEvent(TEvent event) {
    this.event = event;
  }

  public List<TEventMany> getDetails() {
    return details;
  }

  public void setDetails(List<TEventMany> details) {
    this.details = details;
  }
}
