package Controlador;

import DAO.AutoresDAO;
import DAO.Conexion;
import Modelo.Autores;
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
public class AutoresController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getParameter("action");
        String id_autor = request.getParameter("id_autor");

        try{
        switch (action) {
            case "insertar":
                this.Insertar(request, response);
                break;
            case "Actualizar":
                this.Actualizar(request, response, id_autor);
                break;
            case "Borrar":
                this.Borrar(request, response, id_autor);
                break;
            case "MostrarUno":
                this.MostrarUno(request, response, id_autor);
                break;
            case "MostrarTodos":
                this.MostrarTodos(request, response);
                break;
            case "MostrarTodos2":
                this.MostrarTodos2(request, response);
        }
        }catch (Exception ex) {
            
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
        String fecha_de_nacimiento = request.getParameter("fecha_de_nacimiento");
        String nacionalidad = request.getParameter("nacionalidad");

        try {
            Autores au = new Autores(0);
            au.setNombre(nombre);
            au.setFecha_de_nacimiento(fecha_de_nacimiento);
            au.setNacionalidad(nacionalidad);
            System.out.println(au);

            Conexion conn = new Conexion();
            AutoresDAO dao = new AutoresDAO(conn);

            boolean situacion = dao.Insertar(au);
            List<Autores> lista = dao.MostrarTodos();                         
            String msg = "";

            if (situacion) {
                msg = "Los datos han sido ingresados de forma exitosa.";
            } else {
                msg = "Ha ocurrido un error en el ingreso de su información a la base de datos.";
            }

            RequestDispatcher rd;
            request.setAttribute("msg", msg);
            request.setAttribute("lista", lista);
            rd = request.getRequestDispatcher("/AdministracionMostrarAutores.jsp");
            rd.forward(request, response);
            conn.desconectar();
        } catch (Exception e) {
            System.out.println("¡Ups!, se presentarón inconvenientes. " + e);
        }
    }

    protected void Actualizar(HttpServletRequest request, HttpServletResponse response, String id_autor){
        
        int id_autor2 = Integer.parseInt(request.getParameter("id_autor"));
            String nombre = request.getParameter("nombre");
            String fecha_de_nacimiento = request.getParameter("fecha_de_nacimiento");
            String nacionalidad = request.getParameter("nacionalidad");

        try {
            Autores au = new Autores(id_autor2);     
            au.setNombre(nombre);
            au.setFecha_de_nacimiento(fecha_de_nacimiento);
            au.setNacionalidad(nacionalidad);
            System.out.println(au);

            Conexion conn = new Conexion();
            AutoresDAO dao = new AutoresDAO(conn);

            boolean situacion = dao.Actualizar(au);
            List<Autores> lista = dao.MostrarTodos();
            String msg = "";

            if (situacion) {
                msg = "Actualización exitosa.";
            } else {
                msg = "Ha ocurrido un error en la actualización de datos.";
            }

            RequestDispatcher rd;
            request.setAttribute("msg2", msg);
            request.setAttribute("lista", lista);
            rd = request.getRequestDispatcher("/AdministracionMostrarAutores.jsp");
            rd.forward(request, response);
            conn.desconectar();
        } catch(NumberFormatException e){
            System.out.println("Error de numeros: " + e.getMessage());
        } catch (ClassNotFoundException | ServletException e) {
            System.out.println("¡Ups!, se presentarón incomvenientes. " + e);
        } catch(IOException e){
            System.out.println("Error de Entrada/Salida: " + e.getMessage());
        }
    }

    protected void Borrar(HttpServletRequest request, HttpServletResponse response, String id_autor)
            throws ServletException, IOException {

        try {
            Conexion conn = new Conexion();
            AutoresDAO dao = new AutoresDAO(conn);

            boolean situacion = dao.Borrar(Integer.parseInt(id_autor));
            List<Autores> lista = dao.MostrarTodos();
            String msg = "";

            if (situacion) {
                msg = "El elemento seleccionado a sido borrado.";
            } else {
                msg = "Ha ocurrido un error.";
            }

            RequestDispatcher rd;
            request.setAttribute("msg2", msg);
            request.setAttribute("lista", lista);
            rd = request.getRequestDispatcher("/AdministracionMostrarAutores.jsp");
            rd.forward(request, response);
            conn.desconectar();
        } catch (Exception e) {
            System.out.println("¡Ups!, se presentarón incomvenientes. " + e);
        }
    }

    protected void MostrarUno(HttpServletRequest request, HttpServletResponse response, String id_autor)
            throws ServletException, IOException, ClassNotFoundException {

        try {
            Conexion conn = new Conexion();
            AutoresDAO dao = new AutoresDAO(conn);

            List<Autores> lista = dao.MostrarUno(Integer.parseInt(id_autor));
            RequestDispatcher rd;

            request.setAttribute("lista", lista);
            rd = request.getRequestDispatcher("/ActualizarAutor.jsp");
            rd.forward(request, response);
            conn.desconectar();
        } catch (Exception e) {
        }
    }

    protected void MostrarTodos(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            Conexion conn = new Conexion();
            AutoresDAO dao = new AutoresDAO(conn);

            List<Autores> lista = dao.MostrarTodos();
            RequestDispatcher rd;

            request.setAttribute("lista", lista);
            rd = request.getRequestDispatcher("/AdministracionMostrarAutores.jsp");
            rd.forward(request, response);
            conn.desconectar();
        } catch (Exception e) {
        }
    }
    
        protected void MostrarTodos2(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            Conexion conn = new Conexion();
            AutoresDAO dao = new AutoresDAO(conn);

            List<Autores> lista = dao.MostrarTodos();
            RequestDispatcher rd;

            request.setAttribute("lista", lista);
            rd = request.getRequestDispatcher("/UsuariosMostrarAutores.jsp");
            rd.forward(request, response);
            conn.desconectar();
        } catch (Exception e) {
        }
    }
}