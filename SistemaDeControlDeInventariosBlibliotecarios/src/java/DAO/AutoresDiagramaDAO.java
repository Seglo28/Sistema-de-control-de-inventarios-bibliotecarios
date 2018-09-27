package DAO;

import Modelo.AutoresDiagrama;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author glori
 */
public class AutoresDiagramaDAO {

    Conexion conn;

    public AutoresDiagramaDAO(Conexion conn) {
        this.conn = conn;
    }

    public boolean Insertar(AutoresDiagrama ad) {
        String sql = "INSERT INTO tabla_autores_llave VALUES (?,?,?)";

        try {
            PreparedStatement ps = conn.getConexion().prepareStatement(sql);
            ps.setInt(1, ad.getId_autor_libro());
            ps.setInt(2, ad.getId_autor());
            ps.setInt(3, ad.getId_libro());
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            System.out.println("Error en el metodo INSERTAR. " + e.getMessage());
        }
        return false;
    }

    public List<AutoresDiagrama> MostrarUno(int id_autor_libro) {
        String sql = "SELECT * FROM tabla_autores_llave WHERE id_autor_libro = ?";
        try {
            PreparedStatement ps = conn.getConexion().prepareStatement(sql);
            ps.setInt(1, id_autor_libro);
            ResultSet rs = ps.executeQuery();

            List<AutoresDiagrama> lista = new LinkedList<>();
            AutoresDiagrama ad;

            if (rs.next()) {
                ad = new AutoresDiagrama(rs.getInt("id_autor_libro"));
                ad.setId_autor(rs.getInt("id_autor"));
                ad.setId_libro(rs.getInt("id_libro"));
                lista.add(ad);
            }
            return lista;
        } catch (Exception e) {
            System.out.println("Error en el metodo Mostrar Uno. " + e.getMessage());
        }
        return null;
    }
 
    public List<AutoresDiagrama> MostrarTodos() {
        String sql = "SELECT * FROM tabla_autores_llave";
        try {
            PreparedStatement ps = conn.getConexion().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            List<AutoresDiagrama> lista = new LinkedList<>();
            AutoresDiagrama ad;

            while (rs.next()) {
                ad = new AutoresDiagrama(rs.getInt("id_autor_libro"));
                ad.setId_autor(rs.getInt("id_autor"));
                ad.setId_libro(rs.getInt("id_libro"));
                lista.add(ad);
            }
            return lista;
        } catch (Exception e) {
            System.out.println("Error en el metodo Mostrar Todos. " + e.getMessage());
        }
        return null;
    }    
}
