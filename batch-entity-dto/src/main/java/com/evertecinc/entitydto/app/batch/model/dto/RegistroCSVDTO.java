package com.evertecinc.entitydto.app.batch.model.dto;

import java.time.LocalDateTime;

/**
 * DTO (Data Transfer Object) para transferir datos de RegistroCSV.
 * Este DTO puede ser usado para transferir datos entre capas sin exponer la entidad JPA.
 * 
 * @author Evertec Inc.
 * @version 1.0.0
 */
public class RegistroCSVDTO {

    private Long id;
    private String nombre;
    private Integer edad;
    private String email;
    private LocalDateTime fechaProceso;

    /**
     * Constructor sin argumentos.
     */
    public RegistroCSVDTO() {
    }

    /**
     * Constructor completo con todos los campos.
     */
    public RegistroCSVDTO(Long id, String nombre, Integer edad, String email, LocalDateTime fechaProceso) {
        this.id = id;
        this.nombre = nombre;
        this.edad = edad;
        this.email = email;
        this.fechaProceso = fechaProceso;
    }

    /**
     * Constructor sin ID (para creación de nuevos registros).
     */
    public RegistroCSVDTO(String nombre, Integer edad, String email, LocalDateTime fechaProceso) {
        this.nombre = nombre;
        this.edad = edad;
        this.email = email;
        this.fechaProceso = fechaProceso;
    }

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDateTime getFechaProceso() {
        return fechaProceso;
    }

    public void setFechaProceso(LocalDateTime fechaProceso) {
        this.fechaProceso = fechaProceso;
    }
}

