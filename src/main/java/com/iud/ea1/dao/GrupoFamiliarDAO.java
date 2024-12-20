package com.iud.ea1.dao;

    
import com.iud.ea1.domain.GrupoFamiliar;
import com.iud.ea1.util.JPAUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.PersistenceException;

import java.util.List;

public class GrupoFamiliarDAO {

    
    private EntityManagerFactory emf = JPAUtil.getEntityManagerFactory();
    
    private static String getALL = "SELECT g FROM GrupoFamiliar g";
    
    public GrupoFamiliar crearGrupoFamiliar(GrupoFamiliar grupoFamiliar) throws PersistenceException{
    EntityManager em = emf.createEntityManager();
    em.getTransaction().begin();
    em.persist(grupoFamiliar);
    em.getTransaction().commit();
    em.close();
    return grupoFamiliar;
    }
    
    public List<GrupoFamiliar> obtenerGruposFamiliares() throws PersistenceException{
    EntityManager em = emf.createEntityManager();
    List<GrupoFamiliar> gruposFamiliares = em.createQuery(getALL, GrupoFamiliar.class).getResultList();
    em.close();
    return gruposFamiliares;
    }
    
    public GrupoFamiliar obtenerPorId(int id) throws PersistenceException{
    EntityManager em = emf.createEntityManager();
    GrupoFamiliar grupoFamiliar = em.find(GrupoFamiliar.class, id);
    em.close();
    return grupoFamiliar;
    }
    
    public void editarGrupoFamiliarPorId(int id, GrupoFamiliar nuevoGrupoFamiliar) throws PersistenceException{
    EntityManager em = emf.createEntityManager();
    em.getTransaction().begin();
    GrupoFamiliar grupoFamiliar = em.find(GrupoFamiliar.class, id);
    if (grupoFamiliar != null) {
    grupoFamiliar.setRol(nuevoGrupoFamiliar.getRol());
    em.merge(grupoFamiliar);
    }
    em.getTransaction().commit();
    em.close();
    }
    
    public void eliminarGrupoFamiliarPorId(int id) throws PersistenceException{
    EntityManager em = emf.createEntityManager();
    em.getTransaction().begin();
    GrupoFamiliar grupoFamiliar = em.find(GrupoFamiliar.class, id);
    if (grupoFamiliar != null) {
    em.remove(grupoFamiliar);
    }
    em.getTransaction().commit();
    em.close();
    }

}


