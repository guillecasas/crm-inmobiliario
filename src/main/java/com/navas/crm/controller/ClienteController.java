package com.navas.crm.controller;

import com.navas.crm.model.Cliente;
import com.navas.crm.service.ClienteService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    private final ClienteService clienteService;

    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @GetMapping
    public List<Cliente> getClientes() {
        return clienteService.getClientes();
    }

    @PostMapping
    public Cliente addCliente(@RequestBody Cliente cliente) {
        return clienteService.addCliente(cliente);
    }
}