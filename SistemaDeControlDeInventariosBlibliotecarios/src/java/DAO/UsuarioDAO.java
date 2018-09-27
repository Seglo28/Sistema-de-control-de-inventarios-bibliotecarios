package DAO;

import Modelo.usuario;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author glori
 */
public class UsuarioDAO {

    Conexion conn;

    public UsuarioDAO(Conexion conn) {
        this.conn = conn;
    }

    public boolean Insertar(usuario usr) {
        String sql = "INSERT INTO usuario VALUES (?,?,?,?)";

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

    public boolean Actualizar(usuario usr) {
        String sql = "UPDATE usuario SET correo=?, contrasena=?, nombre=? WHERE id=?";

        try {
            PreparedStatement ps = conn.getConexion().prepareStatement(sql);
            ps.setString(1, usr.getCorreo());
            ps.setString(2, usr.getContrasena());
            ps.setString(3, usr.getNombre());
            ps.setInt(4, usr.getId());
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            System.out.println("Error en metodo ACTUALIZAR en la clase DAO USUARIOS. " + e.getMessage());
        }
        return false;
    }

    public boolean Borrar(int id) {
        String sql = "DELETE FROM usuario WHERE id=?";

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

    public List<usuario> MostrarUno(int id) {
        String sql = "SELECT * FROM usuario WHERE id=?";
        try {
            PreparedStatement ps = conn.getConexion().prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            List<usuario> lista = new LinkedList<>();
            usuario usr;

            if (rs.next()) {
                usr = new usuario(rs.getInt("id"));
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

    public List<usuario> MostrarTodos() {
        String sql = "SELECT * FROM usuario";
        try {
            PreparedStatement ps = conn.getConexion().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            List<usuario> lista = new LinkedList<>();
            usuario usr;

            while (rs.next()) {
                usr = new usuario(rs.getInt("id"));
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

    public List<usuario> Loging(String correo, String contrasena, String nombre) {
        String sql = "SELECT * FROM usuario WHERE correo=? AND contrasena=?";

        try {
            PreparedStatement ps = conn.getConexion().prepareStatement(sql);
            ps.setString(1, correo);
            ps.setString(2, contrasena);
            ResultSet rs = ps.executeQuery();

            List<usuario> lista = new LinkedList<>();
            usuario us;

            while (rs.next()) {
                us = new usuario(rs.getInt("id"));
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
