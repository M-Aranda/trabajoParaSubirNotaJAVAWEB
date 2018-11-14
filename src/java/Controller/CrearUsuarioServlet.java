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
@WebServlet(name = "CrearUsuarioServlet", urlPatterns = {"/crearUsuario.do"})
public class CrearUsuarioServlet extends HttpServlet {

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
                DAO_Administrador da = new DAO_Administrador();
                DAO_UsuarioNormal du = new DAO_UsuarioNormal();
                DAO_Rol dr = new DAO_Rol();

                String rut = request.getParameter("rut");
                String nombre = request.getParameter("nombre");
                String contrasenia = request.getParameter("contrasenia");
                int tipo = Integer.parseInt(request.getParameter("tipo"));

                if (tipo == 1) {
                    UsuarioNormal usu = new UsuarioNormal();
                    usu.setRut(rut);
                    usu.setNombre(nombre);
                    usu.setContrasenia(contrasenia);
                    usu.setRol(dr.findById(tipo));
                    du.create(usu);
                } else if (tipo == 2) {
                    Administrador admin = new Administrador();
                    admin.setRut(rut);
                    admin.setNombre(nombre);
                    admin.setContrasenia(contrasenia);
                    admin.setRol(dr.findById(tipo));
                    da.create(admin);
                }
                redireccionaA="crearUsuario.jsp";
            }

            response.sendRedirect(redireccionaA);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CrearUsuarioServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(CrearUsuarioServlet.class.getName()).log(Level.SEVERE, null, ex);
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
