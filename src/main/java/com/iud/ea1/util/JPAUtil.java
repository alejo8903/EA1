/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.iud.ea1.util;

import io.github.cdimascio.dotenv.Dotenv;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import java.util.HashMap;
import java.util.Map;
import org.hibernate.jpa.HibernatePersistenceProvider;

/**
 *
 * @author alejo
 */
public class JPAUtil {

    private static EntityManagerFactory emf;

    static {
        Dotenv dotenv = Dotenv.load();

        Map<String, String> propiedades = new HashMap<>();
        propiedades.put("jakarta.persistence.jdbc.url", dotenv.get("URL_DB"));
        propiedades.put("jakarta.persistence.jdbc.user", dotenv.get("USER"));
        propiedades.put("jakarta.persistence.jdbc.password", dotenv.get("PASS"));
        propiedades.put("jakarta.persistence.jdbc.driver", dotenv.get("DRIVER"));

        propiedades.put("hibernate.dialect", dotenv.get("DIALECT"));
        propiedades.put("hibernate.hbm2ddl.auto", dotenv.get("update"));
        propiedades.put("hibernate.show_sql", "true");

        
        try {
            emf = new HibernatePersistenceProvider().createEntityManagerFactory("miUnidadDePersistencia", propiedades);
        } catch (Exception e) {
            e.printStackTrace();
            throw new ExceptionInInitializerError("Error al inicializar EntityManagerFactory: " + e.getMessage());
        }
    }

    public static EntityManagerFactory getEntityManagerFactory() {
        return emf;
    }

    public static void close() {
        if (emf != null) {
            emf.close();
        }
    }
}
