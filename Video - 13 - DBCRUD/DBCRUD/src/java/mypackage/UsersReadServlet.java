package mypackage;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author HP
 */
@WebServlet(name = "UsersReadServlet", urlPatterns = {"/UsersReadServlet"})
public class UsersReadServlet extends HttpServlet {
  @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        UserDAO u1 = new UserDAO();
        List<User> users = u1.readUsers();

        if (users != null) {
            request.setAttribute("users", users);
            request.getRequestDispatcher("readusers.jsp").forward(request, response);
        } else {
            response.sendRedirect("error.jsp");
        }
        
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }


}