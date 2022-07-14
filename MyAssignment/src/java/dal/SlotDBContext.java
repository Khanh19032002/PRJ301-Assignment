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
import model.Slot;

/**
 *
 * @author KakaNoob
 */
public class SlotDBContext extends DBContext<Slot> {

    public ArrayList<Slot> getSlot() {
        ArrayList<Slot> slots = new ArrayList<>();
        try {
            String sql = "select * from Slot";
            PreparedStatement stm = connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while(rs.next()){
                Slot a = new Slot(rs.getInt("slotNO"));
                slots.add(a);
            }
        } catch (SQLException ex) {
            Logger.getLogger(SlotDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return slots;
    }
}
