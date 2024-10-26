/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.iud.ea1;

import com.iud.ea1.dao.FuncionarioDAO;
import io.github.cdimascio.dotenv.Dotenv;

/**
 *
 * @author alejo
 */
public class EA1 {
    
    private  FuncionarioDAO funcionarioDao;

    public static void main(String[] args) {
        Dotenv dotenv = Dotenv.load();
        System.out.println(dotenv.get("URL_DB"));
        
        
    }
    
    
}
