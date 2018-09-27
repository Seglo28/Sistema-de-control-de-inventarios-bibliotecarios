package DAO;

import Modelo.Proveedores;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author glori
 */
public class ProveedoresDAO {

    Conexion conn;

    public ProveedoresDAO(Conexion conn) {
        this.conn = conn;
    }

    public boolean Insertar(Proveedores pro) {
        String sql = "INSERT INTO tabla_proveedor VALUES (?,?,?,?,?)";

        try {
            PreparedStatement ps = conn.getConexion().prepareStatement(sql);
            ps.setInt(1, pro.getId_proveedor());
            ps.setString(2, pro.getNombre());
            ps.setString(3, pro.getRubro());
            ps.setString(4, pro.getPersoneria_juridica());
            ps.setInt(5, pro.getTelefono());
            ps.executeUpdate();
            return true;

        } catch (Exception e) {
            System.out.println("¡Ups!, hubo un error al insertar su información. " + e);
            return false;
        }
    }

    public boolean Actualizar(Proveedores pro) {
        String sql = "UPDATE tabla_proveedor SET nombre=?, rubro=?, personeria_juridica=?, telefono=? WHERE id_proveedor=?";

        try {
            PreparedStatement ps = conn.getConexion().prepareStatement(sql);

            ps.setString(1, pro.getNombre());
            ps.setString(2, pro.getRubro());
            ps.setString(3, pro.getPersoneria_juridica());
            ps.setInt(4, pro.getTelefono());
            ps.setInt(5, pro.getId_proveedor());
            ps.executeUpdate();
            return true;

        } catch (Exception e) {
            System.out.println("¡Ups!, hubo un error al actualizar la información." + e);
            return false;
        }
    }

    public boolean Borrar(int id_proveedor) {
        String sql = "DELETE FROM tabla_proveedor WHERE id_proveedor=?";

        try {
            PreparedStatement ps = conn.getConexion().prepareStatement(sql);
            ps.setInt(1, id_proveedor);
            ps.executeUpdate();
            return true;

        } catch (Exception e) {
            System.out.println("¡Ups!, hubo un error al intentar borrar el ID seleccionado. " + e);
            return false;
        }
    }

    public List<Proveedores> MostrarUno(int id_proveedor) {
        String sql = "SELECT * FROM tabla_proveedor WHERE id_proveedor=?";

        try {
            PreparedStatement ps = conn.getConexion().prepareStatement(sql);
            ps.setInt(1, id_proveedor);
            ResultSet rs = ps.executeQuery();

            List<Proveedores> lista = new LinkedList<>();
            Proveedores pro;

            if (rs.next()) {
                pro = new Proveedores(rs.getInt("id_proveedor"));
                pro.setNombre(rs.getString("nombre"));
                pro.setRubro(rs.getString("rubro"));
                pro.setPersoneria_juridica(rs.getString("personeria_juridica"));
                pro.setTelefono(rs.getInt("telefono")); 
                lista.add(pro);
            }
            return lista;
        } catch (Exception e) {
            System.out.println("Perdone, hubo un error al procesar la información. " + e);
        }
        return null;
    }

    public List<Proveedores> MostrarTodos() {
        String sql = "SELECT * FROM tabla_proveedor";

        try {
            PreparedStatement ps = conn.getConexion().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            List<Proveedores> lista = new LinkedList<>();
            Proveedores pro;

            while (rs.next()) {
                pro = new Proveedores(rs.getInt("id_proveedor"));
                pro.setNombre(rs.getString("nombre"));
                pro.setRubro(rs.getString("rubro"));
                pro.setPersoneria_juridica(rs.getString("personeria_juridica"));
                pro.setTelefono(rs.getInt("telefono")); 
                System.out.println("ID DEL PROVEEDOR EN DAO: "+pro.getId_proveedor());
                lista.add(pro);
            }
            return lista;
        } catch (Exception e) {
            System.out.println("Perdone, hubo un error al procesar la información. " + e);
            return null;
        }
        
    }
}
