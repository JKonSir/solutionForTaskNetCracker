package servlets;

import beans.SessionServiceBean;
import entity.Student;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by gijoe on 7/17/2015.
 */
@WebServlet("ServletAdd")
public class ServletAdd extends HttpServlet {

    @EJB
    SessionServiceBean sessionServiceBean;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Student student = new Student();
        student.setFirstName(request.getParameter("firstNameAdd"));
        student.setLastName(request.getParameter("lastNameAdd"));
        student.setGroupNumber(request.getParameter("name[]Add"));
//        int index = (int)request.getSession().getAttribute("id");
        sessionServiceBean.add(student);
        request.getServletContext().getRequestDispatcher("/add.jsp").forward(request, response);
    }
}
