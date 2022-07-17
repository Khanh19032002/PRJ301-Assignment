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
            table{
            }
            th{
                border-right: 1px solid #fff;
                text-align: center;
                padding: 2px;
                text-transform: uppercase;
                height: 23px;
                background-color: #6b90da;
                font-weight: normal;
            }
        </style>
        <script>
            function FormFunction() {
                let form = document.getElementById("form-table");
                form.submit();
            }
        </script>
    </head>
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
                <span>${sessionScope.lecturer.getName()} (${sessionScope.lecturer.getLogin()})</span>
                <br>
                <form id="form-table" action="timetable" method="POST">
                    <table border = "1">
                        <thead>
                            <tr>
                                <th>
                                    Year<select name = "year" onchange="FormFunction()">
                                        <c:forEach items = "${requestScope.years}" var = "y">
                                            <option value ="${y}" <c:if test = "${requestScope.selectedDate.getYear() eq y}">
                                                    selected = "selected"
                                                </c:if>>${y}</option>
                                        </c:forEach>
                                    </select>
                                    <br>
                                    Week<select style="text-align: center;" name = "week" onchange = "FormFunction()">
                                        <c:forEach items = "${requestScope.weeks}" var = "w">
                                            <option value="${w.startDate}"<c:forEach var = "i" begin = "0" end = "6">
                                                        <c:if test = "${w.startDate.plusDays(i) eq requestScope.selectedDate}">
                                                            selected = "selected"
                                                        </c:if>
                                                    </c:forEach>>
                                                ${w.startDate.getDayOfMonth()}/${w.startDate.getMonthValue()}
                                                to ${w.endDate.getDayOfMonth()}/${w.endDate.getMonthValue()}
                                            </option>
                                        </c:forEach>
                                    </select>
                                </th>
                                <th>Mon</th>
                                <th>Tue</th>
                                <th>Wed</th>
                                <th>Thu</th>
                                <th>Fri</th>
                                <th>Sat</th>
                                <th>Sun</th>
                            </tr>
                            <tr>
                                <th></th>
                                    <c:forEach var="i" begin="0" end="6">
                                    <th>${requestScope.selectedWeek.startDate.plusDays(i).getDayOfMonth()}
                                        /${requestScope.selectedWeek.startDate.plusDays(i).getMonthValue()}</th>
                                    </c:forEach>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach items = "${requestScope.slots}" var = "sl">
                                <tr>
                                    <td>Slot ${sl.getSlotNo()}</td>
                                    <c:forEach var = "i" begin="0" end="6">
                                        <td>
                                            <c:forEach items = "${requestScope.selist}" var = "se">
                                                <c:if test="${sl.slotNo eq se.slot.slotNo && requestScope.selectedDate.plusDays(i) eq se.date.toLocalDate()}" >
                                                    ${se.stuGroup.id}
                                                    <br>
                                                    at ${se.room.name}
                                                    <br>
                                                    <c:if test = "${se.getSlot().getSlotNo() eq 1}">
                                                        (7:30-9:00)
                                                    </c:if>
                                                    <c:if test = "${se.getSlot().getSlotNo() eq 2}">
                                                        (9:10-10:40)
                                                    </c:if>
                                                    <c:if test = "${se.getSlot().getSlotNo() eq 3}">
                                                        (10:50-12:20)
                                                    </c:if>
                                                    <c:if test = "${se.getSlot().getSlotNo() eq 4}">
                                                        (12:50-14:20)
                                                    </c:if>
                                                    <c:if test = "${se.getSlot().getSlotNo() eq 5}">
                                                        (14:30-4:00)
                                                    </c:if>
                                                    <c:if test = "${se.getSlot().getSlotNo() eq 6}">
                                                        (4:10-5:40)
                                                    </c:if>
                                                    <c:if test = "${se.getSlot().getSlotNo() eq 7}">
                                                        (18:00-19:30)
                                                    </c:if>
                                                    <c:if test = "${se.getSlot().getSlotNo() eq 8}">
                                                        (19:40-21:10)
                                                    </c:if>
                                                    <br>
                                                    <a href="attendance?seid=${se.getId()}">Take Attendance</a>
                                                </c:if>
                                            </c:forEach>
                                        </td>
                                    </c:forEach>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </form>
            </div>
        </div>
    </body>
</html>
