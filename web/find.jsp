<%@ page import="entity.Student" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="javax.ejb.EJB" %>
<%@ page import="beans.SessionServiceBean" %>
<%--
  Created by IntelliJ IDEA.
  User: gijoe
  Date: 7/15/2015
  Time: 21:30 PM
  To change this template use File | Settings | File Templates.
--%>
<%!
    @EJB
    SessionServiceBean sessionServiceBean = new SessionServiceBean();

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
    request.getSession().removeAttribute("students");
    if (students == null) {
        students = new ArrayList<>(sessionServiceBean.findByCriterion("'%%'"));
    }
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
<form action="index.jsp">
    <table class="brd">
        <%
            for (int i = 0; i < students.size(); i++) {
        %>
        <tr>
            <td><%=students.get(i).getFirstName()%>
            </td>
            <td><%=students.get(i).getLastName()%>
            </td>
            <td><%=students.get(i).getGroupNumber()%>
            </td>
            <td><a href="update.jsp?id=<%=students.get(i).getIdStudent()%>">update</a>
            </td>
            <td><a href="ServletDelete?id=<%=students.get(i).getIdStudent()%>">delete</a>
            </td>
        </tr>
        <%
            }
        %>
    </table>
</form>
<form action="ServletFind" method="get">
    <br>
    <input type="text" name="findCriterion"><br>
    <input type="submit" value="find"><br>
    <a href="add.jsp">Add student</a><br>
    <a href="index.jsp">Start page</a>
</form>
</body>
</html>