package com.example.gestion_tienda.modelo;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "venta")
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
public class Venta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String cliente;
    @Column(nullable = false)
    private String vendedor;
    @Column(nullable = false)
    private BigDecimal total;
    @Column(nullable = false)
    private Date fecha;

}
