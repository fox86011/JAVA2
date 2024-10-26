package com.krakedev.persistencia.servicios;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.krakedev.persistencia.entidades.Persona;
import com.krakedev.persistencia.utils.ConexionBDD;

public class AdminPersonas {

    public static void insertar(Persona persona) {
        Connection con = null; // Inicializa la conexión a la base de datos

        try {
            // Abre la conexión a la base de datos
            con = ConexionBDD.conectar();
            String sql = "INSERT INTO personas (cedula, nombre, apellido) VALUES (?, ?, ?)";
            try (PreparedStatement pstmt = con.prepareStatement(sql)) {
                pstmt.setString(1, persona.getCedula());
                pstmt.setString(2, persona.getNombre());
                pstmt.setString(3, persona.getApellido());
                pstmt.executeUpdate();
            }
            System.out.println("Persona insertada correctamente.");
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        } finally {
            // Cierra la conexión a la base de datos, siempre, haya o no error
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
                System.out.println("Error de infraestructura");
            }
        }
    }

    public static void actualizar(Persona persona) {
        Connection con = null;

        try {
            con = ConexionBDD.conectar();
            String sql = "UPDATE personas SET nombre=?, apellido=? WHERE cedula=?";
            try (PreparedStatement pstmt = con.prepareStatement(sql)) {
                pstmt.setString(1, persona.getNombre());
                pstmt.setString(2, persona.getApellido());
                pstmt.setString(3, persona.getCedula());
                pstmt.executeUpdate();
            }
            System.out.println("Persona actualizada correctamente.");
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
                System.out.println("Error de infraestructura");
            }
        }
    }

    public static void eliminar(String cedula) {
        Connection con = null;

        try {
            con = ConexionBDD.conectar();
            String sql = "DELETE FROM personas WHERE cedula=?";
            try (PreparedStatement pstmt = con.prepareStatement(sql)) {
                pstmt.setString(1, cedula);
                pstmt.executeUpdate();
            }
            System.out.println("Persona eliminada correctamente.");
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
                System.out.println("Error de infraestructura");
            }
        }
    }
}