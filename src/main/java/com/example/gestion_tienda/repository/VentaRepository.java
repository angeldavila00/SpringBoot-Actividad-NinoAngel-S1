package com.example.gestion_tienda.repository;

import com.example.gestion_tienda.modelo.Venta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VentaRepository extends JpaRepository<Venta, Long> {

   Venta findByClienteIgnoreCase(String cliente);

   List<Venta> findAllByClienteIgnoreCase(String cliente);

   boolean existsByClienteIgnoreCase(String cliente);
   Long countById(Long id);
}
