package com.example.gestion_tienda.mapper;

import com.example.gestion_tienda.dto.request.DetalleVentaRequestDTO;
import com.example.gestion_tienda.dto.response.DetalleVentaResponseDTO;
import com.example.gestion_tienda.dto.response.ProductoResponseDTO;
import com.example.gestion_tienda.dto.response.VentaResponseDTO;
import com.example.gestion_tienda.modelo.DetalleVenta;
import com.example.gestion_tienda.modelo.Producto;
import com.example.gestion_tienda.modelo.Venta;
import org.springframework.stereotype.Component;

@Component
public class DetalleVentaMapper {

    public DetalleVentaResponseDTO entidadADTO(DetalleVenta detalleVenta, ProductoResponseDTO dtoP, VentaResponseDTO dtoV) {
        if (detalleVenta == null || dtoP == null || dtoV == null) return null;
        return new DetalleVentaResponseDTO(
                detalleVenta.getId(),
                detalleVenta.getCantidad(),
                detalleVenta.getSubtotal(),
                dtoV,
                dtoP
        );
    }

    public DetalleVenta DTOAentidad(DetalleVentaRequestDTO dto, Venta venta, Producto producto) {
        if (dto == null || venta == null || producto == null) return null;
        DetalleVenta dV = new DetalleVenta();
        dV.setCantidad(dto.cantidad());
        dV.setSubtotal(dto.subtotal());
        dV.setVenta(venta);
        dV.setProducto(producto);
        return dV;
    }

    public void actualizarEntidadDesdeDTO(DetalleVenta dv, DetalleVentaRequestDTO dto, Venta venta, Producto producto) {
        if (dv == null || dto == null || venta == null || producto == null) return;
        dv.setCantidad(dto.cantidad());
        dv.setSubtotal(dto.subtotal());
        dv.setProducto(producto);
        dv.setVenta(venta);
    }
}
