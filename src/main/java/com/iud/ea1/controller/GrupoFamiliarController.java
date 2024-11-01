/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.iud.ea1.controller;

import com.iud.ea1.dao.GrupoFamiliarDAO;
import com.iud.ea1.domain.GrupoFamiliar;

/**
 *
 * @author alejo
 */
public class GrupoFamiliarController {
    private GrupoFamiliarDAO grupoFamiliarDAO;
    
    public GrupoFamiliarController(){
        this.grupoFamiliarDAO = new GrupoFamiliarDAO();
    }
    
    public GrupoFamiliar createGrupoFamiliar(GrupoFamiliar grupoFamiliar){
        return this.grupoFamiliarDAO.crearGrupoFamiliar(grupoFamiliar);
    }

    public void deleteGrupoFamiliar(int id) {
        this.grupoFamiliarDAO.eliminarGrupoFamiliarPorId(id);
    }
    
}
