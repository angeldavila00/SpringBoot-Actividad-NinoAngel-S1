package com.example.gestion_tienda.dto.response;

import java.math.BigDecimal;

public record DetalleVentaResponseDTO(
        Long id, Integer cantidad, BigDecimal subtotal, VentaResponseDTO venta, ProductoResponseDTO producto
) {
}
