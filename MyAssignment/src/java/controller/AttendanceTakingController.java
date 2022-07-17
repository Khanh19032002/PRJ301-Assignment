/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package controller;

import dal.AttendanceDBContext;
import dal.SessionDBContext;
import dal.StudentDBContext;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import model.Attendance;
import model.Session;
import model.Student;

/**
 *
 * @author KakaNoob
 */
public class AttendanceTakingController extends HttpServlet {
   
    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */

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
        StudentDBContext stdb = new StudentDBContext();
        SessionDBContext sedb = new SessionDBContext();
        AttendanceDBContext adb = new AttendanceDBContext();
        int seid = Integer.parseInt(request.getParameter("seid"));
        Session s = sedb.getSessionById(seid);
        request.setAttribute("session", s);
        ArrayList<Attendance> alist = adb.listAttendanceBySession(s.getId());
        if(alist.isEmpty()){
            ArrayList<Student> stulist = stdb.listStudentbySession(seid);
            request.setAttribute("stulist", stulist);
        }
        else{
            request.setAttribute("alist", alist);
        }
        request.getRequestDispatcher("../view/Attendance.jsp").forward(request, response);
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
        StudentDBContext stdb = new StudentDBContext();
        SessionDBContext sedb = new SessionDBContext();
        AttendanceDBContext adb = new AttendanceDBContext();
        int seid = Integer.parseInt(request.getParameter("seid"));
        Session se = sedb.getSessionById(seid);
        String[] aid = request.getParameterValues("aid");
        String[] stuid = request.getParameterValues("stuid");
        String[] stuname = request.getParameterValues("stuname");
        String[] stulogin = request.getParameterValues("stulogin");
        ArrayList<Attendance> alist = new ArrayList<>();
        for(int i = 0 ; i < stuid.length ; i++){
            Attendance a = new Attendance();
            if(aid == null){
                a.setId(-1);
            }else{
                a.setId(Integer.parseInt(aid[i]));
            }
            Student s = new Student();
            s.setId(stuid[i]);
            s.setLogin(stulogin[i]);
            s.setsName(stuname[i]);
            a.setStudent(s);
            a.setSession(se);
            a.setStatus(request.getParameter("status" + i).equals("1"));
            alist.add(a);
        }
        adb.InsertOrUpdate(alist);
        response.sendRedirect("attendance?seid="+seid);
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
