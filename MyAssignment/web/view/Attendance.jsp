<%-- 
    Document   : Attendance
    Created on : Jul 17, 2022, 3:06:24 AM
    Author     : KakaNoob
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Attendance Taking</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <style>
            table , tr , td , th{
                border: 1px solid black;
                border-collapse: collapse;
            }
        </style>
    </head>
    <body>
        <div>
            <h1>
                <span>FPT University Academic Portal</span>
            </h1>
        </div>

        <div>
            Attendance taking for: ${requestScope.session.getStuGroup().getLecturer().getName()}(${requestScope.session.getStuGroup().getLecturer().getLogin()})
            at ${requestScope.session.getStuGroup().getGroup().getName()}
            <form action="attendance?sid=${requestScope.session.getId()}" method="POST">
                <table>
                    <thead>
                        <tr>
                            <th align="center">Index</th>
                            <th align="center">Member</th>
                            <th align="center">Code</th>
                            <th align="center">Full Name</th>
                            <th align="center">Attendance</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:if test = "${requestScope.stulist.size() > 0}">
                            <c:forEach begin = "0" end="${requestScope.stulist.size()-1}" var = "i" step = "1">
                                <tr>
                                <td>${i+1}</td>
                                <td>${requestScope.stulist.get(i).getLogin()}</td>
                                <td>${requestScope.stulist.get(i).getId()}</td>
                                <td>${requestScope.stulist.get(i).getsName()}</td>
                                <input type="hidden" name="stuid"
                                       value="${requestScope.stulist.get(i).getId()}">
                                <input type="hidden" name="stuname"
                                       value="${requestScope.stulist.get(i).getsName()}">
                                <input type="hidden" name="stulogin"
                                       value="${requestScope.stulist.get(i).getLogin()}">
                                <td><input type="radio" name="status${i}" value="0" checked="checked"> Absent
                                    <input type="radio" name="status${i}" value="1"> Attended
                                </td>
                                </tr>
                            </c:forEach>
                          </c:if>
                        <c:if test = "${requestScope.alist.size() > 0}">
                            <c:forEach begin = "0" end="${requestScope.alist.size()-1}" var = "i" step = "1">
                                <tr>
                                <td>${i+1}</td>
                                <td>${requestScope.alist.get(i).getStudent().getLogin()}</td>
                                <td>${requestScope.alist.get(i).getStudent().getId()}</td>
                                <input type="hidden" name="stuid"
                                       value="${requestScope.alist.get(i).getStudent().getId()}">
                                <input type="hidden" name="stuname"
                                       value="${requestScope.alist.get(i).getStudent().getsName()}">
                                <input type="hidden" name="stulogin"
                                       value="${requestScope.alist.get(i).getStudent().getLogin()}">
                                <input type="hidden" name="aid"
                                       value="${requestScope.alist.get(i).getId()}">
                                <td>${requestScope.alist.get(i).getStudent().getsName()}</td>
                                <td><input type="radio" name="status${i}" value="0"<c:if test="${requestScope.alist.get(i).isStatus() eq false}">checked="checked"</c:if>> Absent
                                    <input type="radio" name="status${i}" value="1"<c:if test="${requestScope.alist.get(i).isStatus() eq true}">checked="checked"</c:if>> Attended
                                </td>
                                </tr>
                            </c:forEach>
                          </c:if>
                    </tbody>
                </table>
                <input type="hidden" name="seid" value="${requestScope.session.getId()}">
                <input type="submit" value="Save">
            </form>
        </div>
    </body>
</html>
