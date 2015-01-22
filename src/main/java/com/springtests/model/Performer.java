package com.springtests.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Immutable;

@Entity
@Immutable
@Table(name = "PERFORMER")
public class Performer {
  
  @Id
  @GeneratedValue(generator="increment")
  @GenericGenerator(name="increment", strategy="increment")
  private Long performerId;
  
  @Column(name = "PERFORMER")
  private String performerName;
  
  @ManyToMany(
      cascade = {CascadeType.PERSIST, CascadeType.MERGE},
      targetEntity = Programme.class
  )
  @JoinTable(
      name="PROG_PERFORMER",
      joinColumns=@JoinColumn(name="PERFORMERID"),
      inverseJoinColumns={@JoinColumn(name="PROGRAMMEID")}
  )
  public Set<Programme> programmes;

  public Long getPerformerId() {
    return performerId;
  }

  public String getPerformerName() {
    return performerName;
  }

  public Set<Programme> getProgrammes() {
    return programmes;
  }

  public void setPerformerId(Long performerId) {
    this.performerId = performerId;
  }

  public void setPerformerName(String performerName) {
    this.performerName = performerName;
  }

  public void setProgrammes(Set<Programme> programmes) {
    this.programmes = programmes;
  }

}
