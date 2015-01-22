package com.springtests.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Immutable;
import org.hibernate.annotations.Type;

@Entity
@Immutable
@Table(name = "EPISODE")
public class Episode {
  
  @Id
  @GeneratedValue(generator="increment")
  @GenericGenerator(name="increment", strategy="increment")
  private Long episodeId;
  
  @Type(type="com.springtests.model.Programme")
  @OneToOne( cascade = {CascadeType.PERSIST, CascadeType.MERGE} )
  @JoinColumn(name="PROGRAMMEID")
  private Programme programme;
  
  private String subtitle;
  
  private String episode;
  
  private String description;
  
  @ManyToMany(
      targetEntity=Performer.class,
      cascade={CascadeType.PERSIST, CascadeType.MERGE}
  )
  @JoinTable(
      name="PROG_PERFORMER",
      joinColumns=@JoinColumn(name="EPISODEID"),
      inverseJoinColumns={@JoinColumn(name="PERFORMERID")}
  )
  private Set<Performer> performers;

  public String getDescription() {
    return description;
  }

  public String getEpisode() {
    return episode;
  }

  public Long getEpisodeId() {
    return episodeId;
  }

  public Set<Performer> getPerformers() {
    return performers;
  }

  public Programme getProgramme() {
    return programme;
  }

  public String getSubtitle() {
    return subtitle;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public void setEpisode(String episode) {
    this.episode = episode;
  }

  public void setEpisodeId(Long episodeId) {
    this.episodeId = episodeId;
  }

  public void setPerformers(Set<Performer> performers) {
    this.performers = performers;
  }

  public void setProgramme(Programme programme) {
    this.programme = programme;
  }

  public void setSubtitle(String subtitle) {
    this.subtitle = subtitle;
  }

}
