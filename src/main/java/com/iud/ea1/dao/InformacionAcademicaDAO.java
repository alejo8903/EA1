package com.iud.ea1.dao;

import com.iud.ea1.domain.InformacionAcademica;
import com.iud.ea1.util.JPAUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;

import java.util.List;

/**
*
* @author alejo
*/
public class InformacionAcademicaDAO {

    private EntityManagerFactory emf = JPAUtil.getEntityManagerFactory();

    private static String getALL = "SELECT i FROM InformacionAcademica i";

    public void crearInformacionAcademica(InformacionAcademica informacionAcademica) {
    EntityManager em = emf.createEntityManager();
    em.getTransaction().begin();
    em.persist(informacionAcademica);
    em.getTransaction().commit();
    em.close();
    }

    public List<InformacionAcademica> obtenerInformacionesAcademicas() {
    EntityManager em = emf.createEntityManager();
    List<InformacionAcademica> informacionesAcademicas = em.createQuery(getALL, InformacionAcademica.class).getResultList();
    em.close();
    return informacionesAcademicas;
    }

    public InformacionAcademica obtenerPorId(int id) {
    EntityManager em = emf.createEntityManager();
    InformacionAcademica informacionAcademica = em.find(InformacionAcademica.class, id);
    em.close();
    return informacionAcademica;
    }

    public void editarInformacionAcademicaPorId(int id, InformacionAcademica nuevaInformacionAcademica) {
    EntityManager em = emf.createEntityManager();
    em.getTransaction().begin();
    InformacionAcademica informacionAcademica = em.find(InformacionAcademica.class, id);
    if (informacionAcademica != null) {
    informacionAcademica.setUniversidad(nuevaInformacionAcademica.getUniversidad());
    informacionAcademica.setNivelEstudio(nuevaInformacionAcademica.getNivelEstudio());
    informacionAcademica.setTitulo(nuevaInformacionAcademica.getTitulo());
    informacionAcademica.setFuncionarioId(nuevaInformacionAcademica.getFuncionarioId());
    em.merge(informacionAcademica);
    }
    em.getTransaction().commit();
    em.close();
    }

    public void eliminarInformacionAcademicaPorId(int id) {
    EntityManager em = emf.createEntityManager();
    em.getTransaction().begin();
    InformacionAcademica informacionAcademica = em.find(InformacionAcademica.class, id);
    if (informacionAcademica != null) {
    em.remove(informacionAcademica);
    }
    em.getTransaction().commit();
    em.close();
    }
}