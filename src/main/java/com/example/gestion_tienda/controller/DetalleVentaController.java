package com.example.gestion_tienda.controller;

import com.example.gestion_tienda.dto.request.DetalleVentaRequestDTO;
import com.example.gestion_tienda.dto.response.DetalleVentaResponseDTO;
import com.example.gestion_tienda.service.impl.DetalleVentaServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name ="Detalle Venta", description = "Procesa todo lo relacionado con detalle de venta")
@RestController
@RequestMapping("/api/detalleventa")
@RequiredArgsConstructor
public class DetalleVentaController {

    private final DetalleVentaServiceImpl detalleVentaService;
    @Operation(summary = "Guarda los detalles de venta",
            description = "Permite Guardar los detalle de venta")
    @PostMapping
    public ResponseEntity<DetalleVentaResponseDTO> guardar(@RequestBody DetalleVentaRequestDTO dto){
        return ResponseEntity.status(HttpStatus.CREATED).body(detalleVentaService.guardarDetalleVenta(dto));
    }
    @Operation(summary = "Actualiza los detalle de venta",
            description = "Permite Actualizar los detalle de venta")
    @PutMapping("/{id}")
    public ResponseEntity<DetalleVentaResponseDTO> actualizar(@RequestBody DetalleVentaRequestDTO dto, @PathVariable Long id){
        return ResponseEntity.ok().body(detalleVentaService.actualizarDetalleVenta(dto, id));
    }

    @GetMapping
    public ResponseEntity<List<DetalleVentaResponseDTO>> listarTodos(){
        return ResponseEntity.ok().body(detalleVentaService.listarDetalles());
    }
    @Operation(summary = "Buscar por ID los detalle de venta",
            description = "Busca por id")
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
