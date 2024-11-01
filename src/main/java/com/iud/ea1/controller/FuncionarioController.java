package com.iud.ea1.controller;

import com.iud.ea1.dao.FuncionarioDAO;
import com.iud.ea1.domain.Funcionario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/funcionarios")

public class FuncionarioController {

    @Autowired
    private FuncionarioDAO funcionarioDAO;

    @PostMapping
    public void crearFuncionario(@RequestBody Funcionario funcionario) {
    funcionarioDAO.crearFuncionario(funcionario);
    }

    @GetMapping
    public List<Funcionario> obtenerFuncionarios() {
    return funcionarioDAO.obtenerFuncionarios();
    }

    @GetMapping("/{id}")
    public Funcionario obtenerFuncionarioPorId(@PathVariable int id) {
    return funcionarioDAO.obtenerPorId(id);
    }

    @PutMapping("/{id}")
    public void editarFuncionarioPorId(@PathVariable int id, @RequestBody Funcionario nuevoFuncionario) {
    funcionarioDAO.editarFuncionarioPorId(id, nuevoFuncionario);
    }

    @DeleteMapping("/{id}")
    public void eliminarFuncionarioPorId(@PathVariable int id) {
    funcionarioDAO.eliminarFuncionarioPorId(id);
    }
}