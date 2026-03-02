package com.example.gestion_tienda.mapper;

import com.example.gestion_tienda.dto.request.VentaRequestDTO;
import com.example.gestion_tienda.dto.response.VentaResponseDTO;
import com.example.gestion_tienda.modelo.Venta;
import org.springframework.stereotype.Component;

@Component
public class VentaMapper {
    public VentaResponseDTO entidadADTO(Venta venta) {
        if(venta == null) return null;
        return new VentaResponseDTO(
                venta.getId(), venta.getCliente(), venta.getVendedor(), venta.getTotal(), venta.getFecha()
        );
    }

    public Venta DTOAentidad(VentaRequestDTO dto) {
        if(dto == null) return null;
        Venta v = new Venta();
        v.setCliente(dto.cliente());
        v.setVendedor(dto.vendedor());
        v.setTotal(dto.total());
        v.setFecha(dto.fecha());
        return v;
    }

    public void actualizarEntidadDesdeDTO (Venta venta, VentaRequestDTO dto) {
        if(venta == null || dto == null) return;
        venta.setFecha(dto.fecha());
        venta.setCliente(dto.cliente());
        venta.setVendedor(dto.vendedor());
        venta.setTotal(dto.total());
        venta.setFecha(dto.fecha());
    }
}
