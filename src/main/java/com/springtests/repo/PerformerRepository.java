package com.springtests.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springtests.model.Performer;

@Repository("performerRepository")
public interface PerformerRepository extends JpaRepository<Performer, Long> {
  
  Performer findByPerformerId(Long performerId);

}
