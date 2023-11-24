package com.admrestaurant.backend.entities;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "pedido_produto")
public class SolicitationProduct {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "pedido_id")
    private Solicitation solicitation;

    @ManyToOne
    @JoinColumn(name = "produto_id")
    private Product product;

    @Column(name = "quantidade")
    private Integer quantity;
}
