package com.ecomarket.login.repository;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.stereotype.Repository;

import java.sql.Connection;
@Repository
public class UsuarioRepository {

    public boolean validarCredenciales(String email, String password) {
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/tu_base_de_datos", "usuario", "contraseña");
             PreparedStatement statement = connection.prepareStatement("SELECT COUNT(*) FROM usuarios WHERE email = ? AND password = ?")) {

            statement.setString(1, email);
            statement.setString(2, password);

            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    return resultSet.getInt(1) > 0; // Retorna true si se encuentra un registro.
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false; // Retorna false si ocurre un error o no se encuentra el usuario.
    }
    } 