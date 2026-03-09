package com.example.gestion_tienda.service;

import com.example.gestion_tienda.dto.request.DetalleVentaRequestDTO;
import com.example.gestion_tienda.dto.response.DetalleVentaResponseDTO;

import java.util.List;

public interface DetalleVentaService {

    DetalleVentaResponseDTO guardarDetalleVenta(DetalleVentaRequestDTO dto);

    DetalleVentaResponseDTO actualizarDetalleVenta(DetalleVentaRequestDTO dto, Long id);

    void eliminarDetalleVenta(Long id);

    List<DetalleVentaResponseDTO> listarDetalles();

    DetalleVentaResponseDTO buscarPorId(Long id);

    List<DetalleVentaResponseDTO> buscarPorVentaId(Long ventaId);
}
