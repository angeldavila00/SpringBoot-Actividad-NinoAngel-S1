package com.example.gestion_tienda.repository;

import com.example.gestion_tienda.modelo.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Long> {

    Producto findByNombreIgnoreCase(String nombre);
    List<Producto> findByNombreContainingIgnoreCase(String nombre);
    boolean existsByNombreIgnoreCase(String nombre);
    Long countByNombreIgnoreCase(String nombre);
}
