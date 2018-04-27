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
import java.net.InetAddress;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.smartcardio.Card;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author Theresa
 */
public class ChargeCard extends HttpServlet {

  
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
         RequestDispatcher view=request.getRequestDispatcher("charge-card.jsp");
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
        
         String cardnumber=request.getParameter("cardnumber");
            String cvv=request.getParameter("cvv");
            String email=request.getParameter("email");
            String pin=request.getParameter("pin");
            String expiry_month=request.getParameter("month");
            String expiry_year=request.getParameter("year");
           
            
            Double txR= Math.random();
            
            String txRef= txR.toString();
            
            
            
            RaveConstant.ENVIRONMENT= Environment.STAGING;
            RaveConstant.PUBLIC_KEY="FLWPUBK-xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx-X";
            RaveConstant.SECRET_KEY="FLWSECK-xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx-X";
             try{
            CardCharge payload = new CardCharge();
            
            payload.setCardno(cardnumber);
            payload.setCvv(cvv);
            payload.setAmount("1000");
            payload.setEmail(email);
            payload.setExpiryyear(expiry_year);
            payload.setExpirymonth(expiry_month);
            payload.setPin(pin);
            payload.setSuggested_auth("PIN");
            payload.setTxRef(txRef);
             
            
            JSONObject charge= payload.chargeMasterAndVerveCard();
            
            System.out.println(charge);
          
              if(charge.get("status").equals("success")){
                JSONObject data =(JSONObject) charge.get("data");
                 String flw= (String)data.get("flwRef");
                 String message =(String)data.get("chargeResponseMessage");
               
                  System.out.println(message);

                HttpSession session = request.getSession(true); 
                session.setAttribute("flwRef",flw); 
                 
                   response.sendRedirect("ValidateCard");
                        return;
         
          }else{
                    String message =(String) charge.get("message");
                    System.out.println(message);
                    
                HttpSession session = request.getSession(true); 
                session.setAttribute("message",message); 
                    response.sendRedirect("Error");
              return;
         
              }
         
        } catch (JSONException ex) {
            Logger.getLogger(Card.class.getName()).log(Level.SEVERE, null, ex);
        }
        
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
