package com.springtests.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
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
  
  @ManyToMany(
      targetEntity=Performer.class,
      cascade={CascadeType.PERSIST, CascadeType.MERGE}
  )
  @JoinTable(
      name="PROG_PERFORMER",
      joinColumns=@JoinColumn(name="PROGRAMMEID"),
      inverseJoinColumns={@JoinColumn(name="PERFORMERID")}
  )
  private Set<Performer> performers;

  public Set<Performer> getPerformers() {
    return performers;
  }

  public Long getProgrammeId() {
    return programmeId;
  }

  public String getProgTitle() {
    return progTitle;
  }

  public void setPerformers(Set<Performer> performers) {
    this.performers = performers;
  }

  public void setProgrammeId(Long programmeId) {
    this.programmeId = programmeId;
  }

  public void setProgTitle(String progTitle) {
    this.progTitle = progTitle;
  }

}
