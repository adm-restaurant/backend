package com.admrestaurant.backend.services.solicitation;

import com.admrestaurant.backend.common.SecurityUtils;
import com.admrestaurant.backend.entities.Solicitation;
import com.admrestaurant.backend.repository.SolicitationRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class SolicitationService {
  private final SolicitationRepository solicitationRepository;

  public List<Solicitation> findByCurrentUserId() {
    return solicitationRepository.findByUserId(SecurityUtils.getCurrentUserId());
  }
}
