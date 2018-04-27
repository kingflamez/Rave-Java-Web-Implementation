<%-- 
    Document   : index
    Created on : Apr 23, 2018, 11:47:56 PM
    Author     : Theresa
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Welcome</title>
        
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link href="//netdna.bootstrapcdn.com/twitter-bootstrap/2.3.2/css/bootstrap-combined.min.css" rel="stylesheet" id="bootstrap-css">
        <script src="//netdna.bootstrapcdn.com/twitter-bootstrap/2.3.2/js/bootstrap.min.js"></script>
        <script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
    </head>
    <body>
       <body>
        <h2 class="control-label">RAVE TICKETS</h2>
     
         <div class="container">
            <div class="row">
                 <div class="span12">
                      <form class="form-horizontal span6" action="Index" method="POST">
                          <fieldset>
                        <div class="control-group">
                             <label class="control-label">Preferred payment type</label>
                                  <div class="controls">
                                       <div class="row-fluid">
                                        <div class="span9">
                                              <select class="input-block-level" name="choice" id="month">
                                                <option value="card">Card Charge</option>
                                                <option value="account">Account Charge</option>
                                               
                                            </select>
                                        </div>
                                    </div>
                                </div>
                            </div>
                              <div class="form-actions">
                                    <button type="submit" class="btn btn-secondary">Submit</button>
                                  
                            </div>
                          </fieldset>
                      </form>
                 </div>
            </div>
         </div>
    </body>
    </body>
</html>
