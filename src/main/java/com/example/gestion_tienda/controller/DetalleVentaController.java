package com.example.gestion_tienda.controller;

import com.example.gestion_tienda.dto.request.DetalleVentaRequestDTO;
import com.example.gestion_tienda.dto.response.DetalleVentaResponseDTO;
import com.example.gestion_tienda.service.impl.DetalleVentaServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/detalleventa")
@RequiredArgsConstructor
public class DetalleVentaController {

    private final DetalleVentaServiceImpl detalleVentaService;

    @PostMapping
    public ResponseEntity<DetalleVentaResponseDTO> guardar(@RequestBody DetalleVentaRequestDTO dto){
        return ResponseEntity.status(HttpStatus.CREATED).body(detalleVentaService.guardarDetalleVenta(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<DetalleVentaResponseDTO> actualizar(@RequestBody DetalleVentaRequestDTO dto, @PathVariable Long id){
        return ResponseEntity.ok().body(detalleVentaService.actualizarDetalleVenta(dto, id));
    }

    @GetMapping
    public ResponseEntity<List<DetalleVentaResponseDTO>> listarTodos(){
        return ResponseEntity.ok().body(detalleVentaService.listarDetalles());
    }

    @GetMapping("/{id}")
    public ResponseEntity<DetalleVentaResponseDTO> buscarId(@PathVariable Long id){
        return ResponseEntity.ok().body(detalleVentaService.buscarPorId(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id){
        detalleVentaService.eliminarDetalleVenta(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
