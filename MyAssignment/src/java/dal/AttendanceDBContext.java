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
import model.Lecturer;
import model.Session;
import model.Student;
import model.StudentGroup;

/**
 *
 * @author KakaNoob
 */
public class AttendanceDBContext extends DBContext {

    public ArrayList<Attendance> listAttendanceBySession(int seid) {
        ArrayList<Attendance> alist = new ArrayList<>();
        try {
            String sql = "select a.aid , s.[sID] , s.[login] , s.sName\n"
                    + ", se.sessionID , se.stuGroup ,a.[status] from Attend a \n"
                    + " inner join [Session] se on a.sessionID = se.sessionID\n"
                    + " inner join Student s on s.[sID] = a.[stuID]\n"
                    + " where se.sessionID = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, seid);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
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

    public ArrayList<Attendance> listAttendanceByStudentGroup(String sgid) {
        ArrayList<Attendance> alist = new ArrayList<>();
        try {
            String sql = "  select a.aid , a.[status] , a.stuID , st.[login], st.sName , a.sessionID from Attend a \n"
                    + " left join Student st on a.stuID = st.[sID]\n"
                    + " inner join [Session] se on a.sessionID = se.sessionID\n"
                    + " where se.stuGroup = ?\n";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, sgid);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Attendance a = new Attendance();
                Student s = new Student();
                s.setId(rs.getString(3));
                s.setLogin(rs.getString(4));
                s.setsName(rs.getString(5));
                //Session
                SessionDBContext sdb = new SessionDBContext();
                Session se = sdb.getSessionById(6);
                a.setSession(se);
                a.setStudent(s);
                a.setStatus(rs.getBoolean(2));
                a.setId(1);
                alist.add(a);
            }
        } catch (SQLException ex) {
            Logger.getLogger(AttendanceDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return alist;
    }

    public void InsertOrUpdate(ArrayList<Attendance> alist) {
        try {
            connection.setAutoCommit(false);
            for (Attendance a : alist) {
                if (a.getId() == -1) {
                    String sql = "INSERT INTO [Attend]\n"
                            + "           ([status]\n"
                            + "           ,[stuID]\n"
                            + "           ,[sessionID])\n"
                            + "     VALUES\n"
                            + "           (?\n"
                            + "           ,?\n"
                            + "           ,?)";
                    PreparedStatement stm = connection.prepareStatement(sql);
                    stm.setBoolean(1, a.isStatus());
                    stm.setString(2, a.getStudent().getId());
                    stm.setInt(3, a.getSession().getId());
                    stm.executeUpdate();
                } else {
                    String sql = "Update [Attend] set [status] = ? where aid = ?";
                    PreparedStatement stm = connection.prepareStatement(sql);
                    stm.setBoolean(1, a.isStatus());
                    stm.setInt(2, a.getId());
                    stm.executeUpdate();
                }
            }
            connection.commit();
        } catch (SQLException ex) {
            Logger.getLogger(AttendanceDBContext.class.getName()).log(Level.SEVERE, null, ex);
            try {
                connection.rollback();
            } catch (SQLException ex1) {
                Logger.getLogger(AttendanceDBContext.class.getName()).log(Level.SEVERE, null, ex1);
            }
        } finally {
            try {
                connection.setAutoCommit(true);
            } catch (SQLException ex) {
                Logger.getLogger(AttendanceDBContext.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
