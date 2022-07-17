<%-- 
    Document   : AttendanceReport
    Created on : Jul 17, 2022, 11:36:31 PM
    Author     : KakaNoob
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Attendance Report</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <style>
            td{
                border: 1px solid black;
            }
            table{
                width: 100%;
                border: 1px solid black;
                border-collapse: collapse;
            }
            tr{
                border: 1px solid black;
            }
        </style>
    </head>
    <body>
        <div class="heading">
            <div>
                <h1>
                    <span>FPT University Academic Portal</span>
                </h1>
                <h2>
                    <a href="home">Home</a>/<a href="listgroup">List Groups</a>
                </h2>
            </div>
        </div>
        <div>
            <h2>Attendance Report of ${requestScope.sgid}</h2>
            <br>
        </div>
        <div class="table">
            <table>
                <tr>
                    <td>Student ID</td>
                    <td>Student Name</td>
                    <c:forEach items="${requestScope.selist}" var = "se">
                        <td>${se.getDate()}</td>
                    </c:forEach>
                </tr>
                <c:forEach items="${requestScope.slist}" var = "s">
                    <tr>
                        <td>${s.getId()}</td>
                        <td>${s.getsName()}</td>
                        <c:forEach items = "${requestScope.alist}" var = "a">
                            <c:if test="${a.getStudent().getId() == s.getId()}">
                                <td>${a.getStatus()}</td>
                            </c:if>
                        </c:forEach>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </body>
</html>

