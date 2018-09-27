package Modelo;

/**
 *
 * @author glori
 */
public class Proveedores {

    private int id_proveedor;
    private String nombre;
    private String rubro;
    private String personeria_juridica;
    private int telefono;

    public Proveedores(int id_proveedor) {
        this.id_proveedor = id_proveedor;
    }

    public int getId_proveedor() {
        return id_proveedor;
    }

    public void setId_proveedor(int id_proveedor) {
        this.id_proveedor = id_proveedor;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRubro() {
        return rubro;
    }

    public void setRubro(String rubro) {
        this.rubro = rubro;
    }

    public String getPersoneria_juridica() {
        return personeria_juridica;
    }

    public void setPersoneria_juridica(String personeria_juridica) {
        this.personeria_juridica = personeria_juridica;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    @Override
    public String toString() {
        return "Proveedores{" + "id_proveedor=" + id_proveedor + ", nombre=" + nombre + ", rubro=" + rubro + ", personeria_juridica=" + personeria_juridica + ", telefono=" + telefono + '}';
    }
    
    
}
