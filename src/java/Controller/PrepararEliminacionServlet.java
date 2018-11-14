/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Administrador;
import Model.UsuarioNormal;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Alumno
 */
@WebServlet(name = "PrepararEliminacionServlet", urlPatterns = {"/prepararEliminacion.do"})
public class PrepararEliminacionServlet extends HttpServlet {

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
            request.getSession().setAttribute("idUsuarioABorrar", request.getParameter("idAEliminar"));
            request.getSession().setAttribute("tipoDeUsuarioABorrar", request.getParameter("tipo"));
            redireccionaA="confirmacion.jsp";
        }

        response.sendRedirect(redireccionaA);

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
