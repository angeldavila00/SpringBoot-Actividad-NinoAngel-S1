package com.example.gestion_tienda.modelo;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Entity
@Table(name = "detalle_venta")
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
public class DetalleVenta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private Integer cantidad;
    @Column(nullable = false)
    private BigDecimal subtotal;

    //llaves
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "venta_id",nullable = false)
    private Venta venta;
    //Producto
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name ="producto_id", nullable = false)
    private Producto producto;
}

