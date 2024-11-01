/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.iud.ea1;

import com.iud.ea1.dao.FuncionarioDAO;
import com.iud.ea1.presentation.Principal;
import io.github.cdimascio.dotenv.Dotenv;

/**
 *
 * @author alejo
 */
public class EA1 {
    
    private  FuncionarioDAO funcionarioDao;

    public static void main(String[] args) {
        Dotenv dotenv = Dotenv.load();
        Principal principal = new Principal();
        principal.setVisible(Boolean.TRUE);
        principal.setLocationRelativeTo(null);
        
        
    }
    
    
}
