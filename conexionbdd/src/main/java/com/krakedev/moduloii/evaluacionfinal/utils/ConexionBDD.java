package com.krakedev.moduloii.evaluacionfinal.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ConexionBDD {
    private static final Logger LOGGER = LogManager.getLogger(ConexionBDD.class);
    
    private static final String URL = "jdbc:postgresql://localhost:5432/INVENTARIOS_KRAKEDEV";
    private static final String USUARIO = "postgres";
    private static final String CLAVE = "tu_contraseña"; // Cambia esto por tu contraseña

    public static Connection obtenerConexion() throws SQLException {
        try {
            return DriverManager.getConnection(URL, USUARIO, CLAVE);
        } catch (SQLException e) {
            LOGGER.error("Error al obtener conexión", e);
            throw e;
        }
    }
}
