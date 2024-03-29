/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rave.appmaven;

import com.github.theresasogunle.CardCharge;
import com.github.theresasogunle.Environment;
import com.github.theresasogunle.RaveConstant;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.JSONObject;

/**
 *
 * @author Theresa
 */
public class ValidateCard extends HttpServlet {

   
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
          RequestDispatcher view=request.getRequestDispatcher("validate-card.jsp");
		view.forward(request, response);
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
        
        String otp = request.getParameter("otp");
        CardCharge ch= new CardCharge();
     
            RaveConstant.ENVIRONMENT= Environment.STAGING;
            RaveConstant.PUBLIC_KEY="FLWPUBK-xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx-X";
            RaveConstant.SECRET_KEY="FLWSECK-xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx-X";
     
          try{
       
            String flwRef =(String)request.getSession().getAttribute("flwRef");
            System.out.println(flwRef);
            ch.setTransactionreference(flwRef);
            ch.setOtp(otp);
        
           JSONObject val=  ch.validateCardCharge();
              System.out.println(val);
       
         
        if(val.get("status").equals("success")){

            response.sendRedirect("ChargeCompleted");
            return;
        }else
        {
            response.sendRedirect("Error");
            return;
        }
        }catch(Exception ex){}
          
       doGet(request,response);
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
