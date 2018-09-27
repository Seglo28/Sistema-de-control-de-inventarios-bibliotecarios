package Modelo;

/**
 *
 * @author glori
 */
public class Inventarios {

    private int id_inventario;
    private int id_proveedor;
    private int id_libro;
    private String estado_libro;
    private int existencia_libro;
    private int stock_minimo_libro;

    public Inventarios(int id_inventario) {
        this.id_inventario = id_inventario;
    }

    public int getId_inventario() {
        return id_inventario;
    }

    public void setId_inventario(int id_inventario) {
        this.id_inventario = id_inventario;
    }

    public int getId_proveedor() {
        return id_proveedor;
    }

    public void setId_proveedor(int id_proveedor) {
        this.id_proveedor = id_proveedor;
    }

    public int getId_libro() {
        return id_libro;
    }

    public void setId_libro(int id_libro) {
        this.id_libro = id_libro;
    }

    public String getEstado_libro() {
        return estado_libro;
    }

    public void setEstado_libro(String estado_libro) {
        this.estado_libro = estado_libro;
    }

    public int getExistencia_libro() {
        return existencia_libro;
    }

    public void setExistencia_libro(int existencia_libro) {
        this.existencia_libro = existencia_libro;
    }

    public int getStock_minimo_libro() {
        return stock_minimo_libro;
    }

    public void setStock_minimo_libro(int stock_minimo_libro) {
        this.stock_minimo_libro = stock_minimo_libro;
    }

    @Override
    public String toString() {
        return "Inventarios{" + "id_inventario=" + id_inventario + ", id_proveedor=" + id_proveedor + ", id_libro=" + id_libro + ", estado_libro=" + estado_libro + ", existencia_libro=" + existencia_libro + ", stock_minimo_libro=" + stock_minimo_libro + '}';
    }

}