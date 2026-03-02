package com.example.gestion_tienda.controller;

import com.example.gestion_tienda.dto.request.VentaRequestDTO;
import com.example.gestion_tienda.dto.response.VentaResponseDTO;
import com.example.gestion_tienda.service.impl.VentaServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Tag(name ="Venta", description = "Procesa todo lo relacionado con ventas")
@RestController
@RequestMapping("/api/venta")
@RequiredArgsConstructor
public class VentaController {

    private final VentaServiceImpl ventaService;
    @Operation(summary = "Guarda las ventas",
            description = "Permite guardar la venta ")
    @PostMapping
    public ResponseEntity<VentaResponseDTO> guardar(@RequestBody VentaRequestDTO dto){
        return ResponseEntity.status(HttpStatus.CREATED).body(ventaService.guardarVenta(dto));
    }
    @Operation(summary = "Actualiza las ventas",
            description = "Permite Actualizar las ventas")
    @PutMapping("/{id}")
    public ResponseEntity<VentaResponseDTO> actualizar(@RequestBody VentaRequestDTO dto, @PathVariable Long id){
        return ResponseEntity.ok().body(ventaService.actualizarVenta(dto, id));
    }
    @Operation(summary = "Lista las ventas",
            description = "Permite mostrar las ventas por parametros")
    @GetMapping
    public ResponseEntity<List<VentaResponseDTO>> listarTodos(){
        return ResponseEntity.ok().body(ventaService.buscarVentas());
    }

    @GetMapping("/{id}")
    public ResponseEntity<VentaResponseDTO> buscarId(@Parameter(description = "Id de la venta a buscar", example = "1") @PathVariable Long id){
        return ResponseEntity.ok().body(ventaService.buscarPorId(id));
    }
@Operation(summary = "Eliminar las ventas")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@Parameter(description = "Id de la venta a eliminar", example = "1")
                                             @PathVariable Long id){
        ventaService.eliminarVenta(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
