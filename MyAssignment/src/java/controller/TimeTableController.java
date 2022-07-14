/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package controller;

import dal.LecturerDBContext;
import dal.SessionDBContext;
import dal.SlotDBContext;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.sql.Date;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import model.Lecturer;
import model.Session;
import model.Slot;
import model.Week;

/**
 *
 * @author KakaNoob
 */
public class TimeTableController extends HttpServlet {
   
    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet TimeTableController</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet TimeTableController at " + request.getContextPath () + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    } 

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        HttpSession session = request.getSession();
        if(session.getAttribute("lecturer")!=null){
            SessionDBContext sedb = new SessionDBContext();
            LecturerDBContext ledb = new LecturerDBContext();
            Lecturer l = (Lecturer) session.getAttribute("lecturer");
            ArrayList<Session> selist = sedb.SessionListByLecture(l);
            SlotDBContext slotdb = new SlotDBContext();
            ArrayList<Slot> slots = slotdb.getSlot();
            
            int year = LocalDate.now().getYear() - 3;
            ArrayList<Integer> years = new ArrayList<>();
            for(int i = 0; i<=4 ; i++){
                years.add(year+i);
            }
            request.setAttribute("years", years);
            
            LocalDate selectedDate = LocalDate.now();
            request.setAttribute("selectedDate", selectedDate);
            LocalDate startDate = LocalDate.of(2022, 01, 03);
            request.setAttribute("startDate", startDate);
            ArrayList<Week> weeks = new ArrayList<>();
            for(int i = 0 ; i < 363 ; i+=7){
            LocalDate endDate = startDate.plusDays(6);
            Week w = new Week();
            w.setEndDate(endDate);
            w.setStartDate(startDate);
            weeks.add(w);
            startDate = endDate.plusDays(1);
        }
        }
    }

    /** 
     * Handles the HTTP <code>POST</code> method.
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
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
