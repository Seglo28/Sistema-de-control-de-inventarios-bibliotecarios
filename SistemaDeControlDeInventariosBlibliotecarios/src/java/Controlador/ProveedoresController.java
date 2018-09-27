package Controlador;

import DAO.Conexion;
import DAO.ProveedoresDAO;
import Modelo.Proveedores;
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
public class ProveedoresController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getParameter("action");
        String id_proveedor = request.getParameter("id_proveedor");

        try {
            switch (action) {
                case "insertar":
                    this.Insertar(request, response);
                    break;
                case "Actualizar":
                    this.Actualizar(request, response, id_proveedor);
                    break;
                case "Borrar":
                    this.Borrar(request, response, id_proveedor);
                    break;
                case "MostrarUno":
                    this.MostrarUno(request, response, id_proveedor);
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
        String rubro = request.getParameter("rubro");
        String personeria_juridica = request.getParameter("persona");
        int telefono = Integer.parseInt(request.getParameter("telefono"));

        try {
            Proveedores pro = new Proveedores(0);
            pro.setNombre(nombre);
            pro.setRubro(rubro);
            pro.setPersoneria_juridica(personeria_juridica);
            pro.setTelefono(telefono);
            System.out.println(pro);

            Conexion conn = new Conexion();
            ProveedoresDAO dao = new ProveedoresDAO(conn);

            boolean situacion = dao.Insertar(pro);
            List<Proveedores> lista = dao.MostrarTodos();
            String msg = "";

            if (situacion) {
                msg = "Los datos han sido ingresados de forma exitosa.";
            } else {
                msg = "Ha ocurrido un error en el ingreso de su información a la base de datos.";
            }

            RequestDispatcher rd;
            request.setAttribute("msg", msg);
            request.setAttribute("lista", lista);
            rd = request.getRequestDispatcher("/AdministracionMostrarProveedores.jsp");
            rd.forward(request, response);
            conn.desconectar();
        } catch (Exception e) {
            System.out.println("¡Ups!, se presentarón inconvenientes. " + e);
        }
    }

    protected void Actualizar(HttpServletRequest request, HttpServletResponse response, String id_proveedor) {

        int id_proveedor2 = Integer.parseInt(request.getParameter("id_proveedor"));
        String nombre = request.getParameter("nombre");
        String rubro = request.getParameter("rubro");
        String personeria_juridica = request.getParameter("persona");
        int telefono = Integer.parseInt(request.getParameter("telefono"));

        try {
            Proveedores pro = new Proveedores(id_proveedor2);
            pro.setNombre(nombre);
            pro.setRubro(rubro);
            pro.setPersoneria_juridica(personeria_juridica);
            pro.setTelefono(telefono);
            System.out.println(pro);

            Conexion conn = new Conexion();
            ProveedoresDAO dao = new ProveedoresDAO(conn);

            boolean situacion = dao.Actualizar(pro);
            List<Proveedores> lista = dao.MostrarTodos();
            String msg = "";

            if (situacion) {
                msg = "Actualización exitosa.";
            } else {
                msg = "Ha ocurrido un error en la actualización de datos.";
            }

            RequestDispatcher rd;
            request.setAttribute("msg2", msg);
            request.setAttribute("lista", lista);
            rd = request.getRequestDispatcher("/AdministracionMostrarProveedores.jsp");
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

    protected void Borrar(HttpServletRequest request, HttpServletResponse response, String id_proveedor)
            throws ServletException, IOException {

        try {
            Conexion conn = new Conexion();
            ProveedoresDAO dao = new ProveedoresDAO(conn);

            boolean situacion = dao.Borrar(Integer.parseInt(id_proveedor));
            List<Proveedores> lista = dao.MostrarTodos();
            String msg = "";

            if (situacion) {
                msg = "El elemento seleccionado a sido borrado.";
            } else {
                msg = "Ha ocurrido un error.";
            }

            RequestDispatcher rd;
            request.setAttribute("msg2", msg);
            request.setAttribute("lista", lista);
            rd = request.getRequestDispatcher("/AdministracionMostrarProveedores.jsp");
            rd.forward(request, response);
            conn.desconectar();
        } catch (Exception e) {
            System.out.println("¡Ups!, se presentarón incomvenientes. " + e);
        }
    }

    protected void MostrarUno(HttpServletRequest request, HttpServletResponse response, String id_proveedor)
            throws ServletException, IOException, ClassNotFoundException {

        try {
            Conexion conn = new Conexion();
            ProveedoresDAO dao = new ProveedoresDAO(conn);

            List<Proveedores> lista = dao.MostrarUno(Integer.parseInt(id_proveedor));
            RequestDispatcher rd;

            request.setAttribute("lista", lista);
            rd = request.getRequestDispatcher("/ActualizarProveedor.jsp");
            rd.forward(request, response);
            conn.desconectar();
        } catch (Exception e) {
        }
    }

    protected void MostrarTodos(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            Conexion conn = new Conexion();
            ProveedoresDAO dao = new ProveedoresDAO(conn);

            List<Proveedores> lista = dao.MostrarTodos();
            RequestDispatcher rd;

            request.setAttribute("lista", lista);
            rd = request.getRequestDispatcher("/AdministracionMostrarProveedores.jsp");
            rd.forward(request, response);
            conn.desconectar();
        } catch (Exception e) {
        }
    }

    protected void MostrarTodos2(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            Conexion conn = new Conexion();
            ProveedoresDAO dao = new ProveedoresDAO(conn);

            List<Proveedores> lista = dao.MostrarTodos();
            RequestDispatcher rd;

            request.setAttribute("lista", lista);
            rd = request.getRequestDispatcher("/UsuariosMostrarProveedores.jsp");
            rd.forward(request, response);
            conn.desconectar();
        } catch (Exception e) {
        }
    }
}
