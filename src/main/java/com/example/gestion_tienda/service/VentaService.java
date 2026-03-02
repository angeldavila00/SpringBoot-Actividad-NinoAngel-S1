package com.example.gestion_tienda.service;

import com.example.gestion_tienda.dto.request.VentaRequestDTO;
import com.example.gestion_tienda.dto.response.VentaResponseDTO;

import java.util.List;

public interface VentaService {

    VentaResponseDTO guardarVenta(VentaRequestDTO dto) ;

    VentaResponseDTO actualizarVenta(VentaRequestDTO dto, Long id);

    void eliminarVenta(Long id);

    List<VentaResponseDTO> buscarVentas();

    List<VentaResponseDTO> buscarCliente(String cliente);

    VentaResponseDTO buscarPorId(Long id);


}
