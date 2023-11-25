package com.admrestaurant.backend.resources.solicitation;

import com.admrestaurant.backend.entities.Solicitation;
import com.admrestaurant.backend.services.solicitation.SolicitationService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/solicitation")
public class SolicitationResource {

  private final SolicitationService solicitationService;

  @GetMapping
  public List<Solicitation> findByCurrentUserId() {
    return this.solicitationService.findByCurrentUserId();
  }
}
