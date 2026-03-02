package com.example.gestion_tienda.dto.response;

import java.math.BigDecimal;
import java.util.Date;


public record VentaResponseDTO(
        Long id, String cliente, String vendedor, BigDecimal total, Date fecha
) {
}
