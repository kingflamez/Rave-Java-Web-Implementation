<%-- 
    Document   : charge-card
    Created on : Apr 24, 2018, 2:29:26 PM
    Author     : Theresa
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
         <link href="//netdna.bootstrapcdn.com/twitter-bootstrap/2.3.2/css/bootstrap-combined.min.css" rel="stylesheet" id="bootstrap-css">
        <script src="//netdna.bootstrapcdn.com/twitter-bootstrap/2.3.2/js/bootstrap.min.js"></script>
        <script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
        <title>Card Charge</title>
    </head>
    <body>
     <div class="container">
  <div class="row">
    <div class="span12">
      <form class="form-horizontal span6" action="ChargeCard" method="POST">
        <fieldset>
          <legend>Card Charge</legend>
       
       
       
              <div class="control-group">
            <label class="control-label">Card Number</label>
            <div class="controls">
                <input type="text"  required name="cardnumber" id="cardnumber">
            </div>
          </div>
       
          <div class="control-group">
            <label class="control-label">Card Expiry Date</label>
            <div class="controls">
              <div class="row-fluid">
                <div class="span9">
                    <select class="input-block-level" name="month" id="month">
                      <option value="01">January</option>
                      <option value="02">February</option>
                      <option value="03">March</option>
                      <option value="04">April</option>
                      <option value="05">May</option>
                      <option value="06">June</option>
                      <option value="07">July</option>
                      <option value="08">August</option>
                      <option value="09">September</option>
                      <option value="10">October</option>
                      <option value="11">November</option>
                      <option value="12">December</option>
                  </select>
                </div>
                <div class="span3" name="year">
                    <select class="input-block-level" name="year" id="year">
                      <option value="18">2018</option>
                      <option value="19">2019</option>
                      <option value="20">2020</option>
                      <option value="21">2021</option>
                      <option value="22">2022</option>
                      <option value="23">2023</option>
                  </select>
                </div>
              </div>
            </div>
          </div>
       
          <div class="control-group">
            <label class="control-label">Card CVV</label>
            <div class="controls">
              <div class="row-fluid">
                <div class="span3">
                    <input type="text" name="cvv" class="input-block-level" autocomplete="off" maxlength="3" pattern="\d{3}" title="Three digits at back of your card" required>
                </div>
              </div>
            </div>
          </div>
             <div class="control-group">
            <label class="control-label">Card Holder's Email </label>
            <div class="controls">
              <input type="text"  required name="email">
            </div>
          </div>
              <div class="control-group">
            <label class="control-label">Card PIN</label>
            <div class="controls">
              <div class="row-fluid">
                <div class="span3">
                  <input type="text" class="input-block-level" autocomplete="off" maxlength="4" pattern="\d{4}" title="Card pin" required name="pin">
                </div>
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
