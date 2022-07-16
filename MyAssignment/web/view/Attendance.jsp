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
            <form action="attendance" method="POST">
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
                                <input type="hidden" name="stuid"
                                       value="${requestScope.stulist.get(i).getId()}">
                                <td>${requestScope.stulist.get(i).getsName()}</td>
                                <td><input type="radio" name="status${i}" value="0" checked="checked"> Absent
                                    <input type="radio" name="status${i}" value="1"> Present
                                </td>
                                </tr>
                            </c:forEach>
                          </c:if>
                        <c:if test = "${requestScope.alist.size() > 0}">
                            <c:forEach begin = "0" end="${requestScope.stulist.size()-1}" var = "i" step = "1">
                                <tr>
                                <td>${i+1}</td>
                                <td>${requestScope.stulist.get(i).getLogin()}</td>
                                <td>${requestScope.stulist.get(i).getId()}</td>
                                <input type="hidden" name="stuid"
                                       value="${requestScope.stulist.get(i).getId()}">
                                <td>${requestScope.stulist.get(i).getsName()}</td>
                                <td><input type="radio" name="status${i}" value="0"<c:if test="${alist.get(i).getStatus() eq false}">checked="checked"</c:if>> Absent
                                    <input type="radio" name="status${i}" value="0"<c:if test="${alist.get(i).getStatus() eq true}">checked="checked"</c:if>> Present
                                </td>
                                </tr>
                            </c:forEach>
                          </c:if>
                    </tbody>
                </table>
                <input type="submit" value="Save">
            </form>
        </div>
    </body>
</html>
