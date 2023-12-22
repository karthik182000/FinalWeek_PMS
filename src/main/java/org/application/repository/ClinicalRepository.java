package org.application.repository;

import org.application.entity.Clinical;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClinicalRepository extends JpaRepository<Clinical, Long> {

}
