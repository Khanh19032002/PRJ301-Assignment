/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.Time;
import java.time.LocalTime;

/**
 *
 * @author KakaNoob
 */
public class Slot {

    private int slotNo;
    private Time start;
    private Time end;

    public Slot(int slotNo) {
        if (slotNo == 1) {
            this.start = Time.valueOf(LocalTime.of(7, 30));
            this.end = Time.valueOf(LocalTime.of(9, 00));
        }
        if (slotNo == 2) {
            this.start = Time.valueOf(LocalTime.of(9, 10));
            this.end = Time.valueOf(LocalTime.of(10, 40));
        }
        if (slotNo == 3) {
            this.start = Time.valueOf(LocalTime.of(10, 50));
            this.end = Time.valueOf(LocalTime.of(12, 20));
        }
        if (slotNo == 4) {
            this.start = Time.valueOf(LocalTime.of(12, 50));
            this.end = Time.valueOf(LocalTime.of(14, 20));
        }
        if (slotNo == 5) {
            this.start = Time.valueOf(LocalTime.of(14, 30));
            this.end = Time.valueOf(LocalTime.of(16, 00));
        }
        if (slotNo == 6) {
            this.start = Time.valueOf(LocalTime.of(16, 10));
            this.end = Time.valueOf(LocalTime.of(17, 40));
        }
        if (slotNo == 7) {
            this.start = Time.valueOf(LocalTime.of(18, 00));
            this.end = Time.valueOf(LocalTime.of(19, 30));
        }
        if (slotNo == 8) {
            this.start = Time.valueOf(LocalTime.of(19, 40));
            this.end = Time.valueOf(LocalTime.of(21, 10));
        }
        this.slotNo = slotNo;
    }

    public int getSlotNo() {
        return slotNo;
    }

    public void setSlotNo(int slotNo) {
        this.slotNo = slotNo;
    }

    public Time getStart() {
        return start;
    }

    public Time getEnd() {
        return end;
    }

}
