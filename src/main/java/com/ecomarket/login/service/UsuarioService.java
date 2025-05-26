package com.ecomarket.login.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecomarket.login.model.Usuario;
import com.ecomarket.login.repository.UsuarioRepository;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public Usuario validarUsuario(String email, String password) {
        return usuarioRepository.findByEmailAndPassword(email, password);
    }
    public Usuario findById(Long id) {
        return usuarioRepository.findById(id);
    }
}

