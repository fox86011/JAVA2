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
    public static ArrayList<Persona> buscarPorNombre(String nombreBuscado) throws Exception {
        // Crea una lista vacía para almacenar los resultados
        ArrayList<Persona> personas = new ArrayList<Persona>();

        // Inicializa la conexión y el prepared statement
        Connection con = null;
        PreparedStatement ps;

        try {
            // Obtiene una conexión a la base de datos
            con = ConexionBDD.conectar();

            // Prepara la sentencia SQL para buscar personas por nombre
            ps = con.prepareStatement("SELECT * FROM personas WHERE nombre LIKE ?");
            // Establece el valor del parámetro de búsqueda (con comodines para una búsqueda parcial)
            ps.setString(1, "%" + nombreBuscado + "%");

            // Ejecuta la consulta y obtiene los resultados
            // ... (falta el código para obtener los resultados y agregarlos a la lista)

        } catch (Exception e) {
            // Registra un error en el log
            LOGGER.error("Error al consultar por nombre", e);
            // Lanza una nueva excepción para propagar el error
            throw new Exception("Error al consultar por nombre");
        } finally {
            // Cierra la conexión a la base de datos
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                // Registra un error en el log
                LOGGER.error("Error con la base de datos", e);
                // Lanza una nueva excepción para propagar el error
                throw new Exception("Error con la base de datos");
            }
        }

        // Devuelve la lista de personas encontradas
        return personas;
    }
}