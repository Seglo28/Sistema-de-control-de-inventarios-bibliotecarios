package Controlador;

import DAO.Conexion;
import DAO.AdministradorDAO;
import Modelo.Administrador;
import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AdministradorController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getParameter("action");
        String id = request.getParameter("id");
        String correo = request.getParameter("correo");
        String contrasena = request.getParameter("contrasena");
        String nombre = request.getParameter("nombre");
        try {
            switch (action) {
                case "Insertar":
                    this.Insertar(request, response, correo, contrasena, nombre);
                    break;
                case "Actualizar":
                    this.Actualizar(request, response, correo, contrasena, nombre);
                    break;
                case "Borrar":
                    this.Borrar(request, response, id);
                    break;
                case "MostrarUno":
                    this.MostrarUno(request, response, id);
                    break;
                case "MostrarTodos":
                    this.MostrarTodos(request, response);
                    break;
                case "Loging":
                    this.Loging(request, response, correo, contrasena);
                    break;
            }
        } catch (Exception e) {
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

    protected void Insertar(HttpServletRequest request, HttpServletResponse response, String correo, String contrasena, String nombre)
            throws ServletException, IOException {

        String msg = "";

        try {
            Administrador usr = new Administrador(0);
            usr.setCorreo(correo);
            usr.setContrasena(contrasena);
            usr.setNombre(nombre);

            Conexion conn = new Conexion();
            AdministradorDAO dao = new AdministradorDAO(conn);

            boolean r;
            if (correo.equals("") && contrasena.equals("") && nombre.equals("")) {
                r = false;
            } else {
                r = dao.Insertar(usr);
            }

            boolean situacion = r;
            List<Administrador> lista = dao.MostrarTodos();
            if (situacion) {
                msg = "Ingreso de información exitoso. ";
            } else {
                msg = "Error en el ingreso de información a la base de datos. ";
            }
            RequestDispatcher rd;
            request.setAttribute("msg", msg);
            request.setAttribute("lista", lista);
            rd = request.getRequestDispatcher("AdministracionMostrarAdministracion.jsp");
            rd.forward(request, response);
            //conn.desconectar();
        } catch (Exception e) {
            System.out.println("Error en el metodo INSERTAR en el CONTROLADOR" + e.getMessage());
        }
    }

    protected void Actualizar(HttpServletRequest request, HttpServletResponse response, String correo, String contrasena, String nombre) {

        int id = Integer.parseInt(request.getParameter("id"));
        String msg = "";
        try {

            Administrador user = new Administrador(id);
            user.setCorreo(correo);
            user.setContrasena(contrasena);
            user.setNombre(nombre);

            Conexion conn = new Conexion();
            AdministradorDAO dao = new AdministradorDAO(conn);

            boolean situacion = dao.Actualizar(user);
            List<Administrador> lista = dao.MostrarTodos();

            if (situacion) {
                msg = "La actualización ha sido exitosa.";
            } else {
                msg = "La actualización ha sido fallida.";
            }
            RequestDispatcher rd;
            request.setAttribute("msg", msg);
            request.setAttribute("lista", lista);
            rd = request.getRequestDispatcher("AdministracionMostrarAdministracion.jsp");
            rd.forward(request, response);
            conn.desconectar();
        } catch (NumberFormatException e) {
            System.out.println("Error de numeros: " + e.getMessage());
        } catch (ClassNotFoundException | ServletException e) {
            System.out.println("¡Ups!, se presentarón incomvenientes. " + e);
        } catch (IOException e) {
            System.out.println("Error de Entrada/Salida: " + e.getMessage());
        }
    }

    protected void Borrar(HttpServletRequest request, HttpServletResponse response, String id)
            throws ServletException, IOException {
        String msg = "";
        try {
            Conexion conn = new Conexion();
            AdministradorDAO dao = new AdministradorDAO(conn);

            boolean situacion = dao.Borrar(Integer.parseInt(id));
            if (situacion) {
                msg = "El elemento seleccionado ha sido eliminado.";
            } else {
                msg = "Error en el proceso, el elemento seleccionado no ha sido eliminado.";
            }
            List<Administrador> lista = dao.MostrarTodos();

            RequestDispatcher rd;
            request.setAttribute("msg", msg);
            request.setAttribute("lista", lista);
            rd = request.getRequestDispatcher("AdministracionMostrarAdministracion.jsp");
            rd.forward(request, response);
        } catch (Exception e) {
            System.out.println("Error en el metodo BORRAR en el CONTROLADOR" + e.getMessage());
        }
    }

    protected void MostrarUno(HttpServletRequest request, HttpServletResponse response, String id)
            throws ServletException, IOException {
        try {
            Conexion conn = new Conexion();
            AdministradorDAO dao = new AdministradorDAO(conn);

            List<Administrador> lista = dao.MostrarUno(Integer.parseInt(id));

            RequestDispatcher rd;
            request.setAttribute("lista", lista);
            rd = request.getRequestDispatcher("ActualizarAdministracion.jsp");
            rd.forward(request, response);
            conn.desconectar();
        } catch (Exception e) {
            System.out.println("Error en el metodo MOSTRAR UNO en el CONTROLADOR" + e.getMessage());
        }
    }

    protected void MostrarTodos(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            Conexion conn = new Conexion();
            AdministradorDAO dao = new AdministradorDAO(conn);

            List<Administrador> lista = dao.MostrarTodos();
            System.out.println(lista);

            RequestDispatcher rd;
            request.setAttribute("lista", lista);
            rd = request.getRequestDispatcher("AdministracionMostrarAdministracion.jsp");
            rd.forward(request, response);
        } catch (Exception e) {
            System.out.println("Error en el metodo MOSTRAR TODOS en el CONTROLADOR" + e.getMessage());
        }
    }

    protected void Loging(HttpServletRequest request, HttpServletResponse response, String correo, String contrasena) {

        String msg = "";
        String pagina = "";

        try {
            Conexion conn = new Conexion();
            AdministradorDAO dao = new AdministradorDAO(conn);
            List<Administrador> lista = dao.Loging(correo, contrasena, correo);
            /*--------------------------------------------------------------------------------------------------------*/

            if (lista.size() > 0) { //SIZE Returns the number of elements in this list.
                msg = "<center>Bienvenido al sistema de control bibliotecario.</center>";
                pagina = "/PrincipalAdministracion.jsp";
            } else {
                msg = "<center>El sistema no reconoce alguno<br>- o todos - de los datos<br>ingresados.</center>";
                pagina = "/IngresoAdministrador.jsp";
            }
            /*--------------------------------------------------------------------------------------------------------*/
            RequestDispatcher rd;
            request.setAttribute("msg", msg);
            rd = request.getRequestDispatcher(pagina);
            rd.forward(request, response);
            conn.desconectar();
        } catch (NumberFormatException e) {
            System.out.println("Error de numeros: " + e.getMessage());
        } catch (ClassNotFoundException | ServletException e) {
            System.out.println("¡Ups!, se presentarón incomvenientes. " + e);
        } catch (IOException e) {
            System.out.println("Error de Entrada/Salida: " + e.getMessage());
        }
    }
}
