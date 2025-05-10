package com.ecomarket.login.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecomarket.login.model.Usuario;
import com.ecomarket.login.repository.UsuarioRepository;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;
    public Usuario ValidarUsuario(String email, String password) {
        if (usuarioRepository.validarCredenciales(email, password)) {
            Usuario usuario = new Usuario();
            usuario.setEmail(email);
            usuario.setPassword(password);
            return usuario;
        }
        return null;
    }
}
