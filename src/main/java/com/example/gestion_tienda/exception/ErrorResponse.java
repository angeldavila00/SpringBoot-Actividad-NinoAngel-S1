package com.example.gestion_tienda.exception;

import java.time.LocalDateTime;

public record ErrorResponse(LocalDateTime timestamp, int status, String message, String errorCode) {
}
