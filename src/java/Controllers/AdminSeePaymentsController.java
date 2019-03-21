package Controllers;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import Database.Entities.Members;
import Database.Entities.Payments;
import Database.Models.PaymentModel;
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
public class AdminSeePaymentsController extends HttpServlet {

     private static String ERROR_MSG = "Could not process request";
     private PaymentModel paymentModel ;
     
     
     public AdminSeePaymentsController()
     {
         paymentModel = new PaymentModel();
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
            
            List<Payments> payments = paymentModel.getPayments();
            
            String[][] data = new String[payments.size()][6];
            
            for(int i =0; i<payments.size(); i++)
            {
                
                data[i][0] = payments.get(i).getDate().toString();
                data[i][1] = payments.get(i).getTypeOfPayment();
                data[i][2] = String.valueOf(payments.get(i).getAmount());
                data[i][3] = payments.get(i).getMembers().getName();
                data[i][4] = String.valueOf(payments.get(i).getMembers().getId());
                
                
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
