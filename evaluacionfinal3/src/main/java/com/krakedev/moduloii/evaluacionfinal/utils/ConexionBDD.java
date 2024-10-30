package com.krakedev.moduloii.evaluacionfinal.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;



public class ConexionBDD {
    private static final Logger LOGGER = LogManager.getLogger(ConexionBDD.class);
    private static final String URL = "jdbc:postgresql://localhost:5432/INVENTARIOS_KRAKEDEV";
    private static final String USER = "postgres";
    private static final String PASSWORD = "159753";

    public static Connection conectar() throws SQLException {
        try {
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            LOGGER.error("Error al conectar a la base de datos", e);
            throw e;
        }
    }
}