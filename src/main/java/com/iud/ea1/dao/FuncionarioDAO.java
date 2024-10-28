/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.iud.ea1.dao;

import com.iud.ea1.domain.Funcionario;
import com.iud.ea1.domain.GrupoFamiliar;
import com.iud.ea1.util.JPAUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;

import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author alejo
 */
public class FuncionarioDAO {
    
    private EntityManagerFactory emf = JPAUtil.getEntityManagerFactory();
    
    private static String getALL = "SELECT f FROM Funcionario f";
    
    public void crearFuncionario(Funcionario funcionario) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(funcionario);
        em.getTransaction().commit();
        em.close();
    }
    
    public List<Funcionario> obtenerFuncionarios(){
        EntityManager em = emf.createEntityManager();
        List<Funcionario> funcionarios = em.createQuery(getALL,Funcionario.class).getResultList();
        em.close();
        return funcionarios;
    }
    
    public Funcionario obtenerPorId(int id){
        EntityManager em = emf.createEntityManager();
        Funcionario funcionario = em.find(Funcionario.class, id);
        em.close();
        return funcionario;
    }

    public void editarFuncionarioPorId(int id, Funcionario nuevoFuncionario) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Funcionario funcionario = em.find(Funcionario.class, id);
        if (funcionario != null) {
        funcionario.setNombre(nuevoFuncionario.getNombre());
        funcionario.setApellido(nuevoFuncionario.getApellido());
        funcionario.setEstadoCivil(nuevoFuncionario.getEstadoCivil());
        funcionario.setSexo(nuevoFuncionario.getSexo());
        funcionario.setDireccion(nuevoFuncionario.getDireccion());
        funcionario.setTelefono(nuevoFuncionario.getTelefono());
        funcionario.setFecha_nacimiento(nuevoFuncionario.getFecha_nacimiento());
        funcionario.setGrupofamiliarId(nuevoFuncionario.getGrupofamiliarId());
        em.merge(funcionario);
        }
        em.getTransaction().commit();
        em.close();
    }
        
    public void eliminarFuncionarioPorId(int id) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Funcionario funcionario = em.find(Funcionario.class, id);
        if (funcionario != null) {
        em.remove(funcionario);
        }
        em.getTransaction().commit();
        em.close();
    }
    
}
