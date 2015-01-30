package com.springtests.model;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Immutable;

@Entity
@Immutable
@Table(name = "EPISODE")
public class Episode {
  
  @Id
//  @GeneratedValue(generator="increment")
//  @GenericGenerator(name="increment", strategy="increment")
  private Long episodeId;
  
  @ManyToOne
  @JoinColumn(name="programmeId")
  private Programme programme;
  
  private String subtitle;
  
  private String episode;
  
  private String description;
  
  @OneToMany(mappedBy = "episode")      
  private Set<ProgEpPerfAssociation> episodeAssociations;

  public String getDescription() {
    return description;
  }

  public String getEpisode() {
    return episode;
  }

  public Long getEpisodeId() {
    return episodeId;
  }

  public Set<ProgEpPerfAssociation> getEpisodeAssociations() {
    return episodeAssociations;
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

  public void setEpisodeAssociations(Set<ProgEpPerfAssociation> episodeAssociations) {
    this.episodeAssociations = episodeAssociations;
  }

  public void setProgramme(Programme programme) {
    this.programme = programme;
  }

  public void setSubtitle(String subtitle) {
    this.subtitle = subtitle;
  }

}
