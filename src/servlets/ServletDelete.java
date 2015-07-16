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
@WebServlet("ServletDelete")
public class ServletDelete extends HttpServlet {

    @EJB
    SessionServiceBean sessionServiceBean;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        sessionServiceBean.delete(Integer.parseInt(id));
        request.getServletContext().getRequestDispatcher("/ServletFind").forward(request, response);
    }
}
