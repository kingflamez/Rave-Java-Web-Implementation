/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rave.appmaven;

import com.github.theresasogunle.AccountCharge;
import com.github.theresasogunle.Environment;
import com.github.theresasogunle.RaveConstant;
import java.io.IOException;
import java.net.InetAddress;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author Theresa
 */
public class ChargeAccount extends HttpServlet {

  
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
      RequestDispatcher view=request.getRequestDispatcher("account-charge.jsp");
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
            String acc=request.getParameter("acc");
            String bank=request.getParameter("bank");
            String email=request.getParameter("email");
            Double txR= Math.random();
            
            String txRef= txR.toString();
            RaveConstant.ENVIRONMENT= Environment.STAGING;
            RaveConstant.PUBLIC_KEY="FLWPUBK-xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx-X";
            RaveConstant.SECRET_KEY="FLWSECK-xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx-X";
            try{
            AccountCharge ch = new AccountCharge();
            
            ch.setAccountbank(bank)
              .setAccountnumber(acc)
              .setEmail(email)
              .setTxRef(txRef)
              .setAmount("1000")
              .setCountry("NG")
              .setCurrency("NGN");
            
            JSONObject charge= ch.chargeAccount();
            
            System.out.println(charge);
       
             if(charge.get("status").equals("success")){
                     JSONObject data =(JSONObject) charge.get("data");
                    String flw= (String)data.get("flwRef");
                    HttpSession session = request.getSession(true); 
                    session.setAttribute("flwRef",flw); 
                    session.setAttribute("payload", ch);
                    response.sendRedirect("ValidateAccount");
                        return;
         
          }else{
                    String message =(String) charge.get("message");
                    System.out.println(message);
                   HttpSession session = request.getSession(true); 
                    session.setAttribute("message",message);
                response.sendRedirect("AccountError");
                return;
         
              }
         
            }catch(JSONException ex){}
        doGet(request, response);
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
