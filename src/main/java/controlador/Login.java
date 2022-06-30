/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controlador;

import dao.LogUsrDAO;
import dao.LoginDAO;
import dao.RolesDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.LogUsr;
import modelo.Usuarios;

/**
 *
 * @author moise
 */
public class Login extends HttpServlet {

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
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            Usuarios usr = new Usuarios();
            LoginDAO ln = new LoginDAO();
            RolesDAO rd = new RolesDAO();
            int rpta = 0;
            int rol = 0;
            if (request.getParameter("btn-login") != null) {
                String usuario = request.getParameter("txtusr");
                String pass = request.getParameter("txtpass");
                usr.setUsuarioGenerado(usuario);
                usr.setContrasena(pass);
                rpta = ln.validar(usr);
                if (rpta != 0) {
                    rol = rd.asignarRol(usr);
                    LogUsrDAO dao = new LogUsrDAO();
                    if (rol == 0) {
                        dao.horaLogin(ln.getId(usr));
                        response.sendRedirect("vista/lista.jsp?usrLg="+usuario);
                    } else if (rol == 1) {
                        dao.horaLogin(ln.getId(usr));
                        response.sendRedirect("vista/admin.jsp");
                    } else if (rol == 2) { 
                        dao.horaLogin(ln.getId(usr));
                        response.sendRedirect("vista/ventas.jsp");
                    } else if (rol == 3){
                        response.sendRedirect("index.jsp?rpta=1");
                    }
                    
                } else {
                    response.sendRedirect("index.jsp?rpta=" + rpta);
                }
            }
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
