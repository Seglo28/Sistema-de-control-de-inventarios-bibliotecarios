package Modelo;

/**
 *
 * @author glori
 */
public class AutoresDiagrama {
    
    private int id_autor_libro;
    private int id_autor;
    private int id_libro;

    public AutoresDiagrama(int id_autor_libro) {
        this.id_autor_libro = id_autor_libro;
    }

    public int getId_autor_libro() {
        return id_autor_libro;
    }

    public void setId_autor_libro(int id_autor_libro) {
        this.id_autor_libro = id_autor_libro;
    }

    public int getId_autor() {
        return id_autor;
    }

    public void setId_autor(int id_autor) {
        this.id_autor = id_autor;
    }

    public int getId_libro() {
        return id_libro;
    }

    public void setId_libro(int id_libro) {
        this.id_libro = id_libro;
    }

    @Override
    public String toString() {
        return "AutoresDiagrama{" + "id_autor_libro=" + id_autor_libro + ", id_autor=" + id_autor + ", id_libro=" + id_libro + '}';
    }
}
