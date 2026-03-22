package com.navas.crm.repository;

import com.navas.crm.model.Interes;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InteresRepository extends JpaRepository<Interes, Long> {

    boolean existsByClienteId(Long clienteId);
}