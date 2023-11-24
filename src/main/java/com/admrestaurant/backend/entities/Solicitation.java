package com.admrestaurant.backend.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

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
