package com.example.gestion_tienda.dto.request;

import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public record ProductoRequestDTO(
        @NotNull(message = "El espacio no puede ser null")
        String nombre,
        String descripcion,
        Integer stock,
        BigDecimal precio_compra,
        BigDecimal precio_venta

) {
}
