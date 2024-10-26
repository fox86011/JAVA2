package com.krakedev.conexionbdd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.math.BigDecimal;

public class TestConexion {

    public static void main(String[] args) {
        Connection connection = null;
        PreparedStatement ps = null;

        // Definir las consultas SQL
        String insertEstudiantes = "INSERT INTO estudiantes (cedula, nombre, apellido, email, fecha_nacimiento) VALUES (?, ?, ?, ?, ?)";
        String insertCuentas = "INSERT INTO cuentas (numero_cuenta, cedula_propietario, fecha_creacion, saldo) VALUES (?, ?, ?, ?)";
        String verificarEstudiante = "SELECT COUNT(*) FROM estudiantes WHERE cedula = ?";

        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "159753");
            System.out.println("Conexión exitosa.");

            // Verificar si el estudiante ya existe
            try (PreparedStatement psVerificar = connection.prepareStatement(verificarEstudiante)) {
                psVerificar.setString(1, "1234567890");
                ResultSet rs = psVerificar.executeQuery();
                rs.next();
                
                if (rs.getInt(1) == 0) {
                    // Si no existe, insertarlo
                    try (PreparedStatement pstmtEstudiantes = connection.prepareStatement(insertEstudiantes)) {
                        pstmtEstudiantes.setString(1, "1234567890");
                        pstmtEstudiantes.setString(2, "Juan");
                        pstmtEstudiantes.setString(3, "Pérez");
                        pstmtEstudiantes.setString(4, "juan.perez@example.com");
                        pstmtEstudiantes.setDate(5, java.sql.Date.valueOf("2000-01-01"));
                        pstmtEstudiantes.executeUpdate();
                    }
                } else {
                    System.out.println("El estudiante con cédula 1234567890 ya existe. No se insertará nuevamente.");
                }
            }

         // Modificar la asignación del saldo
            try (PreparedStatement pstmtCuentas = connection.prepareStatement(insertCuentas)) {
                pstmtCuentas.setString(1, "007");
                pstmtCuentas.setString(2, "1234569890"); // La cédula debe existir en la tabla estudiantes
                pstmtCuentas.setDate(3, java.sql.Date.valueOf("2023-01-01"));
                pstmtCuentas.setBigDecimal(4, new BigDecimal("1000.00")); // Usar BigDecimal para precisión monetaria
                pstmtCuentas.executeUpdate();
            }
            System.out.println("Datos insertados correctamente.");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (ps != null) ps.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
