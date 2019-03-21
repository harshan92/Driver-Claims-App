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
public class AdminSearchUserController extends HttpServlet {

     
    private static String ERROR_MSG = "Could not process request";
    private MemberModel memberModel;
    private UserModel userModel;
    
    public  AdminSearchUserController()
    {
        memberModel = new MemberModel();
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
        response.setContentType("text/json;charset=UTF-8");
        
        Members member = (Members) request.getSession().getAttribute("Member");
        String user_type = (String) request.getSession().getAttribute("user_type");
        String searchParameter = request.getParameter("searchParameter");
        String searchValue =  request.getParameter("value");
        
        Gson gson = new Gson();
        
        String json ="";
        if (member == null || !user_type.equals("ADMIN") || searchParameter == null || searchValue == null) {
             
            Type type = new TypeToken<String>() {}.getType();
            json = gson.toJson(ERROR_MSG,type);
            
        }else if("data".equals(searchParameter))
        {
            
           List<Members> members = memberModel.getMembers();
        
           
           String[][] data = new String[members.size()][5];
           for(int i = 0; i<members.size(); i++)
           {
               Users user = (Users) members.get(i).getUserses().iterator().next();
               String username2  = user.getUsername();
               String userType = user.getUsertype();
               String name  = members.get(i).getName();
               String status  = user.getStatus();
               String memberid  =  String.valueOf(members.get(i).getId());
               
               data[i][0] = username2;
               data[i][1] = userType;
               data[i][2] = name;
               data[i][3] = status;
               data[i][4] = memberid;
               
           }
                              
            Type type = new TypeToken<String[][]>() {}.getType();
            
            
            
            json = gson.toJson(data, type);

        }else if("name".equals(searchParameter))
        {
            
           List<Members> members = memberModel.getMembers(MemberModel.ATTRIBUTES.NAME, searchValue);
        
           
           String[][] data = new String[members.size()][5];
           for(int i = 0; i<members.size(); i++)
           {
               Users user = (Users) members.get(i).getUserses().iterator().next();
               String username2  = user.getUsername();
               String userType = user.getUsertype();
               String name  = members.get(i).getName();
               String status  = user.getStatus();
               String memberid  =  String.valueOf(members.get(i).getId());
               
               data[i][0] = username2;
               data[i][1] = userType;
               data[i][2] = name;
               data[i][3] = status;
               data[i][4] = memberid;
               
           }
                              
            Type type = new TypeToken<String[][]>() {}.getType();
            
            
            
            json = gson.toJson(data, type);

        }else if("username".equals(searchParameter))
        {
           List<Users> users = userModel.getUsers(UserModel.ATTRIBUTES.USERNAME, searchValue);
           String[][] data = new String[users.size()][5];
           
           for(int i =0; i<users.size();i++)
           {
               Members currentMember = users.get(i).getMembers();
               String username2  = users.get(i).getUsername();
               String userType = users.get(i).getUsertype();
               String name  = currentMember.getName();
               String status  = users.get(i).getStatus();
               String memberid  =  String.valueOf(currentMember.getId());
               
               data[i][0] = username2;
               data[i][1] = userType;
               data[i][2] = name;
               data[i][3] = status;
               data[i][4] = memberid;
               
           } 
           
                              
            Type type = new TypeToken<String[][]>() {}.getType();
            
            
            
            json = gson.toJson(data, type);

        }else
        {
            Type type = new TypeToken<String>() {}.getType();
            json = gson.toJson(ERROR_MSG,type);
        }

      
        
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
