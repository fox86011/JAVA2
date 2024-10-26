package com.krakedev.moduloii.evaluacionfinal.servicios;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.math.BigDecimal;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.krakedev.moduloii.evaluacionfinal.entidades.Item;
import com.krakedev.moduloii.evaluacionfinal.excepciones.InventarioException;
import com.krakedev.moduloii.evaluacionfinal.utils.ConexionBDD;

public class ServiciosInventario {
    private static final Logger LOGGER = LogManager.getLogger(ServiciosInventario.class);

    public void agregarItem(Item item) throws InventarioException {
        Connection con = null;
        PreparedStatement ps = null;
        try {
            con = ConexionBDD.obtenerConexion();
            
            if (buscarItemPorNombre(item.getNombre()) != null) {
                throw new InventarioException("El item \"" + item.getNombre() + "\" ya existe.");
            }

            ps = con.prepareStatement(
                "INSERT INTO items (nombre, cantidad, precio) VALUES (?, ?, ?)");
            
            ps.setString(1, item.getNombre());
            ps.setInt(2, item.getCantidad());
            ps.setBigDecimal(3, item.getPrecio());
            
            ps.executeUpdate();
            LOGGER.info("Item agregado correctamente: {}", item.getNombre());
            
        } catch (SQLException e) {
            LOGGER.error("Error al agregar item", e);
            throw new InventarioException("Error al agregar item", e);
        } finally {
            cerrarConexiones(ps, con);
        }
    }

    public void eliminarItem(String nombre) throws InventarioException {
        Connection con = null;
        PreparedStatement ps = null;
        try {
            con = ConexionBDD.obtenerConexion();
            ps = con.prepareStatement("DELETE FROM items WHERE nombre = ?");
            
            ps.setString(1, nombre);
            int filasAfectadas = ps.executeUpdate();
            
            if (filasAfectadas > 0) {
                LOGGER.info("Item eliminado correctamente: {}", nombre);
            } else {
                throw new InventarioException("El item \"" + nombre + "\" no se encontró en el inventario.");
            }
            
        } catch (SQLException e) {
            LOGGER.error("Error al eliminar item", e);
            throw new InventarioException("Error al eliminar item", e);
        } finally {
            cerrarConexiones(ps, con);
        }
    }

    public void actualizarItem(String nombre, int nuevaCantidad) throws InventarioException {
        Connection con = null;
        PreparedStatement ps = null;
        try {
            con = ConexionBDD.obtenerConexion();
            ps = con.prepareStatement("UPDATE items SET cantidad = ? WHERE nombre = ?");
            
            ps.setInt(1, nuevaCantidad);
            ps.setString(2, nombre);
            
            int filasAfectadas = ps.executeUpdate();
            if (filasAfectadas > 0) {
                LOGGER.info("Cantidad actualizada correctamente para el item: {}", nombre);
            } else {
                throw new InventarioException("El item \"" + nombre + "\" no se encontró en el inventario.");
            }
            
        } catch (SQLException e) {
            LOGGER.error("Error al actualizar cantidad", e);
            throw new InventarioException("Error al actualizar cantidad", e);
        } finally {
            cerrarConexiones(ps, con);
        }
    }

    public ArrayList<Item> mostrarInventario() throws InventarioException {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList<Item> items = new ArrayList<>();
        
        try {
            con = ConexionBDD.obtenerConexion();
            ps = con.prepareStatement("SELECT nombre, cantidad, precio FROM items");
            rs = ps.executeQuery();
            
            while (rs.next()) {
                Item item = new Item();
                item.setNombre(rs.getString("nombre"));
                item.setCantidad(rs.getInt("cantidad"));
                item.setPrecio(rs.getBigDecimal("precio"));
                items.add(item);
            }
            
            return items;
            
        } catch (SQLException e) {
            LOGGER.error("Error al recuperar inventario", e);
            throw new InventarioException("Error al recuperar inventario", e);
        } finally {
            cerrarConexiones(rs, ps, con);
        }
    }

    public BigDecimal calcularValorTotal() throws InventarioException {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        try {
            con = ConexionBDD.obtenerConexion();
            ps = con.prepareStatement(
                "SELECT SUM(cantidad * precio::numeric) as valor_total FROM items");
            rs = ps.executeQuery();
            
            if (rs.next()) {
                return rs.getBigDecimal("valor_total");
            }
            return BigDecimal.ZERO;
            
        } catch (SQLException e) {
            LOGGER.error("Error al calcular valor total", e);
            throw new InventarioException("Error al calcular valor total", e);
        } finally {
            cerrarConexiones(rs, ps, con);
        }
    }

    private Item buscarItemPorNombre(String nombre) throws SQLException {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        try {
            con = ConexionBDD.obtenerConexion();
            ps = con.prepareStatement("SELECT nombre, cantidad, precio FROM items WHERE nombre = ?");
            ps.setString(1, nombre);
            rs = ps.executeQuery();
            
            if (rs.next()) {
                Item item = new Item();
                item.setNombre(rs.getString("nombre"));
                item.setCantidad(rs.getInt("cantidad"));
                item.setPrecio(rs.getBigDecimal("precio"));
                return item;
            }
            return null;
            
        } finally {
            cerrarConexiones(rs, ps, con);
        }
    }

    private void cerrarConexiones(PreparedStatement ps, Connection con) {
        try {
            if (ps != null) ps.close();
            if (con != null) con.close();
        } catch (SQLException e) {
            LOGGER.error("Error al cerrar conexiones", e);
        }
    }

    private void cerrarConexiones(ResultSet rs, PreparedStatement ps, Connection con) {
        try {
            if (rs != null) rs.close();
            if (ps != null) ps.close();
            if (con != null) con.close();
        } catch (SQLException e) {
            LOGGER.error("Error al cerrar conexiones", e);
        }
    }
}
