package com.evertecinc.entitydto.app.batch.model.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

/**
 * Entidad JPA que representa un registro CSV procesado.
 * Esta entidad puede ser reutilizada en múltiples proyectos batch.
 * 
 * @author Evertec Inc.
 * @version 1.0.0
 */
@Entity
@Table(name = "registrocsv")
public class RegistroCSV {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 255)
    private String nombre;

    @Column(nullable = false)
    private Integer edad;

    @Column(nullable = false, length = 255, unique = true)
    private String email;

    @Column(name = "fecha_proceso", nullable = false)
    private LocalDateTime fechaProceso;

    /**
     * Constructor sin argumentos.
     */
    public RegistroCSV() {
    }

    /**
     * Constructor completo con todos los campos.
     */
    public RegistroCSV(Long id, String nombre, Integer edad, String email, LocalDateTime fechaProceso) {
        this.id = id;
        this.nombre = nombre;
        this.edad = edad;
        this.email = email;
        this.fechaProceso = fechaProceso;
    }

    /**
     * Constructor sin ID (para creación de nuevos registros).
     */
    public RegistroCSV(String nombre, Integer edad, String email, LocalDateTime fechaProceso) {
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

