/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Database.Entities.Claims;
import Database.Entities.Members;
import Database.Models.ClaimModel;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Type;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author sean
 */
public class AdminSeeClaimsController extends HttpServlet {

     private static String ERROR_MSG = "Could not process request";
     private ClaimModel claimModel ;
     
     
     public AdminSeeClaimsController()
     {
         claimModel = new ClaimModel();
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
        
        Members member = (Members) request.getSession().getAttribute("Member");
        String user_type = (String) request.getSession().getAttribute("user_type");
        
        Gson gson = new Gson();
        
        String json ="";
        if (member == null || !user_type.equals("ADMIN")) {
             
            Type type = new TypeToken<String>() {}.getType();
            json = gson.toJson(ERROR_MSG,type);
            
        }else if("data".equals(request.getParameter("type")))
        {
            
            List<Claims> claims = claimModel.getClaims();
            
            String[][] data = new String[claims.size()][6];
            
            for(int i =0; i<claims.size(); i++)
            {
                
                data[i][0] = claims.get(i).getDate().toString();
                data[i][1] = claims.get(i).getRationale();
                data[i][2] = claims.get(i).getStatus();
                data[i][3] = String.valueOf(claims.get(i).getAmount());
                data[i][4] = claims.get(i).getMembers().getName();
                data[i][5] = String.valueOf(claims.get(i).getMembers().getId());
                
                
            }
            
              
            Type type = new TypeToken<String[][]>(){}.getType();
            json = gson.toJson(data,type); 
            
            
            
        }else if("NA".equals(request.getParameter("type")))
        {
            
            List<Claims> claims = claimModel.getClaims(ClaimModel.ATTRIBUTES.STATUS, "NA");
            
            String[][] data = new String[claims.size()][6];
            
            for(int i =0; i<claims.size(); i++)
            {
                
                data[i][0] = claims.get(i).getDate().toString();
                data[i][1] = claims.get(i).getRationale();
                data[i][2] = claims.get(i).getStatus();
                data[i][3] = String.valueOf(claims.get(i).getAmount());
                data[i][4] = claims.get(i).getMembers().getName();
                data[i][5] = String.valueOf(claims.get(i).getMembers().getId());
                
                
            }
            
              
            Type type = new TypeToken<String[][]>(){}.getType();
            json = gson.toJson(data,type); 
            
            
            
        }else
        {
            Type type = new TypeToken<String>() {}.getType();
            json = gson.toJson(ERROR_MSG,type);
        }
        
        
        
        
        
        
        response.setContentType("text/json;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.print(json);
        }
        
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
