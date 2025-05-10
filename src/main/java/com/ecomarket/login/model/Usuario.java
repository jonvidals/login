package com.ecomarket.login.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.*;


@Data
@NoArgsConstructor
public class Usuario {

    private String email;
    private String password;


}

