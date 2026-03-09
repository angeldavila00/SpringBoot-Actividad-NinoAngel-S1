package com.example.gestion_tienda.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.gestion_tienda.dto.request.DetalleVentaRequestDTO;
import com.example.gestion_tienda.dto.response.DetalleVentaResponseDTO;
import com.example.gestion_tienda.service.impl.DetalleVentaServiceImpl;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

@Tag(name = "Detalle Venta", description = "Procesa todo lo relacionado con detalle de venta")
@RestController
@RequestMapping("/api/detalleventa")
@RequiredArgsConstructor
public class DetalleVentaController {

    private final DetalleVentaServiceImpl detalleVentaService;

    @Operation(summary = "Guarda los detalles de venta",
            description = "Permite Guardar los detalle de venta")
    @PostMapping
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "201",
                    description = "Detalle de venta creado exitosamente"
            ),
            @ApiResponse(
                    responseCode = "400",
                    description = "Datos no válidos / body mal estructurado"
            )
    }
    )
    public ResponseEntity<DetalleVentaResponseDTO> guardar(@RequestBody DetalleVentaRequestDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(detalleVentaService.guardarDetalleVenta(dto));
    }

    @Operation(summary = "Actualiza los detalle de venta",
            description = "Permite Actualizar los detalle de venta")
    @PutMapping("/{id}")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "201",
                    description = "Detalle de venta actualizado exitosamente"
            ),
            @ApiResponse(
                    responseCode = "400",
                    description = "Datos no válidos / body mal estructurado"
            )
    }
    )
    public ResponseEntity<DetalleVentaResponseDTO> actualizar(@RequestBody DetalleVentaRequestDTO dto, @PathVariable Long id) {
        return ResponseEntity.ok().body(detalleVentaService.actualizarDetalleVenta(dto, id));
    }
    @Operation(summary = "Lista los detalles de venta")
    @GetMapping
    public ResponseEntity<List<DetalleVentaResponseDTO>> listarTodos() {
        return ResponseEntity.ok().body(detalleVentaService.listarDetalles());
    }

    @Operation(summary = "Buscar por ID los detalle de venta",
            description = "Busca por id")
    @GetMapping("/{id}")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "201",
                    description = "Detalle de venta exitosamente"
            ),
            @ApiResponse(
                    responseCode = "400",
                    description = "Datos no válidos / body mal estructurado"
            )
    }
    )
    public ResponseEntity<DetalleVentaResponseDTO> buscarId(@PathVariable Long id) {
        return ResponseEntity.ok().body(detalleVentaService.buscarPorId(id));
    }
    @Operation(summary = "Elimina los detalles de venta")
    @DeleteMapping("/{id}")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "201",
                    description = "Detalle de venta eliminado exitosamente"
            ),
            @ApiResponse(
                    responseCode = "400",
                    description = "Datos no válidos / body mal estructurado"
            )
    }
    )
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        detalleVentaService.eliminarDetalleVenta(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
