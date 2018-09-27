package DAO;

import Modelo.Administrador;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author glori
 */
public class AdministradorDAO {

    Conexion conn;

    public AdministradorDAO(Conexion conn) {
        this.conn = conn;
    }

    public boolean Insertar(Administrador usr) {
        String sql = "INSERT INTO administrador VALUES (?,?,?,?)";

        try {
            PreparedStatement ps = conn.getConexion().prepareStatement(sql);
            ps.setInt(1, usr.getId());
            ps.setString(2, usr.getCorreo());
            ps.setString(3, usr.getContrasena());
            ps.setString(4, usr.getNombre());
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            System.out.println("Error en metodo INSERTAR en la clase DAO. " + e.getMessage());
        }
        return false;
    }

    public boolean Actualizar(Administrador usr) {
        String sql = "UPDATE administrador SET correo=?, contrasena=?, nombre=? WHERE id=?";

        try {
            PreparedStatement ps = conn.getConexion().prepareStatement(sql);
            ps.setString(1, usr.getCorreo());
            ps.setString(2, usr.getContrasena());
            ps.setString(3, usr.getNombre());
            ps.setInt(4, usr.getId());
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            System.out.println("Error en metodo ACTUALIZAR en la clase DAO ADMINISTRADORES. " + e.getMessage());
        }
        return false;
    }

    public boolean Borrar(int id) {
        String sql = "DELETE FROM administrador WHERE id=?";

        try {
            PreparedStatement ps = conn.getConexion().prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println("Error en metodo BORRAR en la clase DAO. " + e.getMessage());
        }
        return false;
    }

    public List<Administrador> MostrarUno(int id) {
        String sql = "SELECT * FROM administrador WHERE id=?";
        try {
            PreparedStatement ps = conn.getConexion().prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            List<Administrador> lista = new LinkedList<>();
            Administrador usr;

            if (rs.next()) {
                usr = new Administrador(rs.getInt("id"));
                usr.setCorreo(rs.getString("correo"));
                usr.setContrasena(rs.getString("contrasena"));
                usr.setNombre(rs.getString("nombre"));
                lista.add(usr);
            }
            return lista;
        } catch (SQLException e) {
            System.out.println("Error en metodo MOSTRAR UNO en la clase DAO. " + e.getMessage());
        }
        return null;
    }

    public List<Administrador> MostrarTodos() {
        String sql = "SELECT * FROM administrador";
        try {
            PreparedStatement ps = conn.getConexion().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            List<Administrador> lista = new LinkedList<>();
            Administrador usr;

            while (rs.next()) {
                usr = new Administrador(rs.getInt("id"));
                usr.setCorreo(rs.getString("correo"));
                usr.setContrasena(rs.getString("contrasena"));
                usr.setNombre(rs.getString("nombre"));
                lista.add(usr);
            }
            return lista;
        } catch (SQLException e) {
            System.out.println("Error en metodo MOSTRAR TODOS en la clase DAO. " + e.getMessage());
        }
        return null;
    }

    public List<Administrador> Loging(String correo, String contrasena, String nombre) {
        String sql = "SELECT * FROM administrador WHERE correo=? AND contrasena=?";

        try {
            PreparedStatement ps = conn.getConexion().prepareStatement(sql);
            ps.setString(1, correo);
            ps.setString(2, contrasena);
            ResultSet rs = ps.executeQuery();

            List<Administrador> lista = new LinkedList<>();
            Administrador us;

            while (rs.next()) {
                us = new Administrador(rs.getInt("id"));
                us.setCorreo("correo");
                us.setContrasena("contrasena");
                lista.add(us);
            }
            return lista;
        } catch (Exception e) {
            System.out.println("Error en el metodo MOSTRAR UNO en la DAO. " + e.getMessage());
        }
        return null;
    }
}
