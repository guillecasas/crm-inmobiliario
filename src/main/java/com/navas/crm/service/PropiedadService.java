package com.navas.crm.service;

import com.navas.crm.model.Propiedad;
import com.navas.crm.repository.PropiedadRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PropiedadService {

    private final PropiedadRepository propiedadRepository;

    public PropiedadService(PropiedadRepository propiedadRepository) {
        this.propiedadRepository = propiedadRepository;
    }

    public List<Propiedad> getPropiedades() {
        return propiedadRepository.findAll();
    }

    public Propiedad addPropiedad(Propiedad propiedad) {
        return propiedadRepository.save(propiedad);
    }

    public List<Propiedad> getPropiedadesPorEstado(String estado) {
        return propiedadRepository.findByEstado(estado);
    }

    public List<Propiedad> getPropiedadesPorTipo(String tipo) {
        return propiedadRepository.findByTipo(tipo);
    }

    public List<Propiedad> getPropiedadesPorPrecioMax(Double precio) {
        return propiedadRepository.findByPrecioLessThanEqual(precio);
    }
}