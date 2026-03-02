package com.example.gestion_tienda.service;

import com.example.gestion_tienda.dto.request.ProductoRequestDTO;
import com.example.gestion_tienda.dto.response.ProductoResponseDTO;

import java.util.List;

public interface ProductoService {

    ProductoResponseDTO guardarProducto(ProductoRequestDTO dto);

    ProductoResponseDTO actualizarProducto(ProductoRequestDTO dto, Long id);

    void eliminarProducto(Long id);

    List<ProductoResponseDTO> buscarTodos();

    ProductoResponseDTO buscarPorId(Long id);


}
