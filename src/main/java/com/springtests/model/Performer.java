package com.springtests.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
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
  
  @OneToMany(mappedBy = "performer")
  public Set<ProgEpPerfAssociation> performerAssociations;
  
  public Long getPerformerId() {
    return performerId;
  }

  public String getPerformerName() {
    return performerName;
  }

  public Set<ProgEpPerfAssociation> getPerformerAssociations() {
    return performerAssociations;
  }

  public void setPerformerId(Long performerId) {
    this.performerId = performerId;
  }

  public void setPerformerName(String performerName) {
    this.performerName = performerName;
  }

  public void setPerformerAssociations(Set<ProgEpPerfAssociation> performerAssociations) {
    this.performerAssociations = performerAssociations;
  }

}
