/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Database.Entities.Claims;
import Database.Entities.Members;
import Database.Entities.Users;
import Database.Models.ClaimModel;
import Database.Models.MemberModel;
import Database.Models.UserModel;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Harshana-PC
 */
@WebServlet(name = "MakeClaimsController", urlPatterns = {"/MakeClaimsController"})
public class MakeClaimsController extends HttpServlet {
    private ClaimModel claimModel=new ClaimModel();
//    UserModel userModel;
    MemberModel memberModel=new MemberModel();
    
   

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
        //Get parameters from claim form
        String claimRationale =request.getParameter("claim_rationale");
        String claimStatus =request.getParameter("claim_status");
        String claimAmount =request.getParameter("claim_amount");
        String mid =request.getParameter("mem_id");
        //check user id and put data into db
        if(mid==null){
            response.sendRedirect("index.jsp");
        }else{
            Members member = memberModel.getMember(Integer.valueOf(mid));

            Claims claim = new Claims(member, new Date(),claimRationale, claimStatus, Float.valueOf(claimAmount));
                    
            
            claimModel.saveClaim(claim);
            response.sendRedirect("user_dash_claims.jsp");
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

}
