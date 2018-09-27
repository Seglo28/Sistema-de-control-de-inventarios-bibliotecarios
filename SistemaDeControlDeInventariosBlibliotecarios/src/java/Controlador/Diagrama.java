package Controlador;

import DAO.AutoresDAO;
import DAO.AutoresDiagramaDAO;
import DAO.Conexion;
import DAO.LibrosDAO;
import Modelo.Autores;
import Modelo.AutoresDiagrama;
import Modelo.Libros;
import java.io.IOException;
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
public class Diagrama extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getParameter("action");
        String id_autor_libro = request.getParameter("id_autor_libro");

        try {
            switch (action) {
                case "Insertar":
                    this.Insertar(request, response);
                    break;
                case "MostrarUno":
                    this.MostrarUno(request, response, id_autor_libro);
                    break;
                case "MostrarTodos":
                    this.MostrarTodos(request, response);
                    break;
                case "Ids":
                    this.Ids(request, response);
                    break;
            }
        } catch (Exception e) {
            System.out.println("Error");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

    protected void Insertar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id_autor = Integer.parseInt(request.getParameter("id_autor"));
        int id_libro = Integer.parseInt(request.getParameter("id_libro"));

        try {
            AutoresDiagrama ad = new AutoresDiagrama(0);
            ad.setId_autor(id_autor);
            ad.setId_libro(id_libro);
            System.out.println(ad);

            Conexion conn = new Conexion();
            AutoresDiagramaDAO dao = new AutoresDiagramaDAO(conn);

            boolean situacion = dao.Insertar(ad);
            List<AutoresDiagrama> lista = dao.MostrarTodos();
            String msg = "";

            if (situacion) {
                msg = "Su información ha sido insertada exitosamente.";
            } else {
                msg = "Ha ocurrido un error al insertar su información a la base de datos.";
            }

            RequestDispatcher rd;
            request.setAttribute("msg", msg);
            request.setAttribute("lista", lista);
            rd = request.getRequestDispatcher("/AdministracionMostrarDiagrama.jsp");
            rd.forward(request, response);
            
        } catch (Exception e) {
            System.out.println("FALLO en el metodo INSERTAR del CONTROLADOR. " + e.getMessage());
        }
    }

    protected void MostrarUno(HttpServletRequest request, HttpServletResponse response, String id_autor_libro)
            throws ServletException, IOException {
        try {
            Conexion conn = new Conexion();
            AutoresDiagramaDAO dao = new AutoresDiagramaDAO(conn);

            AutoresDAO aDAO1 = new AutoresDAO(conn);                                                  //<---
            List<Autores> a1 = aDAO1.MostrarTodos();                                                    //<---

            LibrosDAO lbDAO1 = new LibrosDAO(conn);                                                     //<---
            List<Libros> lb1 = lbDAO1.MostrarTodos();                                                   //<---

            List<AutoresDiagrama> lista = dao.MostrarUno(Integer.parseInt(id_autor_libro));

            //boolean situacion = dao.Borrar(Integer.parseInt(id_autor_libro));    
            RequestDispatcher rd;
            request.setAttribute("lista", lista);
            request.setAttribute("autor", a1);                                                     //<---
            request.setAttribute("libro", lb1);                                                                 //<---
            rd = request.getRequestDispatcher("/AdministracionActualizarDiagrama.jsp");
            rd.forward(request, response);
            conn.desconectar();
        } catch (Exception e) {
            System.out.println("FALLO en el metodo BORRAR del CONTROLADOR. " + e.getMessage());
        }
    }

    protected void MostrarTodos(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            Conexion conn = new Conexion();
            AutoresDiagramaDAO dao = new AutoresDiagramaDAO(conn);

            List<AutoresDiagrama> lista = dao.MostrarTodos();

            //boolean situacion = dao.Borrar(Integer.parseInt(id_autor_libro));    
            RequestDispatcher rd;
            request.setAttribute("lista", lista);
            rd = request.getRequestDispatcher("/AdministracionMostrarDiagrama.jsp");
            rd.forward(request, response);
            conn.desconectar();
        } catch (Exception e) {
            System.out.println("FALLO en el metodo MOSTRAR TODOS del CONTROLADOR. " + e.getMessage());
        }
    }

    protected void Ids(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            Conexion conn = new Conexion();

            AutoresDAO aDAO1 = new AutoresDAO(conn);                                                  //<---
            List<Autores> a1 = aDAO1.MostrarTodos();                                                    //<---

            LibrosDAO lbDAO1 = new LibrosDAO(conn);                                                     //<---
            List<Libros> lb1 = lbDAO1.MostrarTodos();

            RequestDispatcher rd;
            request.setAttribute("autor", a1);
            request.setAttribute("libro", lb1);
            rd = request.getRequestDispatcher("/AgregarDiagrama.jsp");
            rd.forward(request, response);

        } catch (NumberFormatException e) {
            System.out.println("IDS - CONTROLADOR1 " + e.getMessage());
        } catch (ClassNotFoundException | ServletException e) {
            System.out.println("IDS - CONTROLADOR2. " + e);
        } catch (IOException e) {
            System.out.println("IDS - CONTROLADOR3: " + e.getMessage());
        }
    }
}
