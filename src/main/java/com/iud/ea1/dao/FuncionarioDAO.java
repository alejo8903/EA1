package com.iud.ea1.dao;

import com.iud.ea1.domain.Funcionario;
import com.iud.ea1.domain.GrupoFamiliar;
import com.iud.ea1.util.JPAUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.PersistenceException;

import java.time.LocalDate;
import java.util.List;

public class FuncionarioDAO {
    
    private EntityManagerFactory emf = JPAUtil.getEntityManagerFactory();
    
    private static String getALL = "SELECT f FROM Funcionario f";
    
    public void crearFuncionario(Funcionario funcionario) throws PersistenceException{
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(funcionario);
        em.getTransaction().commit();
        em.close();
    }
    
    public List<Funcionario> obtenerFuncionarios()throws PersistenceException{
        EntityManager em = emf.createEntityManager();
        List<Funcionario> funcionarios = em.createQuery(getALL,Funcionario.class).getResultList();
        em.close();
        return funcionarios;
    }
    
    public Funcionario obtenerPorId(String id) throws PersistenceException{
        EntityManager em = emf.createEntityManager();
        Funcionario funcionario = em.find(Funcionario.class, id);
        em.close();
        return funcionario;
    }

    public void editarFuncionarioPorId(String id, Funcionario nuevoFuncionario) throws PersistenceException{
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
        funcionario.setFechaNacimiento(nuevoFuncionario.getFechaNacimiento());
        funcionario.setGrupofamiliarId(nuevoFuncionario.getGrupofamiliarId());
        em.merge(funcionario);
        }
        em.getTransaction().commit();
        em.close();
    }
    
    public void eliminarFuncionarioPorId(String id) throws PersistenceException{
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
