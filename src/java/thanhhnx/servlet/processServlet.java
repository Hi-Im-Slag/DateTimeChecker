/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thanhhnx.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.format.ResolverStyle;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author ADMIN
 */
public class processServlet extends HttpServlet {

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
            throws ServletException, IOException, ParseException {
        response.setContentType("text/html;charset=UTF-8");
        request.setAttribute("alertMsg", ""); 
        request.setAttribute("Msg", "");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            try {
                int day = Integer.parseInt(request.getParameter("txtDay"));
                int month = Integer.parseInt(request.getParameter("txtMonth"));
                int year = Integer.parseInt(request.getParameter("txtYear"));
                SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
                String date = String.format("%d/%d/%d", day, month, year);
                if (day > 31 || day < 1){
                    RequestDispatcher rd=request.getRequestDispatcher("index.jsp");
                    request.setAttribute("alertMsg", "Day input is out of range !");                 
                    rd.forward(request, response);
                }
                if (month > 12 || month < 1){
                    RequestDispatcher rd=request.getRequestDispatcher("index.jsp");
                    request.setAttribute("alertMsg", "Month input is out of range !");                 
                    rd.forward(request, response);
                }
                if (year > 3000 || year < 1000){
                    RequestDispatcher rd=request.getRequestDispatcher("index.jsp");
                    request.setAttribute("alertMsg", "Month input is out of range !");                 
                    rd.forward(request, response);
                }
                
                try {
                    Date dat = null;
                    df.setLenient(false);                   
                    dat = df.parse(date);
                    RequestDispatcher rd=request.getRequestDispatcher("index.jsp");
                    request.setAttribute("Msg", date + " is valid date !");                 
                    rd.forward(request, response);
                } catch (ParseException e) {
                    RequestDispatcher rd=request.getRequestDispatcher("index.jsp");
                    request.setAttribute("alertMsg", date + " is invalid date !");                 
                    rd.forward(request, response);
                }
            } catch (NumberFormatException e) {
                RequestDispatcher rd=request.getRequestDispatcher("index.jsp");
                request.setAttribute("alertMsg", "Input is invalid format !");                 
                rd.forward(request, response);
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
        try {
            processRequest(request, response);
        } catch (ParseException ex) {
            Logger.getLogger(processServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        try {
            processRequest(request, response);
        } catch (ParseException ex) {
            Logger.getLogger(processServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
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
