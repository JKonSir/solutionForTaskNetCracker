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
 * Created by gijoe on 7/16/2015.
 */
@WebServlet("ServletUpdate")
public class ServletUpdate extends HttpServlet {

    @EJB
    SessionServiceBean sessionServiceBean;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Student student = new Student();
        student.setFirstName(request.getParameter("firstNameUpdate"));
        student.setLastName(request.getParameter("lastNameUpdate"));
        student.setGroupNumber(request.getParameter("name[]Update"));
//        int index = (int)request.getSession().getAttribute("id");
        int index = Integer.parseInt((String) request.getSession().getAttribute("id"));
        sessionServiceBean.update(index, student);
        request.getServletContext().getRequestDispatcher("/ServletFind").forward(request, response);
    }
}
