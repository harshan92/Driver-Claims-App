<%-- 
    Document   : signup
    Created on : Jul 14, 2018, 6:42:16 PM
    Author     : Getshom
--%>
<%@page import="Database.Entities.Members"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="assets/css/bootstrap.min.css" integrity="sha384-Smlep5jCw/wG7hdkwQ/Z5nLIefveQRIY9nfy6xoR1uRYBtpZgI6339F5dgvm/e9B" crossorigin="anonymous">
        <link rel="stylesheet" href="assets/css/mdb.min.css" crossorigin="anonymous">
        

        <title>XYZ Drivers</title>
    </head>
    <body>
        <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
            <!-- Navbar content -->
             <a class="navbar-brand" href="index.jsp">XYZ Driver</a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarText" aria-controls="navbarText" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>
  <div class="collapse navbar-collapse" id="navbarText">
    <ul class="navbar-nav mr-auto">
<!--      <li class="nav-item active">
        <a class="nav-link" href="#">Home <span class="sr-only">(current)</span></a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="#">Features</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="#">Pricing</a>
      </li>--></ul>
<jsp:include page="LoginStatus.jsp"/>
    
<!--    <span class="navbar-text">
        
        <a class="btn btn-outline-success my-2 my-sm-0" href="signup.jsp">Sign Up</a>
        <a class="btn btn-outline-success my-2 my-sm-0" href="signin.jsp">Sign In</a>
    </span>-->
  </div>
        </nav>
        
            <%
                // This wiill auto enter username and password	
                Members member = (Members)session.getAttribute("Member");
                if(member == null)
                {
                %>
        
        <div class="container" style="padding-top: 30px">
            <form class="col-6 offset-3" method="post" action="SignupController">
                <h1>Sign Up</h1>
                <hr>
  
                <div class="form-group">
      <label for="inputPassword4">Name</label>
      <input type="text" class="form-control" name="name" id="inputPassword4" placeholder="Name" required>
    </div>
  <div class="form-group">
    <label for="inputAddress">Address</label>
    <input type="text" class="form-control" id="inputAddress" name="address" placeholder="Address" required>
  </div>
<!--  <div class="form-group">
    <label for="upassword">Password</label>
    <input type="password" class="form-control" id="upassword" name="pass" placeholder="Password" required>
  </div>
   <div class="form-group">
    <label for="repassword">Confirm Password</label>
    <input type="password" class="form-control" id="repassword" placeholder="Re-Type Password" required>
  </div>-->
<div class="form-group">
<label for="inputPassword4">Username</label>
      <input type="text" class="form-control" name="username" id="inputPassword4" placeholder="Userame" required>
    </div>
                
  <div class="form-row">
    
    <div class="form-group col-md-4">
      <label for="inputCity">Date Of Birth</label>
      <input type="date" class="form-control" id="inputCity" name="dob" required>
    </div>
    
  </div>
  <div class="form-group">
    <div class="form-check">
        <input class="form-check-input" type="checkbox" id="gridCheck" required>
      <label class="form-check-label" for="gridCheck">
        I Agree
      </label>
    </div>
  </div>
  <button type="submit" class="btn btn-primary float-right">Sign Up</button>
  <div class="clearfix"></div>
  <hr>
</form>
        </div>
        <%
            }else{
 out.print("<h2> Please Signout first</h2>");
}
            %>
    

    

    

    </div>

   <!-- Footer -->
<footer class="page-footer font-small black pt-4">

    <!-- Footer Links -->
    
    <!-- Footer Links -->

    <!-- Copyright -->
    <div class="footer-copyright text-center py-3">© 2018 Copyright:
        <a href=""> xyzDriverAssociation</a>
    </div>
    <!-- Copyright -->

  </footer>
  <!-- Footer -->

        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
        <script src="js/bootstrap.min.js" integrity="sha384-o+RDsa0aLu++PJvFqy8fFScvbHFLtbvScb8AjopnFD+iEQ7wo/CG0xlczd+2O/em" crossorigin="anonymous"></script>
    </body>
  </html>
