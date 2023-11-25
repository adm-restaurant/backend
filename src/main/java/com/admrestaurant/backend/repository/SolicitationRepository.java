package com.admrestaurant.backend.repository;

import com.admrestaurant.backend.entities.Solicitation;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SolicitationRepository extends JpaRepository<Solicitation, Long> {
  List<Solicitation> findByUserId(Long userId);
}
