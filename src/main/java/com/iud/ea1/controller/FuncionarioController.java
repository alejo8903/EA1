package com.iud.ea1.controller;

import com.iud.ea1.dao.FuncionarioDAO;
import com.iud.ea1.domain.Funcionario;

import java.util.List;





public class FuncionarioController {


    private FuncionarioDAO funcionarioDAO;
    
    public FuncionarioController(){
        funcionarioDAO = new FuncionarioDAO();
    }


    public void crearFuncionario(Funcionario funcionario) {
    funcionarioDAO.crearFuncionario(funcionario);
    }


    public List<Funcionario> obtenerFuncionarios() {
    return funcionarioDAO.obtenerFuncionarios();
    }


    public Funcionario obtenerFuncionarioPorId(int id) {
    return funcionarioDAO.obtenerPorId(id);
    }


    public void editarFuncionarioPorId(int id,Funcionario nuevoFuncionario) {
    funcionarioDAO.editarFuncionarioPorId(id, nuevoFuncionario);
    }


    public void eliminarFuncionarioPorId(int id) {
    funcionarioDAO.eliminarFuncionarioPorId(id);
    }
}