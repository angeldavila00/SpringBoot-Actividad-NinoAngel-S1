package com.example.gestion_tienda.modelo;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
@Entity
@Table(name = "producto")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String nombre;
    @Column(nullable = false)
    private String descripcion;
    @Column(nullable = false)
    private Integer stock;
    @Column(nullable = false)
    private BigDecimal precio_compra;
    @Column(nullable = false)
    private BigDecimal precio_venta;



}
