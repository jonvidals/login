package com.ecomarket.login.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecomarket.login.model.Usuario;
import com.ecomarket.login.service.UsuarioService;

@RequestMapping("/api/usuario")
@RestController
public class UsuarioController {
    @Autowired
    private UsuarioService usuarioService;
    @GetMapping("/validar")
    public String validarUsuario(@RequestBody Usuario usuario) {
        if (usuarioService.ValidarUsuario(usuario.getEmail(), usuario.getPassword()) != null) {
            return "Usuario valido";
        } else {
            return "Usuario no valido";
        }
    }
}
