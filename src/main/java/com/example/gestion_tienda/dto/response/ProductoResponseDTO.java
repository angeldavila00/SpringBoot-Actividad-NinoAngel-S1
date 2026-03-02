package com.example.gestion_tienda.dto.response;

import java.math.BigDecimal;

public record ProductoResponseDTO(
        Long id, String nombre, String descripcion,Integer stock, BigDecimal precio_compra, BigDecimal precio_venta
) {
}
