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
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Type;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author sean
 */
public class AdminSeeUsersController extends HttpServlet {

    
    private static String ERROR_MSG = "Could not process request";
    private MemberModel memberModel;
    private UserModel userModel;
    private ClaimModel claimModel ;
    
    public  AdminSeeUsersController()
    {
        memberModel = new MemberModel();
        userModel = new UserModel();
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
        response.setContentType("text/json;charset=UTF-8");
        
        Members member = (Members) request.getSession().getAttribute("Member");
        String user_type = (String) request.getSession().getAttribute("user_type");
        
        Gson gson = new Gson();
        
        String json ="";
        if (member == null || !user_type.equals("ADMIN")) {
             
            Type type = new TypeToken<String>() {}.getType();
            json = gson.toJson(ERROR_MSG,type);
            
        }else if("data".equals(request.getParameter("type")))
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

        }else if("NA".equals(request.getParameter("type")))
        {
            List<Users> users = userModel.getUsers(UserModel.ATTRIBUTES.STATUS, "NA");
            

            String[][] data = new String[users.size()][5];
            for (int i = 0; i < users.size(); i++) {

                Members memberTemp = users.get(i).getMembers();
                data[i][0] = users.get(i).getUsername();
                data[i][1] = users.get(i).getUsertype();
                data[i][2] = memberTemp.getName();
                data[i][3] = users.get(i).getStatus();
                data[i][4] = String.valueOf(memberTemp.getId());

            }

            Type type = new TypeToken<String[][]>() {
            }.getType();

            json = gson.toJson(data, type);
        }else if("change".equals(request.getParameter("type")))
        {
            String what = request.getParameter("what");
            String value = request.getParameter("value");
            String id = request.getParameter("id");
            String querryStatus  = "false";
            
            
            if (what == null || value == null || id == null) {
               

            } else 
            {
                if ("UserStatus".equals(what)) {
                    int memberId = Integer.parseInt(id);

                    Members currentMember = memberModel.getMember(memberId);

                    if (currentMember != null) {
                        Users currentUser = (Users) currentMember.getUserses().iterator().next();
                        currentUser.setStatus(value);
                        userModel.saveMember(currentUser);

                        querryStatus = "true";
                    }

                } else if ("ClaimState".equals(what)) {
                    
                    Claims claim = claimModel.getClaim(Integer.parseInt(id));
                    if(claim !=null)
                    {
                        claim.setStatus(value);
                        claimModel.saveClaim(claim);
                        querryStatus = "true";
                    }

                
                } else if ("balance".equals(what)) {
                    
                    Members currentMember  = memberModel.getMember(Integer.parseInt(id));
                    
                    if (currentMember != null) {
                        float sum = 0.0f;

                        int year = Calendar.getInstance().get(Calendar.YEAR);
                        Calendar now = Calendar.getInstance();
                        now.set(year, 0, 0, 0, 0, 0);
                        java.util.Date thisYearJava = now.getTime();
                        java.sql.Date thisYear = new java.sql.Date(thisYearJava.getTime());
                        
                        for (Iterator<Claims> it = currentMember.getClaimses().iterator(); it.hasNext();) {
                            Claims claim = it.next();
                            if ("NA".equals(claim.getStatus()) || "REJECTED".equals(claim.getStatus())) {
                                continue;
                            }
                            if (claim.getDate().getTime() < thisYear.getTime()) {
                                continue;
                            }
                            
                            sum += claim.getAmount();
                        }
                        
                        sum *= 0.1;
                        currentMember.setBalance(currentMember.getBalance()+sum);
                        memberModel.saveMember(currentMember);
                        querryStatus = String.valueOf(sum);
                    }
                    
                }
               

            }
         
            Type type = new TypeToken<String>() {
            }.getType();

            json = gson.toJson(querryStatus, type);
  
        } else
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
