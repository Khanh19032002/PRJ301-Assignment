<%-- 
    Document   : listStudentGroup
    Created on : Jul 18, 2022, 1:19:10 AM
    Author     : KakaNoob
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Group List</title>
    </head>
    <body>
        <div>
            <h1>
                <span>FPT University Academic Portal</span>
            </h1>
            <h2>
                <a href="home">Home</a>
            </h2>
        </div>
        <div>
            <h3>
                Student groups supervised by ${sessionScope.lecturer.getName()}(${sessionScope.lecturer.getLogin()}) :
            </h3>
            <c:forEach items = "${requestScope.sglist}" var = "sglist">
                <a href="report?sgid=${sglist.getId()}">${sglist.getId()}</a>
                <br>
            </c:forEach>
        </div>
    </body>
</html>
