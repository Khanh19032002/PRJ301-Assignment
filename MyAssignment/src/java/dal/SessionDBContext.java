/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Group;
import model.Lecturer;
import model.Room;
import model.Session;
import model.Slot;
import model.Student;
import model.StudentGroup;
import model.Subject;

/**
 *
 * @author KakaNoob
 */
public class SessionDBContext extends DBContext {

    public ArrayList<Session> SessionListByLecture(Lecturer l) {
        ArrayList<Session> selist = new ArrayList<>();
        try {
            String sql = "select s.sessionID , s.sessionDate , sg.stuGroup,"
                    + " g.gName , l.lectureName ,l.[login] , l.email, su.subID , su.subName , s.RoomID , s.SlotNO  \n"
                    + "from [Session] s join Room r on s.RoomID = r.Room_ID\n"
                    + "inner join Student_Group sg on sg.stuGroup = s.stuGroup\n"
                    + "inner join Slot sl on sl.slotNO = s.SlotNO\n"
                    + "inner join Lecturer l on sg.lecture_Login = l.[login]\n"
                    + "inner join [Group] g on sg.gname = g.gname\n"
                    + "inner join [Subject] su on sg.subID = su.subID\n"
                    + "where l.login = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, l.getLogin());
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Session s = new Session();
                s.setDate(rs.getDate("sessionDate"));
                s.setId(rs.getInt("sessionID"));
                Room r = new Room();
                r.setName(rs.getString("RoomID"));
                s.setRoom(r);
                Slot sl = new Slot(rs.getInt("SlotNo"));
                s.setSlot(sl);
                //StudentGroup
                StudentGroup sg = new StudentGroup();
                Group g = new Group();
                g.setName(rs.getString("gName"));
                sg.setGroup(g);
                sg.setId(rs.getString("stuGroup"));
                sg.setLecturer(l);
                Subject su = new Subject();
                su.setId(rs.getString("subID"));
                su.setName(rs.getString("subName"));
                sg.setSubject(su);
                s.setStuGroup(sg);
                //Add to sessionlist
                selist.add(s);
            }
        } catch (SQLException ex) {
            Logger.getLogger(SessionDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return selist;
    }

    public Session getSessionById(int seid) {
        try {
            String sql = "select s.sessionID , s.sessionDate , sg.stuGroup,\n"
                    + "                     g.gName , l.[password], l.lectureName ,l.[login] , l.email"
                    + ", su.subID , su.subName , s.RoomID , s.SlotNO \n"
                    + "                   from [Session] s join Room r on s.RoomID = r.Room_ID\n"
                    + "                    inner join Student_Group sg on sg.stuGroup = s.stuGroup\n"
                    + "                    inner join Slot sl on sl.slotNO = s.SlotNO\n"
                    + "                    inner join Lecturer l on sg.lecture_Login = l.[login]\n"
                    + "                    inner join [Group] g on sg.gname = g.gname\n"
                    + "                    inner join [Subject] su on sg.subID = su.subID\n"
                    + "                    where s.sessionID = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, seid);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Session s = new Session();
                s.setDate(rs.getDate("sessionDate"));
                s.setId(rs.getInt("sessionID"));
                Room r = new Room();
                r.setName(rs.getString("RoomID"));
                s.setRoom(r);
                Slot sl = new Slot(rs.getInt("SlotNo"));
                s.setSlot(sl);
                //StudentGroup
                StudentGroup sg = new StudentGroup();
                Group g = new Group();
                g.setName(rs.getString("gName"));
                sg.setGroup(g);
                sg.setId(rs.getString("stuGroup"));
                //Lecturer
                Lecturer l = new Lecturer();
                l.setEmail(rs.getString(8));
                l.setLogin(rs.getString(7));
                l.setName(rs.getString(6));
                l.setPassword(rs.getString(5));
                sg.setLecturer(l);
                //Subject
                Subject su = new Subject();
                su.setId(rs.getString("subID"));
                su.setName(rs.getString("subName"));
                sg.setSubject(su);
                s.setStuGroup(sg);
                return s;
            }
        } catch (SQLException ex) {
            Logger.getLogger(SessionDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public ArrayList<Session> getListSessionByStuGroup(String sgid) {
        ArrayList<Session> selist = new ArrayList<>();
        try {
            String sql = " select s.[sessionID] from [Session] s inner join Student_Group sg on s.stuGroup = sg.stuGroup\n"
                    + " where sg.stuGroup = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, sgid);
            ResultSet rs = stm.executeQuery();
            while(rs.next()){
                Session s = getSessionById(rs.getInt(1));
                selist.add(s);
            }
        } catch (SQLException ex) {
            Logger.getLogger(SessionDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return selist;
    }
}
