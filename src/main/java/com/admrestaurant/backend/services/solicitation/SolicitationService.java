package com.admrestaurant.backend.services.solicitation;

import com.admrestaurant.backend.common.SecurityUtils;
import com.admrestaurant.backend.entities.Solicitation;
import com.admrestaurant.backend.entities.SolicitationStatus;
import com.admrestaurant.backend.repository.SolicitationRepository;
import java.util.List;
import java.util.Objects;
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
      Solicitation solicitationForSaved = solicitationRepository.findById(solicitation.getId()).orElseThrow(
          () -> new ResponseStatusException(
              HttpStatus.NOT_FOUND,
              "Solicitation not found with id: " + solicitation.getId()
          )
      );

      if (Objects.equals(solicitationForSaved.getSolicitationStatus(), SolicitationStatus.DONE)
          ||
          Objects.equals(solicitationForSaved.getSolicitationStatus(), SolicitationStatus.CANCELED)
      ) {
        throw new ResponseStatusException(
            HttpStatus.BAD_REQUEST,
            "Solicitation can't be updated"
        );
      }

      solicitationForSaved.setSolicitationStatus(solicitation.getSolicitationStatus());

      var solicitationSaved = solicitationRepository.save(solicitationForSaved);

      solicitationSaved.setUser(null);

      return solicitationSaved;

  }

  public Solicitation create(Solicitation solicitation) {

    if (solicitation.getSolicitationProducts().isEmpty()) {
      throw new ResponseStatusException(
          HttpStatus.BAD_REQUEST,
          "Solicitation must have at least one product"
      );
    }
    solicitation.setSolicitationStatus(SolicitationStatus.SOLICITATION);
    solicitation.setUser(SecurityUtils.getCurrentUser());

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
