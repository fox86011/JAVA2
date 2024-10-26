package com.krakedev.persistencia.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.krakedev.persistencia.entidades.Persona;

public class ConexionBDD {
    private final static String DRIVER = "org.postgresql.Driver";
    private final static String URL = "jdbc:postgresql://localhost:5432/postgres";
    private final static String USUARIO = "postgres";
    private final static String CLAVE = "159753";

    public static Connection conectar() {
        Connection connection = null;
        try {
            Class.forName(DRIVER);
            connection = DriverManager.getConnection(URL, USUARIO, CLAVE);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
    
    public static Persona buscarPorId(int id) {
        Persona persona = null;
        String query = "SELECT * FROM personas WHERE id = ?";
        try (Connection connection = conectar();
             PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                persona = new Persona(rs.getInt("id"), rs.getString("nombre"), ...); // Crear un objeto Persona con los datos del ResultSet
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return persona;
    }

    // Método para obtener varios registros
    public static List<Persona> obtenerTodos() {
        List<Persona> personas = new ArrayList<>();
        String query = "SELECT * FROM personas";
        try (Connection connection = conectar();
             PreparedStatement pstmt = connection.prepareStatement(query);
             ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) {
                Persona persona = new Persona(rs.getInt("id"), rs.getString("nombre"), ...);
                personas.add(persona);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return personas;
    }
}
