package Modelo;

/**
 *
 * @author glori
 */
public class Administrador {
    
    private int id;
    private String correo;
    private String contrasena;
    private String nombre;
    

    public Administrador(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Administrador{" + "id=" + id + ", correo=" + correo + ", contrasena=" + contrasena + ", nombre=" + nombre + '}';
    }
}