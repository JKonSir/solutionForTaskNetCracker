<%@ page import="entity.Student" %>
<%@ page import="java.util.ArrayList" %>
<%--
  Created by IntelliJ IDEA.
  User: gijoe
  Date: 7/15/2015
  Time: 21:30 PM
  To change this template use File | Settings | File Templates.
--%>
<%!
    ArrayList<Student> students;
%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<b>Hello, World!!!<br></b>
<%
    students = (ArrayList<Student>) request.getSession().getAttribute("students");
    if (students == null) {
%>
<a href="ServletFind">find</a>
<%
} else {
%>
<style type="text/css">
    table {
        border-collapse: collapse;
    }
    table th,
    table td {
        padding: 0 3px;
    }
    table.brd th,
    table.brd td {
        border: 1px solid #000;
    }
</style>
<form>
    <table class="brd">
        <%
            for (int i = 0; i < students.size(); i++) {
        %>
        <tr>
            <td><%=students.get(i).getFirstName()%>
            </td>
            <td><%=students.get(i).getLastName()%>
            </td>
            <td><%=students.get(i).getIdGroup()%>
            </td>
        </tr>
        <%
            }
        %>
    </table>
</form>
</body>
</html>
<%
    }
%>
