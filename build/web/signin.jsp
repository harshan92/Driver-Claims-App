<%-- 
    Document   : signup
    Created on : Jul 14, 2018, 6:42:16 PM
    Author     : Getshom
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="assets/css/bootstrap.min.css" integrity="sha384-Smlep5jCw/wG7hdkwQ/Z5nLIefveQRIY9nfy6xoR1uRYBtpZgI6339F5dgvm/e9B" crossorigin="anonymous">
        <link rel="stylesheet" href="assets/css/mdb.min.css" crossorigin="anonymous">
        

        <title>SignIn</title>
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

    </ul>
    <span class="navbar-text">
        
        <a class="btn btn-outline-success my-2 my-sm-0" href="signup.jsp">Sign Up</a>
        <a class="btn btn-outline-success my-2 my-sm-0" href="signin.jsp">Sign In</a>
    </span>
  </div>
</nav>
        
            
        
<div class="container" style="padding-top: 30px">
    <form class="col-6 offset-3" action="SignInController" method="post">
        <h3>Sign In</h3>
        <hr>
    <div class="form-group">
      <label for="fname">Username</label>
      <input type="text" name="username" class="form-control" id="inputEmail4" placeholder="Username" required>
    </div>

  <div class="form-group">
    <label for="upassword">Password</label>
    <input type="password" name="password" class="form-control" id="upassword" placeholder="Password" required>
  </div>

  <button type="submit" class="btn btn-primary float-right">Sign In</button>
  <div class="clearfix"></div>

</form>
    <hr>
</div>

        
    

    

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
