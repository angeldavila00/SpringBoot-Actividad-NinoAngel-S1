package com.example.gestion_tienda.dto.request;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;

public record VentaRequestDTO(
        String cliente,
        String vendedor,
        BigDecimal total,
        Date fecha

) {
}
