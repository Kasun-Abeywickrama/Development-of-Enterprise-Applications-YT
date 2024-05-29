package mypackage;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author HP
 */
@WebServlet(name = "UserUpdateServlet", urlPatterns = {"/UserUpdateServlet"})
public class UserUpdateServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String id = request.getParameter("id");
        String fName = request.getParameter("fname");
        String lName = request.getParameter("lname");
        String city = request.getParameter("city");

        UserDAO u1 = new UserDAO();
        String status = u1.updateUser(id,fName, lName, city);

        if (status == "success") {
            response.sendRedirect("success.jsp");
        } else {
            response.sendRedirect("error.jsp");
        }

    }

}
