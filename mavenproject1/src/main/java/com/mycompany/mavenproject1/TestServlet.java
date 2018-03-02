/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mavenproject1;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.Vector;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author myu
 */
@WebServlet(name = "TestServlet", urlPatterns = {"/TestServlet"})
public class TestServlet extends HttpServlet {

    private Vector meineListe = new Vector();  // User entry list

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param req servlet req
     * @param res servlet res
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        res.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = res.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Gästebuch</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Gästebuch</h1>");
            printForm(out);
            handleForm(req, res);
            printMessages(out);
            out.println("</body>");
            out.println("</html>");
        }

    }

    private void printForm(PrintWriter out) throws ServletException {
        out.println("<FORM METHOD=POST>");
        out.println("<B>Bitte teilen Sie Ihre Gedanke mit uns:</B><BR>");
        out.println("Name:<br> <INPUT TYPE=TEXT SIZE=50 NAME=name><BR>");
        out.println("E-Mail:<br> <INPUT TYPE=TEXT SIZE=50 NAME=email><BR>");
        out.println("Kommentare:<br> <INPUT TYPE=TEXT SIZE=50 NAME=comment><BR><br>");
        out.println("<INPUT TYPE=SUBMIT VALUE=\"Senden\"><BR>");
        out.println("</FORM>");
        out.println("<HR>");
    }

    private void printMessages(PrintWriter out) throws ServletException {
        String name, email, comment;

        Enumeration e = meineListe.elements();
        while (e.hasMoreElements()) {
            GuestbookEntry entry = (GuestbookEntry) e.nextElement();
            name = entry.name;
            email = entry.email;
            comment = entry.comment;
            out.println("<DL>");
            out.println("<DT><B>" + name + "</B> (" + email + ") sagt");
            out.println("<DD><PRE>" + comment + "</PRE>");
            out.println("</DL>");

        }
    }

    private void handleForm(HttpServletRequest req,
            HttpServletResponse res) {
        GuestbookEntry entry = new GuestbookEntry();

        entry.name = req.getParameter("name");
        entry.email = req.getParameter("email");
        entry.comment = req.getParameter("comment");

        meineListe.addElement(entry);

    }

    class GuestbookEntry {

        public String name;
        public String email;
        public String comment;
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
     * @param req servlet req
     * @param res servlet res
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        processRequest(req, res);

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
