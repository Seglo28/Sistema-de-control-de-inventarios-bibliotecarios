
package Modelo;

/**
 *
 * @author glori
 */
public class Libros {

    private int id_libro;
    private String nombre;
    private String fecha_de_publicacion;
    private int tomo;
    private String edicion;
    private int paginas;
    private String genero;

    public Libros(int id_libro) {
        this.id_libro = id_libro;
    }

    public int getId_libro() {
        return id_libro;
    }

    public void setId_libro(int id_libro) {
        this.id_libro = id_libro;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFecha_de_publicacion() {
        return fecha_de_publicacion;
    }

    public void setFecha_de_publicacion(String fecha_de_publicacion) {
        this.fecha_de_publicacion = fecha_de_publicacion;
    }

    public int getTomo() {
        return tomo;
    }

    public void setTomo(int tomo) {
        this.tomo = tomo;
    }

    public String getEdicion() {
        return edicion;
    }

    public void setEdicion(String edicion) {
        this.edicion = edicion;
    }

    public int getPaginas() {
        return paginas;
    }

    public void setPaginas(int paginas) {
        this.paginas = paginas;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    @Override
    public String toString() {
        return "Libros{" + "id_libro=" + id_libro + ", nombre=" + nombre + ", fecha_de_publicacion=" + fecha_de_publicacion + ", tomo=" + tomo + ", edicion=" + edicion + ", paginas=" + paginas + ", genero=" + genero + '}';
    }


}
