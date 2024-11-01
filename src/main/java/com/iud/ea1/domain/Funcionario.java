/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.iud.ea1.domain;

import jakarta.persistence.*;

import java.time.LocalDate;

/**
 *
 * @author alejo
 */
@Entity
public class Funcionario {

    @Id
    @Column(name = "FUNCIONARIO_ID")
    private String funcionarioId;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "GRUPO_FAMILIAR_ID")
    private GrupoFamiliar grupofamiliarId;
    private String nombre;
    private String apellido;
    @Column(name = "ESTADO_CIVIL")
    private String estadoCivil;
    private String sexo;
    private String direccion;
    private String telefono;
    @Column(name = "FECHA_NACIMIENTO")
    private LocalDate fechaNacimiento;

    public Funcionario() {
    }

    public Funcionario(String funcionarioId, GrupoFamiliar grupofamiliarId, String nombre, String apellido, String estadoCivil, String sexo, String direccion, String telefono, LocalDate fecha_nacimiento) {
        this.funcionarioId = funcionarioId;
        this.grupofamiliarId = grupofamiliarId;
        this.nombre = nombre;
        this.apellido = apellido;
        this.estadoCivil = estadoCivil;
        this.sexo = sexo;
        this.direccion = direccion;
        this.telefono = telefono;
        this.fechaNacimiento = fecha_nacimiento;
    }

    public String getFuncionarioId() {
        return funcionarioId;
    }

    public void setFuncionarioId(String funcionarioId) {
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

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fecha_nacimiento) {
        this.fechaNacimiento = fecha_nacimiento;
    }
}
