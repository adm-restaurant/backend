package com.admrestaurant.backend.resources.solicitation;

import com.admrestaurant.backend.entities.Solicitation;
import com.admrestaurant.backend.services.solicitation.SolicitationService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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

  @PostMapping
  public Solicitation create(
      @RequestBody Solicitation solicitation
  ) {
    return this.solicitationService.create(solicitation);
  }

  @PutMapping
  public Solicitation update(
      @RequestBody Solicitation solicitation
  ) {
    return this.solicitationService.update(solicitation);
  }

  @DeleteMapping("/{id}")
  public void cancel(
      @RequestBody Long id
  ) {
    this.solicitationService.cancel(id);
  }
}
