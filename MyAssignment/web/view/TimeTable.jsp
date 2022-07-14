<%-- 
    Document   : TimeTable
    Created on : Jul 8, 2022, 5:15:35 PM
    Author     : KakaNoob
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Time Table</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <style>
            table , tr , td , th{
                border: 1px solid black;
                border-collapse: collapse;
            }
        </style>
        <script>
            function function(){
                let form = document.getElementById("form");
                form.submit();
            }
        </script>
    <body>
        <div class="container">
            <div class="heading">
                <div>
                    <h1>
                        <span>FPT University Academic Portal</span>
                    </h1>
                </div>
            </div>
            <div class="details">
                Attendance taking for: 
                <span>${sessionScope.lecturer.getLogin()}</span>
                <br>
                <form id="form" action="timetable" method="POST">
                <table>
                    <thead>
                        <tr>
                            <th>
                                Year<select name = "year" onchange="function()">
                                    <c:forEach items = "${requestScope.years}" var = "y">
                                        <option value ="${y}" <c:if test = "${requestScope.selectedDate.getYear() eq y}">
                                                selected = "selected"
                                        </c:if>>${y}</option>
                                    </c:forEach>
                                </select>
                                </br>
                                Week<select>
                                    <option value="1">03/01 to 09/01</option>
                                    <option value="2">09/01 to 16/01</option>
                                    <option value="3">17/01 to 23/01</option>
                                    <option value="4">24/01 to 30/01</option>
                                    <option value="5">31/01 to 06/02</option>
                                </select>
                            </th>
                            <th align="center">MON</th>
                            <th align="center">TUE</th>
                            <th align="center">WED</th>
                            <th align="center">THU</th>
                            <th align="center">FRI</th>
                            <th align="center">SAT</th>
                            <th align="center">SUN</th>
                        </tr>

                        <tr>
                            <th align="center">     </th>
                            <th align="center">03/01</th>
                            <th align="center">04/01</th>
                            <th align="center">05/01</th>
                            <th align="center">06/01</th>
                            <th align="center">07/01</th>
                            <th align="center">08/01</th>
                            <th align="center">09/01</th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr>
                            <td>Slot 1</td>
                            <td><a href="">PRJ301-</a>
                                <br>
                                at DE-C201
                            </td>
                            <td><a href="">JPD123-</a>
                                <br>
                                at DE-C201</td>
                            <td><a href="">PRJ301-</a>
                                <br>
                                at DE-C201</td>
                            <td><a href="">JPD123-</a>
                                <br>
                                at DE-C201</td>
                            <td><a href="">PRJ301-</a>
                                <br>
                                at DE-C201</td>
                            <td>-</td>
                            <td>-</td>
                        </tr>
                        <tr>
                            <td>Slot 2</td>
                            <td><a href="">MAS291-</a>
                                <br>
                                at DE-C201</td>
                            <td><a href="">JPD123-</a>
                                <br>
                                at DE-C201</td>
                            <td><a href="">MAS291-</a>
                                <br>
                                at DE-C201</td>
                            <td><a href="">JPD123-</a>
                                <br>
                                at DE-C201</td>
                            <td><a href="">MAS291-</a>
                                <br>
                                at DE-C201</td>
                            <td>-</td>
                            <td>-</td>
                        </tr>
                        <tr>
                            <td>Slot 3</td>
                            <td>-</td>
                            <td><a href="">IOT102-</a>
                                <br>
                                at DE-C201</td>
                            <td>-</td>
                            <td><a href="">IOT102-</a>
                                <br>
                                at DE-C201</td>
                            <td>-</td>
                            <td>-</td>
                            <td>-</td>
                        </tr>
                        <tr>
                            <td>Slot 4</td>
                            <td>-</td>
                            <td>-</td>
                            <td>-</td>
                            <td>-</td>
                            <td>-</td>
                            <td>-</td>
                            <td>-</td>
                        </tr>
                        <tr>
                            <td>Slot 5</td>
                            <td>-</td>
                            <td>-</td>
                            <td>-</td>
                            <td>-</td>
                            <td>-</td>
                            <td>-</td>
                            <td>-</td>
                        </tr>
                        <tr>
                            <td>Slot 6</td>
                            <td>-</td>
                            <td>-</td>
                            <td>-</td>
                            <td>-</td>
                            <td>-</td>
                            <td>-</td>
                            <td>-</td>
                        </tr>
                        <tr>
                            <td>Slot 7</td>
                            <td>-</td>
                            <td>-</td>
                            <td>-</td>
                            <td>-</td>
                            <td>-</td>
                            <td>-</td>
                            <td>-</td>
                        </tr>
                        <tr>
                            <td>Slot 8</td>
                            <td>-</td>
                            <td>-</td>
                            <td>-</td>
                            <td>-</td>
                            <td>-</td>
                            <td>-</td>
                            <td>-</td>
                        </tr>
                    </tbody>
                </table>
                </form>
            </div>
        </div>
    </body>
</html>
