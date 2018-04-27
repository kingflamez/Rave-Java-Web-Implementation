<%-- 
    Document   : validate-account
    Created on : Apr 24, 2018, 2:38:43 PM
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
    </head>
    <body>
       <body>
         <div class="container">
  <div class="row">
    <div class="span12">
      <form class="form-horizontal span6" action="ValidateAccount" method="POST">
        <fieldset>
          <legend>Account Charge</legend>
           <div class="control-group">
            <label class="control-label">Enter OTP </label>
            <div class="controls">
              <input type="text"  required name="otp">
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
    </body>
    </body>
</html>
