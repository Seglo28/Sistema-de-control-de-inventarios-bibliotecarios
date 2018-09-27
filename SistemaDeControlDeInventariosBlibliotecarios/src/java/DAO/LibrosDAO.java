package DAO;

import Modelo.Libros;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author glori
 */
public class LibrosDAO {

    Conexion conn;

    public LibrosDAO(Conexion conn) {
        this.conn = conn;
    }

    public boolean Insertar(Libros lb) {
        String sql = "INSERT INTO tabla_libros VALUES (?,?,?,?,?,?,?)";

        try {
            PreparedStatement ps = conn.getConexion().prepareStatement(sql);

            ps.setInt(1, lb.getId_libro());
            ps.setString(2, lb.getNombre());
            ps.setString(3, lb.getFecha_de_publicacion());
            ps.setInt(4, lb.getTomo());
            ps.setString(5, lb.getEdicion());
            ps.setInt(6, lb.getPaginas());
            ps.setString(7, lb.getGenero());
            ps.executeUpdate();
            return true;

        } catch (Exception e) {
            System.out.println("¡Ups!, hubo un error al insertar su información. " + e);
            return false;
        }
    }

    public boolean Actualizar(Libros lb) {
        String sql = "UPDATE tabla_libros SET nombre=?, fecha_de_publicacion=?, tomo=?, edicion=?, paginas=?, genero=? WHERE id_libro=?";

        try {
            PreparedStatement ps = conn.getConexion().prepareStatement(sql);
            ps.setString(1, lb.getNombre());
            ps.setString(2, lb.getFecha_de_publicacion());
            ps.setInt(3, lb.getTomo());
            ps.setString(4, lb.getEdicion());
            ps.setInt(5, lb.getPaginas());
            ps.setString(6, lb.getGenero());
            ps.setInt(7, lb.getId_libro());
            
            ps.executeUpdate();
            return true;

        } catch (Exception e) {
            System.out.println("¡Ups!, hubo un error al actualizar la información." + e);
            return false;
        }
    }

    public boolean Borrar(int id_libro) {
        String sql = "DELETE FROM tabla_libros WHERE id_libro=?";

        try {
            PreparedStatement ps = conn.getConexion().prepareStatement(sql);
            ps.setInt(1, id_libro);
            ps.executeUpdate();
            return true;

        } catch (Exception e) {
            System.out.println("¡Ups!, hubo un error al intentar borrar el ID seleccionado. " + e);
            return false;
        }
    }

    public List<Libros> MostrarUno(int id_libro) {
        String sql = "SELECT * FROM tabla_libros WHERE id_libro=?";

        try {
            PreparedStatement ps = conn.getConexion().prepareStatement(sql);
            ps.setInt(1, id_libro);
            ResultSet rs = ps.executeQuery();

            List<Libros> lista = new LinkedList<>();
            Libros lb;

            if (rs.next()) {
                lb = new Libros(rs.getInt("id_libro"));
                lb.setNombre(rs.getString("nombre"));
                lb.setFecha_de_publicacion(rs.getString("fecha_de_publicacion"));
                lb.setTomo(rs.getInt("tomo"));
                lb.setEdicion(rs.getString("edicion"));
                lb.setPaginas(rs.getInt("paginas"));
                lb.setGenero(rs.getString("genero"));
                lista.add(lb);
            }
            return lista;
        } catch (Exception e) {
            System.out.println("Perdone, hubo un error al procesar la información. " + e);
        }
        return null;
    }

    public List<Libros> MostrarTodos() {
        String sql = "SELECT * FROM tabla_libros";

        try {
            PreparedStatement ps = conn.getConexion().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            List<Libros> lista = new LinkedList<>();
            Libros lb;

            while (rs.next()) {
                lb = new Libros(rs.getInt("id_libro"));
                lb.setNombre(rs.getString("nombre"));
                lb.setFecha_de_publicacion(rs.getString("fecha_de_publicacion"));
                lb.setTomo(rs.getInt("tomo"));
                lb.setEdicion(rs.getString("edicion"));
                lb.setPaginas(rs.getInt("paginas"));
                lb.setGenero(rs.getString("genero"));
                lista.add(lb);
            }
            return lista;
        } catch (Exception e) {
            System.out.println("Perdone, hubo un error al procesar la información. " + e);
        }
        return null;
    }

    public ResultSet kkk() {
        String letra = "SELECT id_autor, nombre FROM tabla_autores_detalles";
        //ResultSet rs = conn.getConexion(letra);
        return null;
    }

   
}
