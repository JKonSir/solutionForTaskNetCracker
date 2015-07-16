<%@ page import="java.util.ArrayList" %>
<%@ page import="entity.StudentGroup" %>
<%@ page import="entity.Student" %>
<%@ page import="beans.SessionServiceBean" %>
<%@ page import="javax.ejb.EJB" %>
<%--
  Created by IntelliJ IDEA.
  User: gijoe
  Date: 7/17/2015
  Time: 0:23 AM
  To change this template use File | Settings | File Templates.
--%>
<%!
    @EJB
    SessionServiceBean sessionServiceBean = new SessionServiceBean();
%>
<%
    ArrayList<StudentGroup> studentGroups = new ArrayList<>(sessionServiceBean.getStudentGroups());
//    Student student = new Student();
%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<form action="ServletAdd" method="get">
    <b>First name student </b><input name="firstNameAdd" type="text" value=""><br>
    <b>Last name student </b><input name="lastNameAdd" type="text" value=""><br>
    <b>Group number name student </b><%--<input name="textField3" type="text" value="<%=student.getGroupNumber()%>"><br>--%>
    <select size="1" name="name[]Add">
        <option selected value="null">null</option>
        </option>
        <%
            for (int i = 0; i < studentGroups.size(); i++) {
        %>
        <option value="<%=studentGroups.get(i).getGroupNumber()%>"><%=studentGroups.get(i).getGroupNumber()%>
        </option>
        <%
            }
        %>
    </select>
    <br>
    <input type="submit" value="add"><br>
    <a href="index.jsp">Start page</a><br>
    <a href="find.jsp">Find student</a>
</form>
</body>
</html>
