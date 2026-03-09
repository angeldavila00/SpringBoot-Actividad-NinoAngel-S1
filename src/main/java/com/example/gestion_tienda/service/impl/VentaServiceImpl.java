package com.example.gestion_tienda.service.impl;

import com.example.gestion_tienda.dto.request.VentaRequestDTO;
import com.example.gestion_tienda.dto.response.VentaResponseDTO;
import com.example.gestion_tienda.mapper.VentaMapper;
import com.example.gestion_tienda.modelo.Venta;
import com.example.gestion_tienda.repository.VentaRepository;
import com.example.gestion_tienda.service.VentaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class VentaServiceImpl implements VentaService {

    private final VentaMapper ventaMapper;
    private final VentaRepository ventaRepository;

    @Override
    public VentaResponseDTO guardarVenta(VentaRequestDTO dto) {
        Venta v = ventaMapper.DTOAentidad(dto);
        Venta v_insert = ventaRepository.save(v);
        return ventaMapper.entidadADTO(v_insert);
    }

    @Override
    public VentaResponseDTO actualizarVenta(VentaRequestDTO dto, Long id) {
        Venta v = ventaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("No existe la venta con el id: " + id));
        ventaMapper.actualizarEntidadDesdeDTO(v, dto);
        Venta v_actualizada = ventaRepository.save(v);
        return ventaMapper.entidadADTO(v_actualizada);
    }

    @Override
    public void eliminarVenta(Long id) {
        Venta v = ventaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("No existe la venta con el id: " + id));
        ventaRepository.delete(v);
    }

    @Override
    public List<VentaResponseDTO> buscarVentas() {
        return ventaRepository.findAll().stream()
                .map(ventaMapper::entidadADTO)
                .toList();
    }

    @Override
    public List<VentaResponseDTO> buscarCliente(String cliente) {
        return ventaRepository.findAllByClienteIgnoreCase(cliente).stream()
                .map(ventaMapper::entidadADTO)
                .toList();
    }

    @Override
    public VentaResponseDTO buscarPorId(Long id) {
        Venta v = ventaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("No existe la venta con el id: " + id));
        return ventaMapper.entidadADTO(v);
    }

}
