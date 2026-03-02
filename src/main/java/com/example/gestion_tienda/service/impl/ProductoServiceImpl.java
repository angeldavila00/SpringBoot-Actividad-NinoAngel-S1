package com.example.gestion_tienda.service.impl;

import com.example.gestion_tienda.dto.request.ProductoRequestDTO;
import com.example.gestion_tienda.dto.response.ProductoResponseDTO;
import com.example.gestion_tienda.mapper.ProductoMapper;
import com.example.gestion_tienda.modelo.Producto;
import com.example.gestion_tienda.repository.ProductoRepository;
import com.example.gestion_tienda.service.ProductoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductoServiceImpl implements ProductoService {

    private final ProductoMapper productoMapper;
    private final ProductoRepository productoRepository;

    @Override
    public ProductoResponseDTO guardarProducto(ProductoRequestDTO dto) {
        Producto p = productoMapper.DTOAentidad(dto);
        Producto p_insert = productoRepository.save(p);
        return productoMapper.entidadADTO(p_insert);
    }

    @Override
    public ProductoResponseDTO actualizarProducto(ProductoRequestDTO dto, Long id) {
        Producto p = productoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("No existe el producto con el id: " + id));
        productoMapper.actualizarEntidadDesdeDTO(p, dto);
        Producto p_actualizado = productoRepository.save(p);
        return productoMapper.entidadADTO(p_actualizado);
    }

    @Override
    public void eliminarProducto(Long id) {
        Producto p = productoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("No existe el producto con el id: " + id));
        productoRepository.delete(p);
    }

    @Override
    public List<ProductoResponseDTO> buscarTodos() {
        return productoRepository.findAll().stream()
                .map(productoMapper::entidadADTO)
                .toList();
    }

    @Override
    public ProductoResponseDTO buscarPorId(Long id) {
        Producto p = productoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("No existe el producto con el id: " + id));
        return productoMapper.entidadADTO(p);
    }


}
