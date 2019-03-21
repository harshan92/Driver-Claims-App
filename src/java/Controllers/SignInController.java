/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Database.Entities.Members;
import Database.Entities.Users;
import Database.Models.UserModel;
import Database.Utils.DBAccessUtil;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.hibernate.Hibernate;

/**
 *
 * @author sean
 */
public class SignInController extends HttpServlet {

    private UserModel userModel;
    
    
    public SignInController()
    {
        userModel = new UserModel();
    }
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        
        
        
        Users user = null ;
        for(Users userTemp : userModel.getUsers(UserModel.ATTRIBUTES.USERNAME, username))
        {
            if(userTemp.getPassword().equals(password))
            {
                user = userTemp;
            }
        }
        
        if(user!=null)
        {
           
            Members member =  user.getMembers();
            request.getSession().setAttribute("Member",member);
            request.getSession().setAttribute("user_type",user.getUsertype());
            
            
        }
         response.sendRedirect("index.jsp");
        
        
        
        
       /*response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet SignInController</title>");            
            out.println("</head>");
            out.println("<body>");
            if (user != null) {
                out.println("<h1>Welcome " + user.getUsername() + "</h1>");
                out.println("<h1>Your ID is " + user.getId() + "</h1>");
                out.println("<h1>Your password is " + user.getPassword() + "</h1>");
                out.println("<h1>Your User type is " + user.getUsertype() + "</h1>");
                out.println("<h1>Your status is " + user.getStatus() + "</h1>");

            }else
            {
                out.println("<h1>Could not find you please signup " + username + "</h1>");
            }
            out.println("</body>");
            out.println("</html>");
        }*/
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
