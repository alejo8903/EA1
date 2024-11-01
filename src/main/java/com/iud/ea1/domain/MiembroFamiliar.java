/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.iud.ea1.domain;

import jakarta.persistence.*;

/**
 *
 * @author alejo
 */
@Entity
public class MiembroFamiliar {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ID")
    private GrupoFamiliar grupoFamiliarId;
    private String nombre;
    private String parentesco;
    private int edad;

    public MiembroFamiliar() {
    }

    public MiembroFamiliar(int id, GrupoFamiliar grupoFamiliarId, String nombre, String parentesco, int edad) {
        this.id = id;
        this.grupoFamiliarId = grupoFamiliarId;
        this.nombre = nombre;
        this.parentesco = parentesco;
        this.edad = edad;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public GrupoFamiliar getGrupoFamiliarId() {
        return grupoFamiliarId;
    }

    public void setGrupoFamiliarId(GrupoFamiliar grupoFamiliarId) {
        this.grupoFamiliarId = grupoFamiliarId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getParentesco() {
        return parentesco;
    }

    public void setParentesco(String parentesco) {
        this.parentesco = parentesco;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }
    
    
}
