/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Database.Entities.Members;
import Database.Entities.Users;
import Database.Models.MemberModel;
import Database.Models.UserModel;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author sean
 */
@WebServlet(name = "SignupController", urlPatterns = {"/SignupController"})
public class SignupController extends HttpServlet {

    private final static String USER_TYPE = "NORMAL";
    private final static float BALANCE = 100.0f;
    private final static SimpleDateFormat dateFormater = new SimpleDateFormat("yyyy-MM-dd");
    
    private MemberModel memebersModel;
    private UserModel usersModel;
    
    
    public SignupController()
    {
        memebersModel = new MemberModel();
        usersModel = new UserModel();
       
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
        response.setContentType("text/html;charset=UTF-8");
        boolean isSuccesfull = false;
        
        String name = request.getParameter("name");
        String address =request.getParameter("address");
        String username =request.getParameter("username");
        String dateOfBirth =request.getParameter("dob");
        
        
     
        try {
             Members member= new Members( name, address, dateFormater.parse(dateOfBirth), new Date(),BALANCE ,null,null,null );
             Users user = new Users( member, randomPassword(), "NA", username, USER_TYPE);
             
             memebersModel.saveMember(member);
             usersModel.saveMember(user);
             isSuccesfull = true;
        } catch (ParseException ex) {
            Logger.getLogger(SignupController.class.getName()).log(Level.SEVERE, null, ex);
        }
       
        if(!isSuccesfull)
        {
            response.sendRedirect("signup.jsp");
        }else
        {
            response.sendRedirect("signin.jsp");
        }

                
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
    
    
    private String randomPassword()
    {
        Random rand = new Random();
        String password = "";
        for(int i = 10; i>0; i--)
        {
            int  n =rand.nextInt((126 - 33) + 1) +33;
            password+= (char)n;
        }
        
       return password;
    }

}
