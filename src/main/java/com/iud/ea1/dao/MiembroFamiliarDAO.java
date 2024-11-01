package com.iud.ea1.dao;

import com.iud.ea1.domain.MiembroFamiliar;
import com.iud.ea1.util.JPAUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;

import java.util.List;


public class MiembroFamiliarDAO {

    private EntityManagerFactory emf = JPAUtil.getEntityManagerFactory();

    private static String getALL = "SELECT m FROM MiembroFamiliar m";

    public void crearMiembroFamiliar(MiembroFamiliar miembroFamiliar) {
    EntityManager em = emf.createEntityManager();
    em.getTransaction().begin();
    em.persist(miembroFamiliar);
    em.getTransaction().commit();
    em.close();
    }

    public List<MiembroFamiliar> obtenerMiembrosFamiliares() {
    EntityManager em = emf.createEntityManager();
    List<MiembroFamiliar> miembrosFamiliares = em.createQuery(getALL, MiembroFamiliar.class).getResultList();
    em.close();
    return miembrosFamiliares;
    }

    public MiembroFamiliar obtenerPorId(int id) {
    EntityManager em = emf.createEntityManager();
    MiembroFamiliar miembroFamiliar = em.find(MiembroFamiliar.class, id);
    em.close();
    return miembroFamiliar;
    }

    public void editarMiembroFamiliarPorId(int id, MiembroFamiliar nuevoMiembroFamiliar) {
    EntityManager em = emf.createEntityManager();
    em.getTransaction().begin();
    MiembroFamiliar miembroFamiliar = em.find(MiembroFamiliar.class, id);
    if (miembroFamiliar != null) {
    miembroFamiliar.setNombre(nuevoMiembroFamiliar.getNombre());
    miembroFamiliar.setParentesco(nuevoMiembroFamiliar.getParentesco());
    miembroFamiliar.setEdad(nuevoMiembroFamiliar.getEdad());
    miembroFamiliar.setGrupoFamiliarId(nuevoMiembroFamiliar.getGrupoFamiliarId());
    em.merge(miembroFamiliar);
    }
    em.getTransaction().commit();
    em.close();
    }

    public void eliminarMiembroFamiliarPorId(int id) {
    EntityManager em = emf.createEntityManager();
    em.getTransaction().begin();
    MiembroFamiliar miembroFamiliar = em.find(MiembroFamiliar.class, id);
    if (miembroFamiliar != null) {
    em.remove(miembroFamiliar);
    }
    em.getTransaction().commit();
    em.close();
    }
}