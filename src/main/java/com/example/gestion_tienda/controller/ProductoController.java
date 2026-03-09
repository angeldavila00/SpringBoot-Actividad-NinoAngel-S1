package com.example.gestion_tienda.controller;

import com.example.gestion_tienda.dto.request.ProductoRequestDTO;
import com.example.gestion_tienda.dto.response.ProductoResponseDTO;
import com.example.gestion_tienda.service.impl.ProductoServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Tag(name ="Producto", description = "Procesa todo lo relacionado con producto")
@RestController
@RequestMapping("/api/producto")
@RequiredArgsConstructor
@Validated
public class ProductoController {

    private final ProductoServiceImpl productoService;

    @PostMapping
    public ResponseEntity<ProductoResponseDTO> guardar(@Valid @RequestBody ProductoRequestDTO dto){
        return ResponseEntity.status(HttpStatus.CREATED).body(productoService.guardarProducto(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductoResponseDTO> actualizar(@Valid @RequestBody ProductoRequestDTO dto, @PathVariable Long id){
        return ResponseEntity.ok().body(productoService.actualizarProducto(dto, id));
    }
    @Operation
    @GetMapping
    public ResponseEntity<List<ProductoResponseDTO>> listarTodos(){
        return ResponseEntity.ok().body(productoService.buscarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductoResponseDTO> buscarId(@PathVariable Long id){
        return ResponseEntity.ok().body(productoService.buscarPorId(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id){
        productoService.eliminarProducto(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
