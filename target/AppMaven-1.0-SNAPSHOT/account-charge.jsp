<%-- 
    Document   : account-charge
    Created on : Apr 24, 2018, 2:38:27 PM
    Author     : Theresa
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
         <link href="//netdna.bootstrapcdn.com/twitter-bootstrap/2.3.2/css/bootstrap-combined.min.css" rel="stylesheet" id="bootstrap-css">
        <script src="//netdna.bootstrapcdn.com/twitter-bootstrap/2.3.2/js/bootstrap.min.js"></script>
        <script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
        <title>Account Charge</title>
    </head>
    <body>
      <div class="container">
  <div class="row">
    <div class="span12">
      <form class="form-horizontal span6" action="ChargeAccount" method="POST">
        <fieldset>
          <legend>Account Charge</legend>
       
       
          <div class="control-group">
             <label class="control-label">A/C number </label>
              <div class="controls">
              <input type="text"  required name="acc">
            </div>
          </div>
          
             <div class="control-group">
            <label class="control-label">Bank</label>
            <div class="controls">
              <div class="row-fluid">
                <div class="span9">
                    <select class="input-block-level" name="bank" id="bank">
                      <option value="044">ACCESS BANK NIGERIA</option>
                      <option value="050">ECOBANK NIGERIA PLC</option>
                      <option value="232">STERLING BANK PLC</option>
                      <option value="057">ZENITH BANK PLC</option>
                      <option value="214">FIRST CITY MONUMENT BANK PLC</option>
                      <option value="076">SKYE BANK PLC</option>
                      <option value="601">FSDH Merchant Bank Limited</option>
                      <option value="215">UNITY BANK PLC</option>
                     
                  </select>
                </div>
              </div>
            </div>
          </div>
            
          
             <div class="control-group">
            <label class="control-label">Email </label>
            <div class="controls">
              <input type="text"  required name="email">
            </div>
          </div>
            
          <div class="form-actions">
            <button type="submit" class="btn btn-primary">Submit</button>
            <button type="button" class="btn">Cancel</button>
          </div>
        </fieldset>
   
          
      </form>
    </div>
  </div>
</div>     
         
    </body>
</html>
