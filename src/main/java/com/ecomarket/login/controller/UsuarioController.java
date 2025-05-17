package com.ecomarket.login.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ecomarket.login.model.Usuario;
import com.ecomarket.login.service.UsuarioService;

@RequestMapping("/api/usuario")
@RestController
public class UsuarioController {
    @Autowired
    private UsuarioService usuarioService;

    @PostMapping("/validar")
    public ResponseEntity<Usuario> validarUsuario(@RequestBody Usuario usuario) {
        String email = usuario.getEmail();
        String password = usuario.getPassword();
        if (email==null||email.isEmpty()||password==null||password.isEmpty()) {
            System.out.println("no pueden haber campos vacíos");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
        Usuario usuarioValidado = usuarioService.validarUsuario(email, password);
        if (usuarioValidado != null) {
            return ResponseEntity.ok(usuarioValidado);
        } else {
            System.out.println("Usuario no encontrado");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
        }
    }
}
