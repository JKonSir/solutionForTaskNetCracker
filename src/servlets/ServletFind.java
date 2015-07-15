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
import java.util.ArrayList;
import java.util.List;

/**
 * Created by gijoe on 7/15/2015.
 */
@WebServlet("ServletFind")
public class ServletFind extends HttpServlet {

    @EJB(beanName = "SessionServiceBeanEJB")
    private SessionServiceBean sessionServiceBean;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Student student = new Student();
        student.setFirstName("VASYA");
        student.setLastName("PUPKIN");
        student.setIdGroup(6406);
        sessionServiceBean.add(student);
//        List<Student> students = sessionServiceBean.findAll();
        ArrayList<Student> students = new ArrayList<>(sessionServiceBean.findAll());
        System.out.println("==========================" + students.size() + "============================");
        for (int i = 0; i < students.size(); i++) {
            student = students.get(i);
            System.out.println("======================================================");
            System.out.println(student.getFirstName() + "     " + student.getLastName() + "     " + student.getIdGroup());
        }
        request.getSession().setAttribute("students", students);
        sessionServiceBean.delete(5);
        request.getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
    }
}
