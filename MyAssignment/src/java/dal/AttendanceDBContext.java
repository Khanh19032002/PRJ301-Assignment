/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Attendance;
import model.Session;
import model.Student;

/**
 *
 * @author KakaNoob
 */
public class AttendanceDBContext extends DBContext<Attendance> {

    public ArrayList<Attendance> listAttendanceBySession(int seid) {
        ArrayList<Attendance> alist = new ArrayList<>();
        try {
            String sql = "select a.aid , s.[sID] , se.sessionID , se.stuGroup ,a.[status] from Attend a \n"
                    + " inner join [Session] se on a.sessionID = se.sessionID\n"
                    + " inner join Student s on s.[sID] = a.[stuID]\n"
                    + " left join Enroll e on s.[sID] = e.[sID]\n"
                    + " left join Student_Group sg on e.stuGroup = sg.stuGroup\n"
                    + " where se.sessionID = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, seid);
            ResultSet rs = stm.executeQuery();
            while(rs.next()){
                Attendance a = new Attendance();
                a.setId(rs.getInt(1));
                //Student
                Student s = new Student();
                s.setId(rs.getString(2));
                s.setLogin(rs.getString(3));
                s.setsName(rs.getString(4));
                //Session
                SessionDBContext sdb = new SessionDBContext();
                Session se = sdb.getSessionById(seid);
                a.setSession(se);
                a.setStudent(s);
                a.setStatus(rs.getBoolean(7));
                alist.add(a);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(AttendanceDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return alist;
    }
    
    public void InsertOrUpdate(ArrayList<Attendance> alist){
        
    }
}
