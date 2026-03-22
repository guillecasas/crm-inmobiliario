package com.navas.crm.repository;

import com.navas.crm.model.Propiedad;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PropiedadRepository extends JpaRepository<Propiedad, Long> {

    List<Propiedad> findByEstado(String estado);

    List<Propiedad> findByTipo(String tipo);

    List<Propiedad> findByPrecioLessThanEqual(Double precio);
}