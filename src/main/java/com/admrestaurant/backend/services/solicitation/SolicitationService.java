package com.admrestaurant.backend.services.solicitation;

import com.admrestaurant.backend.common.SecurityUtils;
import com.admrestaurant.backend.entities.Solicitation;
import com.admrestaurant.backend.entities.SolicitationStatus;
import com.admrestaurant.backend.repository.SolicitationRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@RequiredArgsConstructor
@Service
public class SolicitationService {
  private final SolicitationRepository solicitationRepository;

  public List<Solicitation> findByCurrentUserId() {
    return solicitationRepository.findByUserId(SecurityUtils.getCurrentUserId());
  }

  public Solicitation update(Solicitation solicitation) {
    return solicitationRepository.save(solicitation);
  }

  public Solicitation create(Solicitation solicitation) {
    return solicitationRepository.save(solicitation);
  }

  public void cancel(Long id) {
    Solicitation solicitation = solicitationRepository.findById(id).orElseThrow(
        () -> new ResponseStatusException(
            HttpStatus.NOT_FOUND,
            "Solicitation not found with id: " + id
        ) {
        }
    );
    solicitation.setSolicitationStatus(SolicitationStatus.CANCELED);
    solicitationRepository.save(solicitation);
  }
}
