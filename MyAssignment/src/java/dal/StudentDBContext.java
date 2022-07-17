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
import model.Student;

/**
 *
 * @author KakaNoob
 */
public class StudentDBContext extends DBContext {

    public ArrayList<Student> listStudentbySession(int seid) {
        ArrayList<Student> slist = new ArrayList<>();
        try {
            String sql = "select s.[login] , s.[sID] , s.[sName] from [Session] se\n"
                    + "inner join Student_Group sg on se.stuGroup = sg.stuGroup \n"
                    + "inner join Enroll e on e.stuGroup = sg.stuGroup\n"
                    + "inner join Student s on s.[sID] = e.[sID]\n"
                    + "where se.sessionID = ? ";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, seid);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Student s = new Student();
                s.setLogin(rs.getString(1));
                s.setId(rs.getString(2));
                s.setsName(rs.getString(3));
                slist.add(s);
            }
        } catch (SQLException ex) {
            Logger.getLogger(StudentDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return slist;
    }

    public ArrayList<Student> listStudentbyStuGroup(String sgid) {
        ArrayList<Student> slist = new ArrayList<>();
        try {
            String sql = " select * from [Student] s \n"
                    + " inner join Enroll e on e.[sID] = s.[sID]\n"
                    + " inner join Student_Group sg on e.stuGroup = sg.stuGroup\n"
                    + " where sg.stuGroup = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, sgid);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Student s = new Student();
                s.setLogin(rs.getString(2));
                s.setId(rs.getString(1));
                s.setsName(rs.getString(3));
                slist.add(s);
            }
        } catch (SQLException ex) {
            Logger.getLogger(StudentDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return slist;
    }
}
