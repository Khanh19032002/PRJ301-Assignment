/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Lecturer;

/**
 *
 * @author KakaNoob
 */
public class LecturerDBContext extends DBContext{
    public Lecturer LecturerLogin(String login , String pass){
        try {
            Lecturer l = new Lecturer();
            String sql = "select * from Lecturer where [login] = ? and [password] = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, login);
            stm.setString(2, pass);
            ResultSet rs = stm.executeQuery();
            while(rs.next()){
                l.setEmail(rs.getString("email"));
                l.setLogin(login);
                l.setName(rs.getString("lectureName"));
                l.setPassword(pass);
                return l;
            }
        } catch (SQLException ex) {
            Logger.getLogger(LecturerDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
