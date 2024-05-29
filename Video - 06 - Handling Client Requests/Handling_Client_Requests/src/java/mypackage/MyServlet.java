/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mypackage;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author kasun-2
 */
@WebServlet(name = "MyServlet", urlPatterns = {"/MyServlet"})
public class MyServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        response.setContentType("text/html");
        
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        
        response.getWriter().println("Name : "+name);
        response.getWriter().println("Email : "+email);
        
        ///////////////////////////////////////////////////////////////////////////
        
        String[] hobbies = request.getParameterValues("hobbies");
        
        response.getWriter().println("<h2> Hobbies </h2>");
        
        if(hobbies != null){
            for(String hobby : hobbies){
                response.getWriter().println(hobby);
            }
        }else{
            
        }
        
        ////////////////////////////////////////////////////////////////////////////
        
        response.getWriter().println("<h2> Parameter Names </h2>");
        
        
        Enumeration<String> paramNames = request.getParameterNames();
        
        while(paramNames.hasMoreElements()){
            String paramName = paramNames.nextElement();
            String paramValue = request.getParameter(paramName);
            response.getWriter().println(paramValue);
        }
        
        
        
        
        
        
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }



}
