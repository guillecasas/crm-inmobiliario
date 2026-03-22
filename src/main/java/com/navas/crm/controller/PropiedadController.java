package com.navas.crm.controller;

import com.navas.crm.model.Propiedad;
import com.navas.crm.service.PropiedadService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/propiedades")
public class PropiedadController {

    private final PropiedadService propiedadService;

    public PropiedadController(PropiedadService propiedadService) {
        this.propiedadService = propiedadService;
    }

    @GetMapping
    public List<Propiedad> getPropiedades() {
        return propiedadService.getPropiedades();
    }

    @PostMapping
    public Propiedad addPropiedad(@RequestBody Propiedad propiedad) {
        return propiedadService.addPropiedad(propiedad);
    }

    @GetMapping("/estado/{estado}")
    public List<Propiedad> getPropiedadesPorEstado(@PathVariable String estado) {
        return propiedadService.getPropiedadesPorEstado(estado);
    }

    @GetMapping("/tipo/{tipo}")
    public List<Propiedad> getPropiedadesPorTipo(@PathVariable String tipo) {
        return propiedadService.getPropiedadesPorTipo(tipo);
    }

    @GetMapping("/precio-max/{precio}")
    public List<Propiedad> getPropiedadesPorPrecioMax(@PathVariable Double precio) {
        return propiedadService.getPropiedadesPorPrecioMax(precio);
    }
}