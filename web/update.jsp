<%@ page import="entity.Student" %>
<%@ page import="javax.ejb.EJB" %>
<%@ page import="beans.SessionServiceBean" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="entity.StudentGroup" %>
<%--
  Created by IntelliJ IDEA.
  User: gijoe
  Date: 7/16/2015
  Time: 14:25 PM
  To change this template use File | Settings | File Templates.
--%>
<%!
    @EJB
    SessionServiceBean sessionServiceBean = new SessionServiceBean();
%>
<%
    String id = request.getParameter("id");
    Student student = sessionServiceBean.findById(Integer.parseInt(id));
    request.getSession().setAttribute("id", id);
    ArrayList<StudentGroup> studentGroups = new ArrayList<>(sessionServiceBean.getStudentGroups());
//    Student student = new Student();
%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<form action="ServletUpdate" method="get">
    <b>First name student </b><input name="firstNameUpdate" type="text" value="<%=student.getFirstName()%>"><br>
    <b>Last name student </b><input name="lastNameUpdate" type="text" value="<%=student.getLastName()%>"><br>
    <b>Group number name student </b><%--<input name="textField3" type="text" value="<%=student.getGroupNumber()%>"><br>--%>
    <select size="1" name="name[]Update">
        <option value="null">null</option>
        <option selected value="<%=student.getGroupNumber()%>"><%=student.getGroupNumber()%>
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
    <input type="submit" value="update"><br>
    <a href="index.jsp">Start page</a><br>
    <a href="find.jsp">Find student</a>
</form>
</body>
</html>
