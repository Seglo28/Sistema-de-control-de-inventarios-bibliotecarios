package Modelo;

/**
 *
 * @author glori
 */
public class Autores {
    
    private int id_autor;
    private String nombre;
    private String fecha_de_nacimiento;
    private String nacionalidad;

    public Autores(int id_autor) {
        this.id_autor = id_autor;
    }

    public int getId_autor() {
        return id_autor;
    }

    public void setId_autor(int id_autor) {
        this.id_autor = id_autor;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFecha_de_nacimiento() {
        return fecha_de_nacimiento;
    }

    public void setFecha_de_nacimiento(String fecha_de_nacimiento) {
        this.fecha_de_nacimiento = fecha_de_nacimiento;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    @Override
    public String toString() {
        return "Autores{" + "id_autor=" + id_autor + ", nombre=" + nombre + ", fecha_de_nacimiento=" + fecha_de_nacimiento + ", nacionalidad=" + nacionalidad + '}';
    }
    
    
}
