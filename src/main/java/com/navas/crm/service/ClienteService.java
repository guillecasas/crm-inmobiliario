package com.navas.crm.service;

import com.navas.crm.model.Cliente;
import com.navas.crm.repository.ClienteRepository;
import com.navas.crm.repository.InteresRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class ClienteService {

    private final ClienteRepository clienteRepository;
    private final InteresRepository interesRepository;

    public ClienteService(ClienteRepository clienteRepository, InteresRepository interesRepository) {
        this.clienteRepository = clienteRepository;
        this.interesRepository = interesRepository;
    }

    public List<Cliente> getClientes() {
        return clienteRepository.findAll();
    }

    public Cliente getClienteById(Long id) {
        return clienteRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente no encontrado"));
    }

    public Cliente addCliente(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    public Cliente updateCliente(Long id, Cliente nuevoCliente) {
        Cliente cliente = clienteRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente no encontrado"));

        cliente.setNombre(nuevoCliente.getNombre());
        cliente.setTelefono(nuevoCliente.getTelefono());
        cliente.setEmail(nuevoCliente.getEmail());

        return clienteRepository.save(cliente);
    }

    public void deleteCliente(Long id) {
        if (!clienteRepository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente no encontrado");
        }

        if (interesRepository.existsByClienteId(id)) {
            throw new ResponseStatusException(HttpStatus.CONFLICT,
                    "No se puede eliminar el cliente porque tiene intereses asociados");
        }

        clienteRepository.deleteById(id);
    }
}