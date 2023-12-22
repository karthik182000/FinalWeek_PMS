package org.application.repository;

import org.application.entity.Prescriptions;
import org.application.entity.Prescriptions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PrescriptionsRepository extends JpaRepository<Prescriptions, Long> {
}
