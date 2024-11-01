package com.iud.ea1.controller;

import com.iud.ea1.dao.FuncionarioDAO;
import com.iud.ea1.domain.Funcionario;
import jakarta.persistence.PersistenceException;

import java.util.List;





public class FuncionarioController {


    private FuncionarioDAO funcionarioDAO;
    
    public FuncionarioController(){
        funcionarioDAO = new FuncionarioDAO();
    }


    public void crearFuncionario(Funcionario funcionario) throws PersistenceException{
    funcionarioDAO.crearFuncionario(funcionario);
    }


    public List<Funcionario> obtenerFuncionarios() throws PersistenceException{
    return funcionarioDAO.obtenerFuncionarios();
    }


    public Funcionario obtenerFuncionarioPorId(int id) throws PersistenceException{
    return funcionarioDAO.obtenerPorId(id);
    }


    public void editarFuncionarioPorId(int id,Funcionario nuevoFuncionario) throws PersistenceException{
    funcionarioDAO.editarFuncionarioPorId(id, nuevoFuncionario);
    }


    public void eliminarFuncionarioPorId(int id) throws PersistenceException{
    funcionarioDAO.eliminarFuncionarioPorId(id);
    }

    public List<Funcionario> getFuncionarios() {
        return funcionarioDAO.obtenerFuncionarios();
    }
}