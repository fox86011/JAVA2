package com.krakedev.moduloii.evaluacionfinal.servicios;

import com.krakedev.moduloii.evaluacionfinal.entidades.Articulo;
import com.krakedev.moduloii.evaluacionfinal.excepciones.InventarioException;
import com.krakedev.moduloii.evaluacionfinal.utils.ConexionBDD;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import java.sql.*;
import java.util.ArrayList;

public class ServiciosArticulo {
    private static final Logger LOGGER = LogManager.getLogger(ServiciosArticulo.class);

    public void insertar(Articulo articulo) throws InventarioException {
        Connection con = null;
        PreparedStatement ps = null;
        try {
            con = ConexionBDD.conectar();
            ps = con.prepareStatement(
                "INSERT INTO artículos (id, nombre, precio_venta, precio_compra, id_grupo) VALUES (?, ?, ?, ?, ?)");
            ps.setString(1, articulo.getId());
            ps.setString(2, articulo.getNombre());
            ps.setBigDecimal(3, articulo.getPrecioVenta());
            ps.setBigDecimal(4, articulo.getPrecioCompra());
            ps.setString(5, articulo.getIdGrupo());
            ps.executeUpdate();
        } catch (SQLException e) {
            LOGGER.error("Error al insertar artículo", e);
            throw new InventarioException("Error al insertar artículo", e);
        } finally {
            try {
                if (ps != null) ps.close();
                if (con != null) con.close();
            } catch (SQLException e) {
                LOGGER.error("Error al cerrar conexiones", e);
            }
        }
    }

    public void actualizar(Articulo articulo) throws InventarioException {
        Connection con = null;
        PreparedStatement ps = null;
        try {
            con = ConexionBDD.conectar();
            ps = con.prepareStatement(
                "UPDATE artículos SET nombre=?, precio_venta=?, precio_compra=?, id_grupo=? WHERE id=?");
            ps.setString(1, articulo.getNombre());
            ps.setBigDecimal(2, articulo.getPrecioVenta());
            ps.setBigDecimal(3, articulo.getPrecioCompra());
            ps.setString(4, articulo.getIdGrupo());
            ps.setString(5, articulo.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            LOGGER.error("Error al actualizar artículo", e);
            throw new InventarioException("Error al actualizar artículo", e);
        } finally {
            try {
                if (ps != null) ps.close();
                if (con != null) con.close();
            } catch (SQLException e) {
                LOGGER.error("Error al cerrar conexiones", e);
            }
        }
    }

    public Articulo buscarArticuloPorId(String id) throws InventarioException {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            con = ConexionBDD.conectar();
            ps = con.prepareStatement("SELECT * FROM artículos WHERE id = ?");
            ps.setString(1, id);
            rs = ps.executeQuery();
            
            if (rs.next()) {
                Articulo articulo = new Articulo();
                articulo.setId(rs.getString("id"));
                articulo.setNombre(rs.getString("nombre"));
                articulo.setPrecioVenta(rs.getBigDecimal("precio_venta"));
                articulo.setPrecioCompra(rs.getBigDecimal("precio_compra"));
                articulo.setIdGrupo(rs.getString("id_grupo"));
                return articulo;
            }
            return null;
        } catch (SQLException e) {
            LOGGER.error("Error al buscar artículo", e);
            throw new InventarioException("Error al buscar artículo", e);
        } finally {
            try {
                if (rs != null) rs.close();
                if (ps != null) ps.close();
                if (con != null) con.close();
            } catch (SQLException e) {
                LOGGER.error("Error al cerrar conexiones", e);
            }
        }
    }

    public ArrayList<Articulo> recuperarTodos() throws InventarioException {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList<Articulo> articulos = new ArrayList<>();
        
        try {
            con = ConexionBDD.conectar();
            ps = con.prepareStatement("SELECT * FROM artículos");
            rs = ps.executeQuery();
            
            while (rs.next()) {
                Articulo articulo = new Articulo();
                articulo.setId(rs.getString("id"));
                articulo.setNombre(rs.getString("nombre"));
                articulo.setPrecioVenta(rs.getBigDecimal("precio_venta"));
                articulo.setPrecioCompra(rs.getBigDecimal("precio_compra"));
                articulo.setIdGrupo(rs.getString("id_grupo"));
                articulos.add(articulo);
            }
            return articulos;
        } catch (SQLException e) {
            LOGGER.error("Error al recuperar artículos", e);
            throw new InventarioException("Error al recuperar artículos", e);
        } finally {
            try {
                if (rs != null) rs.close();
                if (ps != null) ps.close();
                if (con != null) con.close();
            } catch (SQLException e) {
                LOGGER.error("Error al cerrar conexiones", e);
            }
        }
    }
}