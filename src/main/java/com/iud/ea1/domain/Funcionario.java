/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.iud.ea1.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import java.time.LocalDate;

/**
 *
 * @author alejo
 */
@Entity
public class Funcionario {

    @Id
    private int funcionarioId;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ID")
    private GrupoFamiliar grupofamiliarId;
    private String nombre;
    private String apellido;
    private String estadoCivil;
    private String sexo;
    private String direccion;
    private String telefono;
    private LocalDate fecha_nacimiento;

    public Funcionario() {
    }

    public Funcionario(int funcionarioId, GrupoFamiliar grupofamiliarId, String nombre, String apellido, String estadoCivil, String sexo, String direccion, String telefono, LocalDate fecha_nacimiento) {
        this.funcionarioId = funcionarioId;
        this.grupofamiliarId = grupofamiliarId;
        this.nombre = nombre;
        this.apellido = apellido;
        this.estadoCivil = estadoCivil;
        this.sexo = sexo;
        this.direccion = direccion;
        this.telefono = telefono;
        this.fecha_nacimiento = fecha_nacimiento;
    }

    public int getFuncionarioId() {
        return funcionarioId;
    }

    public void setFuncionarioId(int funcionarioId) {
        this.funcionarioId = funcionarioId;
    }

    public GrupoFamiliar getGrupofamiliarId() {
        return grupofamiliarId;
    }

    public void setGrupofamiliarId(GrupoFamiliar grupofamiliarId) {
        this.grupofamiliarId = grupofamiliarId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(String estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public LocalDate getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    public void setFecha_nacimiento(LocalDate fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }
}
