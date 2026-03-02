package com.example.gestion_tienda.service.impl;

import com.example.gestion_tienda.dto.request.DetalleVentaRequestDTO;
import com.example.gestion_tienda.dto.response.DetalleVentaResponseDTO;
import com.example.gestion_tienda.dto.response.ProductoResponseDTO;
import com.example.gestion_tienda.dto.response.VentaResponseDTO;
import com.example.gestion_tienda.mapper.DetalleVentaMapper;
import com.example.gestion_tienda.mapper.ProductoMapper;
import com.example.gestion_tienda.mapper.VentaMapper;
import com.example.gestion_tienda.modelo.DetalleVenta;
import com.example.gestion_tienda.modelo.Producto;
import com.example.gestion_tienda.modelo.Venta;
import com.example.gestion_tienda.repository.DetalleVentaRepository;
import com.example.gestion_tienda.repository.ProductoRepository;
import com.example.gestion_tienda.repository.VentaRepository;
import com.example.gestion_tienda.service.DetalleVentaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DetalleVentaServiceImpl implements DetalleVentaService {

    private final DetalleVentaRepository detalleVentaRepository;
    private final DetalleVentaMapper detalleVentaMapper;

    private final VentaRepository ventaRepository;
    private final VentaMapper ventaMapper;

    private final ProductoRepository productoRepository;
    private final ProductoMapper productoMapper;

    @Override
    public DetalleVentaResponseDTO guardarDetalleVenta(DetalleVentaRequestDTO dto) {
        Venta v = ventaRepository.findById(dto.ventaId())
                .orElseThrow(() -> new RuntimeException("Error, no existe dicha venta"));
        Producto p = productoRepository.findById(dto.productoId())
                .orElseThrow(() -> new RuntimeException("Error, no existe dicho producto"));

        DetalleVenta dv = detalleVentaMapper.DTOAentidad(dto, v, p);
        DetalleVenta dv_insertado = detalleVentaRepository.save(dv);

        VentaResponseDTO dtoV = ventaMapper.entidadADTO(v);
        ProductoResponseDTO dtoP = productoMapper.entidadADTO(p);
        return detalleVentaMapper.entidadADTO(dv_insertado, dtoP, dtoV);
    }

    @Override
    public DetalleVentaResponseDTO actualizarDetalleVenta(DetalleVentaRequestDTO dto, Long id) {
        DetalleVenta dv = detalleVentaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Error, no existe dicho detalle de venta a actualizar"));

        Venta v = ventaRepository.findById(dto.ventaId())
                .orElseThrow(() -> new RuntimeException("Error, no existe dicha venta"));
        Producto p = productoRepository.findById(dto.productoId())
                .orElseThrow(() -> new RuntimeException("Error, no existe dicho producto"));

        detalleVentaMapper.actualizarEntidadDesdeDTO(dv, dto, v, p);
        DetalleVenta dv_actualizado = detalleVentaRepository.save(dv);

        VentaResponseDTO dtoV = ventaMapper.entidadADTO(v);
        ProductoResponseDTO dtoP = productoMapper.entidadADTO(p);
        return detalleVentaMapper.entidadADTO(dv_actualizado, dtoP, dtoV);
    }

    @Override
    public void eliminarDetalleVenta(Long id) {
        DetalleVenta dv = detalleVentaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("No existe dicho detalle de venta a eliminar"));
        detalleVentaRepository.delete(dv);
    }

    @Override
    public List<DetalleVentaResponseDTO> listarDetalles() {
        return detalleVentaRepository.findAll().stream()
                .map(dato -> {
                    Venta v = ventaRepository.findById(dato.getVenta().getId())
                            .orElseThrow(() -> new RuntimeException("NO EXISTE DICHA VENTA"));
                    Producto p = productoRepository.findById(dato.getProducto().getId())
                            .orElseThrow(() -> new RuntimeException("NO EXISTE DICHO PRODUCTO"));
                    return detalleVentaMapper.entidadADTO(dato, productoMapper.entidadADTO(p), ventaMapper.entidadADTO(v));
                })
                .toList();
    }

    @Override
    public DetalleVentaResponseDTO buscarPorId(Long id) {
        DetalleVenta dv = detalleVentaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("No existe dicho detalle de venta"));
        Venta v = ventaRepository.findById(dv.getVenta().getId())
                .orElseThrow(() -> new RuntimeException("NO EXISTE DICHA VENTA"));
        Producto p = productoRepository.findById(dv.getProducto().getId())
                .orElseThrow(() -> new RuntimeException("NO EXISTE DICHO PRODUCTO"));
        return detalleVentaMapper.entidadADTO(dv, productoMapper.entidadADTO(p), ventaMapper.entidadADTO(v));
    }

    @Override
    public List<DetalleVentaResponseDTO> buscarPorVentaId(Long ventaId) {
        return detalleVentaRepository.findByVentaId(ventaId).stream()
                .map(dato -> {
                    Venta v = ventaRepository.findById(dato.getVenta().getId())
                            .orElseThrow(() -> new RuntimeException("NO EXISTE DICHA VENTA"));
                    Producto p = productoRepository.findById(dato.getProducto().getId())
                            .orElseThrow(() -> new RuntimeException("NO EXISTE DICHO PRODUCTO"));
                    return detalleVentaMapper.entidadADTO(dato, productoMapper.entidadADTO(p), ventaMapper.entidadADTO(v));
                })
                .toList();
    }
}
