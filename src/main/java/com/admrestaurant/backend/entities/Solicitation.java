package com.admrestaurant.backend.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.time.LocalDateTime;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "pedido")
public class Solicitation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "data_criacao")
    LocalDateTime creationDate;

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private SolicitationStatus solicitationStatus;

    @OneToMany(mappedBy = "solicitation")
    private List<SolicitationProduct> solicitationProducts;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private User user;
}
