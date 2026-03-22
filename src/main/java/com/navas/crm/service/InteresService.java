package com.navas.crm.service;

import com.navas.crm.dto.InteresRequest;
import com.navas.crm.model.Cliente;
import com.navas.crm.model.Interes;
import com.navas.crm.model.Propiedad;
import com.navas.crm.repository.ClienteRepository;
import com.navas.crm.repository.InteresRepository;
import com.navas.crm.repository.PropiedadRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InteresService {

    private final InteresRepository interesRepository;
    private final ClienteRepository clienteRepository;
    private final PropiedadRepository propiedadRepository;

    public InteresService(InteresRepository interesRepository,
                          ClienteRepository clienteRepository,
                          PropiedadRepository propiedadRepository) {
        this.interesRepository = interesRepository;
        this.clienteRepository = clienteRepository;
        this.propiedadRepository = propiedadRepository;
    }

    public List<Interes> getIntereses() {
        return interesRepository.findAll();
    }

    public Interes addInteres(InteresRequest request) {
        Cliente cliente = clienteRepository.findById(request.getClienteId())
                .orElseThrow(() -> new RuntimeException("Cliente no encontrado"));

        Propiedad propiedad = propiedadRepository.findById(request.getPropiedadId())
                .orElseThrow(() -> new RuntimeException("Propiedad no encontrada"));

        Interes interes = new Interes();
        interes.setCliente(cliente);
        interes.setPropiedad(propiedad);
        interes.setFechaContacto(request.getFechaContacto());
        interes.setComentario(request.getComentario());

        return interesRepository.save(interes);
    }
}