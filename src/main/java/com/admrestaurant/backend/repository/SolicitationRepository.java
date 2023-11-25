package com.admrestaurant.backend.repository;

import com.admrestaurant.backend.entities.Solicitation;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface SolicitationRepository extends JpaRepository<Solicitation, Long> {

  @Query("""
      SELECT s FROM Solicitation s
        WHERE s.user.id = :userId and s.solicitationStatus != 'CANCELED'
      """)
  List<Solicitation> findByUserId(Long userId);
}
