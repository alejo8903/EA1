/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.iud.ea1.dao;

import com.iud.ea1.domain.Funcionario;
import com.iud.ea1.util.JPAUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;

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

    public Funcionario editarFuncionarioPorId(int id, Funcionario funcionarioActualizado) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        
        Funcionario funcionarioEditado = null;
        
        try {
            tx.begin();
            
            // Buscar el funcionario existente por ID
            Funcionario funcionarioExistente = em.find(Funcionario.class, id);
            
            if (funcionarioExistente != null) {
                // Actualizar los campos del funcionario existente
                funcionarioExistente.setNombre(funcionarioActualizado.getNombre());
                funcionarioExistente.setApellido(funcionarioActualizado.getApellido());
                funcionarioExistente.setEstadoCivil(funcionarioActualizado.getEstadoCivil());
                funcionarioExistente.setSexo(funcionarioActualizado.getSexo());
                funcionarioExistente.setDireccion(funcionarioActualizado.getDireccion());
                funcionarioExistente.setTelefono(funcionarioActualizado.getTelefono());
                funcionarioExistente.setFecha_nacimiento(funcionarioActualizado.getFecha_nacimiento());
                funcionarioExistente.setGrupofamiliarId(funcionarioActualizado.getGrupofamiliarId());
                
                // Guardar los cambios
                funcionarioEditado = em.merge(funcionarioExistente);
            }
            
            tx.commit();
        } finally {
            if (em.isOpen()) {
                em.close();
            }
        }
        
        return funcionarioEditado;
    }
    public boolean eliminarFuncionarioPorId(int id) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        
        boolean eliminado = false;
        
        try {
            tx.begin();
            
            // Buscar el funcionario existente por ID
            Funcionario funcionario = em.find(Funcionario.class, id);
            
            if (funcionario != null) {
                // Eliminar el funcionario
                em.remove(funcionario);
                eliminado = true;
            }
            
            tx.commit();
        } finally {
            if (em.isOpen()) {
                em.close();
            }
        }
        
        return eliminado;
    }
}

