package com.example.gestion_tienda.dto.request;

import java.math.BigDecimal;

public record DetalleVentaRequestDTO(
        Integer cantidad,
        BigDecimal subtotal,
        Long ventaId,
        Long productoId

) {
}
