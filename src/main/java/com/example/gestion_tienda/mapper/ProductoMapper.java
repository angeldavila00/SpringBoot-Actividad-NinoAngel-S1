package com.example.gestion_tienda.mapper;

import com.example.gestion_tienda.dto.request.ProductoRequestDTO;
import com.example.gestion_tienda.dto.response.ProductoResponseDTO;
import com.example.gestion_tienda.modelo.Producto;
import org.springframework.stereotype.Component;

@Component
public class ProductoMapper {

    public ProductoResponseDTO entidadADTO(Producto producto) {
        if(producto == null) return null;
        return new ProductoResponseDTO(
                producto.getId(), producto.getNombre(),producto.getDescripcion(), producto.getStock(), producto.getPrecio_compra(), producto.getPrecio_venta()
        );
    }


    public Producto DTOAentidad(ProductoRequestDTO dto) {
        if(dto == null) return null;
        Producto p = new Producto();
        p.setNombre(dto.nombre());
        p.setDescripcion(dto.descripcion());
        p.setStock(dto.stock());
        p.setPrecio_compra(dto.precio_compra());
        p.setPrecio_venta(dto.precio_venta());
        return p;
    }

    public void actualizarEntidadDesdeDTO (Producto producto, ProductoRequestDTO dto) {
        if(producto == null || dto == null) return;
        producto.setNombre(dto.nombre());
        producto.setDescripcion(dto.descripcion());
        producto.setStock(dto.stock());
        producto.setPrecio_compra(dto.precio_compra());
        producto.setPrecio_venta(dto.precio_venta());
    }
}
