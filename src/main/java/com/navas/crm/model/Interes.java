package com.navas.crm.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class Interes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Cliente cliente;

    @ManyToOne
    private Propiedad propiedad;

    private LocalDate fechaContacto;
    private String comentario;

    public Interes() {
    }

    public Interes(Cliente cliente, Propiedad propiedad, LocalDate fechaContacto, String comentario) {
        this.cliente = cliente;
        this.propiedad = propiedad;
        this.fechaContacto = fechaContacto;
        this.comentario = comentario;
    }

    public Long getId() {
        return id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Propiedad getPropiedad() {
        return propiedad;
    }

    public void setPropiedad(Propiedad propiedad) {
        this.propiedad = propiedad;
    }

    public LocalDate getFechaContacto() {
        return fechaContacto;
    }

    public void setFechaContacto(LocalDate fechaContacto) {
        this.fechaContacto = fechaContacto;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }
}