package Controlador;

import DAO.Conexion;
import DAO.InventariosDAO;
import DAO.LibrosDAO;
import DAO.ProveedoresDAO;
import Modelo.Inventarios;
import Modelo.Libros;
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
public class inventariosController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getParameter("action");
        //System.out.println("accion= "+action);
        String id_inventario = request.getParameter("id_inventario");
        
        try {
            switch (action) {
                case "Insertar":
                    this.Insertar(request, response);
                    break;
                case "Actualizar":
                    this.Actualizar(request, response, id_inventario);
                    break;
                case "Borrar":
                    this.Borrar(request, response, id_inventario);
                    break;
                case "MostrarUno":
                    this.MostrarUno(request, response, id_inventario);
                    break;
                case "MostrarTodos":
                    this.MostrarTodos(request, response);
                    break;
                case "MostrarTodos2":
                    this.MostrarTodos2(request, response);
                    break;
                case "Ids":
                    this.Ids(request, response);
                    break;
            }
        } catch (Exception ex) {
            System.out.println("ERROR EL EL SWITCH. " + ex);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

    protected void Insertar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int id_proveedor = Integer.parseInt(request.getParameter("id_proveedor"));
        int id_libro = Integer.parseInt(request.getParameter("id_libro"));
        String estado_libro = request.getParameter("estado_libro");
        int existencia_libro = Integer.parseInt(request.getParameter("existencia_libro"));
        int stock_minimo_libro = Integer.parseInt(request.getParameter("stock_minimo_libro"));

        try {

            Inventarios in = new Inventarios(0);
            in.setId_proveedor(id_proveedor);
            in.setId_libro(id_libro);
            in.setEstado_libro(estado_libro);
            in.setExistencia_libro(existencia_libro);
            in.setStock_minimo_libro(stock_minimo_libro);
            System.out.println(in);

            Conexion conn = new Conexion();
            InventariosDAO dao = new InventariosDAO(conn);

            boolean situacion = dao.Insertar(in);
            List<Inventarios> lista = dao.MostrarTodos();
            String msg = "";

            if (situacion) {
                msg = "Los datos han sido ingresados de forma exitosa.";
            } else {
                msg = "Ha ocurrido un error en el ingreso de su información a la base de datos.";
            }

            RequestDispatcher rd;
            request.setAttribute("msg", msg);
            request.setAttribute("lista", lista);
            rd = request.getRequestDispatcher("/AdministracionMostrarInventarios.jsp");
            rd.forward(request, response);
            conn.desconectar();
        } catch (Exception e) {
            System.out.println("¡Ups!, se presentarón inconvenientes ESTO ES EN EL CONTROLADOR. " + e);
        }
    }

    protected void Actualizar(HttpServletRequest request, HttpServletResponse response, String id_inventario) {

        int id_inventario2 = Integer.parseInt(request.getParameter("id_inventario"));
        int id_proveedor = Integer.parseInt(request.getParameter("id_proveedor"));
        int id_libro = Integer.parseInt(request.getParameter("id_libro"));
        String estado_libro = request.getParameter("estado_libro");
        int existencia_libro = Integer.parseInt(request.getParameter("existencia_libro"));
        int stock_minimo_libro = Integer.parseInt(request.getParameter("stock_minimo_libro"));

        try {
            Inventarios in = new Inventarios(id_inventario2);
            in.setId_proveedor(id_proveedor);
            in.setId_libro(id_libro);
            in.setEstado_libro(estado_libro);
            in.setExistencia_libro(existencia_libro);
            in.setStock_minimo_libro(stock_minimo_libro);
            System.out.println(in);

            Conexion conn = new Conexion();
            InventariosDAO dao = new InventariosDAO(conn);

            boolean situacion = dao.Actualizar(in);
            List<Inventarios> lista = dao.MostrarTodos();
            String msg = "";

            if (situacion) {
                msg = "Actualización exitosa.";
            } else {
                msg = "Ha ocurrido un error en la actualización de datos.";
            }

            RequestDispatcher rd;
            request.setAttribute("msg2", msg);
            request.setAttribute("lista", lista);
            rd = request.getRequestDispatcher("/AdministracionMostrarInventarios.jsp");
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

    protected void Borrar(HttpServletRequest request, HttpServletResponse response, String id_inventario)
            throws ServletException, IOException {

        try {
            Conexion conn = new Conexion();
            InventariosDAO dao = new InventariosDAO(conn);

            boolean situacion = dao.Borrar(Integer.parseInt(id_inventario));
            List<Inventarios> lista = dao.MostrarTodos();
            String msg = "";

            if (situacion) {
                msg = "El elemento seleccionado a sido borrado.";
            } else {
                msg = "Ha ocurrido un error.";
            }

            RequestDispatcher rd;
            request.setAttribute("msg2", msg);
            request.setAttribute("lista", lista);
            rd = request.getRequestDispatcher("/AdministracionMostrarInventarios.jsp");
            rd.forward(request, response);
            conn.desconectar();
        } catch (Exception e) {
            System.out.println("¡Ups!, se presentarón incomvenientes. " + e);
        }
    }

    protected void MostrarUno(HttpServletRequest request, HttpServletResponse response, String id_inventario)
            throws ServletException, IOException, ClassNotFoundException {

        try {
            Conexion conn = new Conexion();
            InventariosDAO dao = new InventariosDAO(conn);

            ProveedoresDAO proDAO1 = new ProveedoresDAO(conn);
            List<Proveedores> pro1 = proDAO1.MostrarTodos();

            LibrosDAO lbDAO1 = new LibrosDAO(conn);
            List<Libros> lb1 = lbDAO1.MostrarTodos();

            List<Inventarios> lista = dao.MostrarUno(Integer.parseInt(id_inventario));
            System.out.println("ID EN MOSTRAR UNO: " + lista.get(0).getExistencia_libro());
            RequestDispatcher rd;
            request.setAttribute("lista", lista);
            request.setAttribute("proveedor", pro1);
            request.setAttribute("libro", lb1);
            rd = request.getRequestDispatcher("/ActualizarInventarios.jsp");
            rd.forward(request, response);
            conn.desconectar();
        } catch (Exception e) {
        }
    }

    protected void MostrarTodos(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            Conexion conn = new Conexion();
            InventariosDAO dao = new InventariosDAO(conn);

            List<Inventarios> lista = dao.MostrarTodos();
            RequestDispatcher rd;

            request.setAttribute("lista", lista);
            rd = request.getRequestDispatcher("/AdministracionMostrarInventarios.jsp");
            rd.forward(request, response);
            conn.desconectar();
        } catch (Exception e) {
        }
    }

    protected void MostrarTodos2(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            Conexion conn = new Conexion();
            InventariosDAO dao = new InventariosDAO(conn);

            List<Inventarios> lista = dao.MostrarTodos();
            RequestDispatcher rd;

            request.setAttribute("lista", lista);
            rd = request.getRequestDispatcher("/UsuariosMostrarInventarios.jsp");
            rd.forward(request, response);
            conn.desconectar();
        } catch (Exception e) {
        }
    }

    protected void Ids(HttpServletRequest request, HttpServletResponse response) {

        try {

            Conexion conn = new Conexion();

            ProveedoresDAO proDAO1 = new ProveedoresDAO(conn);
            List<Proveedores> pro1 = proDAO1.MostrarTodos();

            LibrosDAO lbDAO1 = new LibrosDAO(conn);
            List<Libros> lb1 = lbDAO1.MostrarTodos();

            RequestDispatcher rd;
            request.setAttribute("proveedor", pro1);
            request.setAttribute("libro", lb1);
            rd = request.getRequestDispatcher("/AgregarInventario.jsp");
            rd.forward(request, response);

        } catch (NumberFormatException e) {
            System.out.println("IDS - Error de numeros: " + e.getMessage());
        } catch (ClassNotFoundException | ServletException e) {
            System.out.println("IDS - ¡Ups!, se presentarón incomvenientes. " + e);
        } catch (IOException e) {
            System.out.println("IDS - Error de Entrada/Salida: " + e.getMessage());
        }
    }
}
