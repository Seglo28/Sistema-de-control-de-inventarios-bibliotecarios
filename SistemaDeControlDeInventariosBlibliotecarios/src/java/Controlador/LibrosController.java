package Controlador;

import DAO.Conexion;
import DAO.LibrosDAO;
import Modelo.Libros;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author glori
 */
public class LibrosController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getParameter("action");
        String id_libro = request.getParameter("id_libro");
        try {
            switch (action) {
                case "insertar":
                    this.Insertar(request, response);
                    break;
                case "Actualizar":
                    this.Actualizar(request, response, id_libro);
                    break;
                case "Borrar":
                    this.Borrar(request, response, id_libro);
                    break;
                case "MostrarUno":
                    this.MostrarUno(request, response, id_libro);
                    break;
                case "MostrarTodos":
                    this.MostrarTodos(request, response);
                    break;
                case "MostrarTodos2":
                    this.MostrarTodos2(request, response);
                    break;
            }
        } catch (Exception ex) {

        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

    protected void Insertar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String nombre = request.getParameter("nombre");
        String fecha_de_publicacion = request.getParameter("fecha_de_publicacion");
        int tomo = Integer.parseInt(request.getParameter("tomo"));
        String edicion = request.getParameter("edicion");
        int paginas = Integer.parseInt(request.getParameter("paginas"));
        String genero = request.getParameter("genero");

        try {
            Libros lb = new Libros(0);
            lb.setNombre(nombre);
            lb.setFecha_de_publicacion(fecha_de_publicacion);
            lb.setTomo(tomo);
            lb.setEdicion(edicion);
            lb.setPaginas(paginas);
            lb.setGenero(genero);
            System.out.println(lb);

            Conexion conn = new Conexion();
            LibrosDAO dao = new LibrosDAO(conn);

            boolean situacion = dao.Insertar(lb);
            List<Libros> lista = dao.MostrarTodos();
            String msg = "";

            if (situacion) {
                msg = "Los datos han sido ingresados de forma exitosa.";
            } else {
                msg = "Ha ocurrido un error en el ingreso de datos.";
            }

            RequestDispatcher rd;
            request.setAttribute("msg", msg);
            request.setAttribute("lista", lista);
            rd = request.getRequestDispatcher("/AdministracionMostrarLibros.jsp");
            rd.forward(request, response);

        } catch (Exception e) {
            System.out.println("¡Ups!, se presentarón incomvenientes. " + e);
        }
    }

    protected void Actualizar(HttpServletRequest request, HttpServletResponse response, String id_libro) {

        int id_autor = Integer.parseInt(request.getParameter("id_libro"));
        String nombre = request.getParameter("nombre");
        String fecha_de_publicacion = request.getParameter("fecha_de_publicacion");
        int tomo = Integer.parseInt(request.getParameter("tomo"));
        String edicion = request.getParameter("edicion");
        int paginas = Integer.parseInt(request.getParameter("paginas"));
        String genero = request.getParameter("genero");

        try {
            Libros lb = new Libros(id_autor);
            lb.setId_libro(id_autor);
            lb.setNombre(nombre);
            lb.setFecha_de_publicacion(fecha_de_publicacion);
            lb.setTomo(tomo);
            lb.setEdicion(edicion);
            lb.setPaginas(paginas);
            lb.setGenero(genero);
            System.out.println(lb);

            Conexion conn = new Conexion();
            LibrosDAO dao = new LibrosDAO(conn);

            boolean situacion = dao.Actualizar(lb);
            List<Libros> lista = dao.MostrarTodos();
            String msg = "";

            if (situacion) {
                msg = "Actualización exitosa.";
            } else {
                msg = "Ha ocurrido un error en la actualización de datos.";
            }

            RequestDispatcher rd;
            request.setAttribute("msg2", msg);
            request.setAttribute("lista", lista);
            rd = request.getRequestDispatcher("/AdministracionMostrarLibros.jsp");
            rd.forward(request, response);

        } catch (NumberFormatException e) {
            System.out.println("Error de numeros: " + e.getMessage());
        } catch (ClassNotFoundException | ServletException e) {
            System.out.println("¡Ups!, se presentarón incomvenientes. " + e);
        } catch (IOException e) {
            System.out.println("Error de Entrada/Salida: " + e.getMessage());
        }
    }

    protected void Borrar(HttpServletRequest request, HttpServletResponse response, String id_libro)
            throws ServletException, IOException {

        try {
            Conexion conn = new Conexion();
            LibrosDAO dao = new LibrosDAO(conn);

            boolean situacion = dao.Borrar(Integer.parseInt(id_libro));

            String msg = "";

            if (situacion) {
                msg = "El elemento seleccionado a sido borrado.";
            } else {
                msg = "Ha ocurrido un error.";
            }
            List<Libros> lista = dao.MostrarTodos();

            RequestDispatcher rd;
            request.setAttribute("msg", msg); //("msg2", msg);
            request.setAttribute("lista", lista);
            rd = request.getRequestDispatcher("AdministracionMostrarLibros.jsp");
            rd.forward(request, response);

        } catch (Exception e) {
            System.out.println("¡Ups!, se presentarón incomvenientes. " + e);
        }
    }

    protected void MostrarUno(HttpServletRequest request, HttpServletResponse response, String id_libro)
            throws ServletException, IOException, ClassNotFoundException {

        try {
            Conexion conn = new Conexion();
            LibrosDAO dao = new LibrosDAO(conn);

            List<Libros> lista = dao.MostrarUno(Integer.parseInt(id_libro));
            RequestDispatcher rd;

            request.setAttribute("lista", lista);
            rd = request.getRequestDispatcher("ActualizarLibro.jsp");
            rd.forward(request, response);

        } catch (Exception e) {
        }
    }

    protected void MostrarTodos(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            Conexion conn = new Conexion();
            LibrosDAO dao = new LibrosDAO(conn);

            List<Libros> lista = dao.MostrarTodos();
            RequestDispatcher rd;

            request.setAttribute("lista", lista);
            rd = request.getRequestDispatcher("/AdministracionMostrarLibros.jsp");
            rd.forward(request, response);

        } catch (Exception e) {
        }
    }

    protected void MostrarTodos2(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            Conexion conn = new Conexion();
            LibrosDAO dao = new LibrosDAO(conn);

            List<Libros> lista = dao.MostrarTodos();
            RequestDispatcher rd;

            request.setAttribute("lista", lista);
            rd = request.getRequestDispatcher("/UsuariosMostrarLibros.jsp");
            rd.forward(request, response);

        } catch (Exception e) {
        }
    }
}
