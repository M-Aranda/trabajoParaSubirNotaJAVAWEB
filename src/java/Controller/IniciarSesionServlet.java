/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Administrador;
import Model.DAO.DAO_Administrador;
import Model.DAO.DAO_Rol;
import Model.DAO.DAO_UsuarioNormal;
import Model.UsuarioNormal;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Alumno
 */
@WebServlet(name = "IniciarSesionServlet", urlPatterns = {"/iniciarSesion.do"})
public class IniciarSesionServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            response.setCharacterEncoding("UTF-8");

            String redireccionaA = "";
            Boolean sesionOk = false;
            sesionOk=true;

            /*
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
            */
            if (sesionOk == true) {
                String rut = request.getParameter("nombre");
                String contrasenia = request.getParameter("contrasenia");

                DAO_UsuarioNormal du = new DAO_UsuarioNormal();
                DAO_Administrador da = new DAO_Administrador();
                DAO_Rol dr = new DAO_Rol();

                if (du.usuarioCorrecto(rut, contrasenia) == true) {
                    //es un usuario valido
                    UsuarioNormal usu = du.findByRutContr(rut, contrasenia);
                    request.getSession().setAttribute("usuario", usu);
                    redireccionaA = "menu.jsp";

                } else if (da.adminCorrecto(rut, contrasenia) == true) {
                    //es un admin valido
                    Administrador admin = da.findByRutContr(rut, contrasenia);
                    request.getSession().setAttribute("administrador", admin);
                    redireccionaA = "menu.jsp";

                } else if ((du.usuarioCorrecto(rut, contrasenia) == false) && (da.adminCorrecto(rut, contrasenia) == false)) {
                    //no existe
                    request.getSession().setAttribute("error", "Error al iniciar sesión");
                    redireccionaA = "error.jsp";

                }

            }

            response.sendRedirect(redireccionaA);

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(IniciarSesionServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(IniciarSesionServlet.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
