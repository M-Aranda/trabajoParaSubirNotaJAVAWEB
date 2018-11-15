package Controller;

import Model.Administrador;
import Model.Casa;
import Model.DAO.DAO_Casa;
import Model.UsuarioNormal;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Marce
 */
@WebServlet(name = "CargarTodasLasCasasServlet", urlPatterns = {"/cargarTodasLasCasas.do"})
public class CargarTodasLasCasasServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            response.setCharacterEncoding("UTF-8");

            String redireccionaA = "";
            Boolean sesionOk = false;

            UsuarioNormal u = null;
            Administrador a = null;

            if ((request.getSession().getAttribute("usuario") == null) && (request.getSession().getAttribute("administrador") == null)) {
                request.getSession().setAttribute("error", "Debe iniciar sesión");
                sesionOk = false;
                redireccionaA = "error.jsp";
            } else if (request.getSession().getAttribute("usuario") != null) {
                u = (UsuarioNormal) request.getSession().getAttribute("usuario");
                sesionOk = true;

            } else if (request.getSession().getAttribute("administrador") != null) {
                a = (Administrador) request.getSession().getAttribute("administrador");
                sesionOk = true;
            }

            if (sesionOk == true) {
                DAO_Casa dc = new DAO_Casa();

                List<Casa> lista = dc.read();

                request.getSession().setAttribute("listaDeCasas", lista);
                request.getSession().setAttribute("msg", "Todas las casas");

                redireccionaA="listarCasas.jsp";
            }

            response.sendRedirect(redireccionaA);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CargarTodasLasCasasServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(CargarTodasLasCasasServlet.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
