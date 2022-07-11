/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author KakaNoob
 */
public class Student {
    private String id;
    private String login;
    private String sName;
    private StudentGroup stuGroup;

    public StudentGroup getStuGroup() {
        return stuGroup;
    }

    public void setStuGroup(StudentGroup stuGroup) {
        this.stuGroup = stuGroup;
    }
    public Student() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getsName() {
        return sName;
    }

    public void setsName(String sName) {
        this.sName = sName;
    }
    
}
