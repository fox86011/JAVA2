package com.krakedev.persistencia.servicios;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import com.krakedev.persistencia.entidades.Persona;
import com.krakedev.persistencia.utils.ConexionBDD;

public class AdminPersonas {

    public static void insertar(Persona persona) {
        Connection con = null; // Inicializa la conexión a la base de datos
        LOGGER.trace("Persona a insertar----"+persona);
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
        String sql = "UPDATE personas SET nombre = ?, apellido = ?, direccion = ?, telefono = ? WHERE cedula = ?";
        try (Connection conn = ConexionBDD.conectar();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, persona.getNombre());
            pstmt.setString(2, persona.getApellido());

            pstmt.setString(5, persona.getCedula());  // Cedula como clave primaria

            int rowsUpdated = pstmt.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("Actualización exitosa.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
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
    public static ArrayList<Persona> buscarPorNombre(String nombreBuscado) throws Exception {
        
        ArrayList<Persona> personas = new ArrayList<Persona>();

        Connection con = null;
        PreparedStatement ps;
 

        try {

            con = ConexionBDD.conectar();

          
            ps = con.prepareStatement("SELECT * FROM personas WHERE nombre LIKE ?");
            
            ps.setString(1, "%" + nombreBuscado + "%");

        } catch (Exception e) {

            LOGGER.error("Error al consultar por nombre", e);

            throw new Exception("Error al consultar por nombre");
        } finally {

            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {

                LOGGER.error("Error con la base de datos", e);
               
                throw new Exception("Error con la base de datos");
            }
        }

        return personas;
    }
}