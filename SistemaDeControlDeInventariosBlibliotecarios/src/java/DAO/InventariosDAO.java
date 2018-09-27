package DAO;

import Modelo.Inventarios;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author glori
 */
public class InventariosDAO {

    Conexion conn;

    public InventariosDAO(Conexion conn) {
        this.conn = conn;
    }

    public boolean Insertar(Inventarios in) {
        String sql = "INSERT INTO tabla_inventario VALUES (?,?,?,?,?,?)";

        try {
            PreparedStatement ps = conn.getConexion().prepareStatement(sql);
            ps.setInt(1, in.getId_inventario());
            ps.setInt(2, in.getId_proveedor());
            ps.setInt(3, in.getId_libro());
            ps.setString(4, in.getEstado_libro());
            ps.setInt(5, in.getExistencia_libro());
            ps.setInt(6, in.getStock_minimo_libro());
            ps.executeUpdate();
            return true;

        } catch (Exception e) {
            System.out.println("¡Ups!, hubo un error al insertar su información. " + e);
            return false;
        }
    }

    public boolean Actualizar(Inventarios in) {
        String sql = "UPDATE tabla_inventario SET id_proveedor=?,id_libro=?, estado_libro=?, existencia_libro=?, stock_minimo_libro=? WHERE id_inventario=?";

        try {
            PreparedStatement ps = conn.getConexion().prepareStatement(sql);
            ps.setInt(1, in.getId_proveedor());
            ps.setInt(2, in.getId_libro());
            ps.setString(3, in.getEstado_libro());
            ps.setInt(4, in.getExistencia_libro());
            ps.setInt(5, in.getStock_minimo_libro());
            ps.setInt(6, in.getId_inventario());
            ps.executeUpdate();
            return true;

        } catch (Exception e) {
            System.out.println("¡Ups!, hubo un error al actualizar la información." + e);
            return false;
        }
    }

    public boolean Borrar(int id_inventario) {
        String sql = "DELETE FROM tabla_inventario WHERE id_inventario=?";

        try {
            PreparedStatement ps = conn.getConexion().prepareStatement(sql);
            ps.setInt(1, id_inventario);
            ps.executeUpdate();
            return true;

        } catch (Exception e) {
            System.out.println("¡Ups!, hubo un error al intentar borrar el ID seleccionado. " + e);
            return false;
        }
    }

    public List<Inventarios> MostrarUno(int id_inventario) {
        String sql = "SELECT * FROM tabla_inventario WHERE id_inventario=?";

        try {
            PreparedStatement ps = conn.getConexion().prepareStatement(sql);
            ps.setInt(1, id_inventario);
            ResultSet rs = ps.executeQuery();

            List<Inventarios> lista = new LinkedList<>();
            Inventarios in;

            if (rs.next()) {
                in = new Inventarios(rs.getInt("id_inventario"));
                in.setId_proveedor(rs.getInt("id_proveedor"));
                in.setId_libro(rs.getInt("id_libro"));
                in.setEstado_libro(rs.getString("estado_libro"));
                in.setExistencia_libro(rs.getInt("existencia_libro"));
                in.setStock_minimo_libro(rs.getInt("stock_minimo_libro"));
                lista.add(in);
            }
            return lista;
        } catch (Exception e) {
            System.out.println("Perdone, hubo un error al procesar la información en el metodo MOSTRAR UNO. " + e);
            return null;
        }
        
    }

    public List<Inventarios> MostrarTodos() {
        String sql = "SELECT * FROM tabla_inventario";

        try {
            PreparedStatement ps = conn.getConexion().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            List<Inventarios> lista = new LinkedList<>();
            Inventarios in;

            while (rs.next()) {
                in = new Inventarios(rs.getInt("id_inventario"));                
                in.setId_libro(rs.getInt("id_libro"));
                in.setId_proveedor(rs.getInt("id_proveedor"));
                in.setEstado_libro(rs.getString("estado_libro"));
                in.setExistencia_libro(rs.getInt("existencia_libro"));
                in.setStock_minimo_libro(rs.getInt("stock_minimo_libro"));
                lista.add(in);
            }
            return lista;
        } catch (Exception e) {
            System.out.println("Perdone, hubo un error al procesar la información en el metodo MOSTRAR TODOS. " + e);
        }
        return null;
    }
}
