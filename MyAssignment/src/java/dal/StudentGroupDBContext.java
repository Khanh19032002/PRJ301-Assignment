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
import model.Group;
import model.Lecturer;
import model.StudentGroup;
import model.Subject;

/**
 *
 * @author KakaNoob
 */
public class StudentGroupDBContext extends DBContext {

    public ArrayList<StudentGroup> StudentGroupListByLecturer(Lecturer l) {
        ArrayList<StudentGroup> sglist = new ArrayList<>();
        try {
            String sql = "  select * from Student_Group sg \n"
                    + " inner join Lecturer l on l.[login] = sg.lecture_Login \n"
                    + " inner join [Group] g on sg.gName = sg.gName\n"
                    + " inner join [Subject] su on sg.subID = su.subID\n"
                    + " where l.[login] = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, l.getLogin());
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                StudentGroup sg = new StudentGroup();
                sg.setId(rs.getString(2));
                Group g = new Group();
                g.setName(rs.getString(4));
                Subject su = new Subject();
                su.setId(rs.getString(1));
                su.setName(rs.getString(10));
                sg.setLecturer(l);
                sg.setSubject(su);
                sg.setGroup(g);
                sglist.add(sg);
            }
        } catch (SQLException ex) {
            Logger.getLogger(StudentGroupDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return sglist;
    }
}
