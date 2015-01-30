package com.springtests.model;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "PROGRAMME")
public class Programme {
  
  @Id
  @GeneratedValue(generator="increment")
  @GenericGenerator(name="increment", strategy="increment")
  private Long programmeId;
  
  private String progTitle;
  
  @OneToMany(mappedBy = "programme")   
  private Set<ProgEpPerfAssociation> programmeAssociations; 

  public Set<ProgEpPerfAssociation> getProgrammeAssociations() {
    return programmeAssociations;
  }

  public Long getProgrammeId() {
    return programmeId;
  }

  public String getProgTitle() {
    return progTitle;
  }

  public void setProgrammeAssociations(Set<ProgEpPerfAssociation> programmeAssociations) {
    this.programmeAssociations = programmeAssociations;
  }

  public void setProgrammeId(Long programmeId) {
    this.programmeId = programmeId;
  }

  public void setProgTitle(String progTitle) {
    this.progTitle = progTitle;
  }

}
