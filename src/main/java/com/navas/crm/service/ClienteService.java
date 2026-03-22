package com.navas.crm.service;

import com.navas.crm.model.Cliente;
import com.navas.crm.repository.ClienteRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {

    private final ClienteRepository clienteRepository;

    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public List<Cliente> getClientes() {
        return clienteRepository.findAll();
    }

    public Cliente addCliente(Cliente cliente) {
        return clienteRepository.save(cliente);
    }
}