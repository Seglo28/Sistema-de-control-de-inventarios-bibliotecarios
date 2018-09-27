package DAO;

import Modelo.Autores;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author glori
 */
public class AutoresDAO {

    Conexion conn;

    public AutoresDAO(Conexion conn) {
        this.conn = conn;
    }

    public boolean Insertar(Autores a) {
        String sql = "INSERT INTO tabla_autores_detalles VALUES (?,?,?,?)";

        try {
            PreparedStatement ps = conn.getConexion().prepareStatement(sql);
            ps.setInt(1, a.getId_autor());
            ps.setString(2, a.getNombre());
            ps.setString(3, a.getFecha_de_nacimiento());
            ps.setString(4, a.getNacionalidad());
            ps.executeUpdate();
            return true;

        } catch (Exception e) {
            System.out.println("¡Ups!, hubo un error al insertar su información. " + e);
            return false;
        }
    }

    public boolean Actualizar(Autores a) {
        String sql = "UPDATE tabla_autores_detalles SET nombre=?, fecha_de_nacimiento=?, nacionalidad=? WHERE id_autor=?";

        try {
            PreparedStatement ps = conn.getConexion().prepareStatement(sql);
            ps.setString(1, a.getNombre());
            ps.setString(2, a.getFecha_de_nacimiento());
            ps.setString(3, a.getNacionalidad());
            ps.setInt(4, a.getId_autor());
            ps.executeUpdate();
            return true;

        } catch (Exception e) {
            System.out.println("¡Ups!, hubo un error al actualizar la información." + e);
            return false;
        }
    }

    public boolean Borrar(int id_autor) {
        String sql = "DELETE FROM tabla_autores_detalles WHERE id_autor=?";

        try {
            PreparedStatement ps = conn.getConexion().prepareStatement(sql);
            ps.setInt(1, id_autor);
            ps.executeUpdate();
            return true;

        } catch (Exception e) {
            System.out.println("¡Ups!, hubo un error al intentar borrar el ID seleccionado. " + e);
            return false;
        }
    }

    public List<Autores> MostrarUno(int id_autor) {
        String sql = "SELECT * FROM tabla_autores_detalles WHERE id_autor=?";

        try {
            PreparedStatement ps = conn.getConexion().prepareStatement(sql);
            ps.setInt(1, id_autor);
            ResultSet rs = ps.executeQuery();

            List<Autores> lista = new LinkedList<>();
            Autores au;

            if (rs.next()) {
                au = new Autores(rs.getInt("id_autor"));
                au.setNombre(rs.getString("nombre"));
                au.setFecha_de_nacimiento(rs.getString("fecha_de_nacimiento"));
                au.setNacionalidad(rs.getString("nacionalidad"));
                lista.add(au);
            }
            return lista;
        } catch (Exception e) {
            System.out.println("Perdone, hubo un error al procesar la información. " + e);
        }
        return null;
    }

    public List<Autores> MostrarTodos() {
        String sql = "SELECT * FROM tabla_autores_detalles";

        try {
            PreparedStatement ps = conn.getConexion().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            List<Autores> lista = new LinkedList<>();
            Autores au;

            while (rs.next()) {
                au = new Autores(rs.getInt("id_autor"));
                au.setNombre(rs.getString("nombre"));
                au.setFecha_de_nacimiento(rs.getString("fecha_de_nacimiento"));
                au.setNacionalidad(rs.getString("nacionalidad"));
                lista.add(au);
            }
            return lista;
        } catch (Exception e) {
            System.out.println("Perdone, hubo un error al procesar la información. " + e);
        }
        return null;
    }
}