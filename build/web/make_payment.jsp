<%@page import="Database.Entities.Members"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<!--
	Editorial by HTML5 UP
	html5up.net | @ajlkn
	Free for personal and commercial use under the CCA 3.0 license (html5up.net/license)
-->
<html>
    <head>
	<title>Editorial by HTML5 UP</title>
        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no" />
        <link rel="stylesheet" href="assets/css/main.css" />
    </head>
    <body class="is-preload">
	<!-- Wrapper -->
	<div id="wrapper">
           
            <!-- Main -->
            <div id="main">
		<div class="inner">
                    <!-- Header -->
                    <header id="header">
			<a href="index.html" class="logo"><strong>Make Payment</strong></a>
			<ul class="icons">              
                        <jsp:include page="LoginStatus.jsp"/>
                        &ensp;
			<li><a href="#" class="icon fa-twitter"><span class="label">Twitter</span></a></li>
			<li><a href="#" class="icon fa-facebook"><span class="label">Facebook</span></a></li>
			<li><a href="#" class="icon fa-snapchat-ghost"><span class="label">Snapchat</span></a></li>
			<li><a href="#" class="icon fa-instagram"><span class="label">Instagram</span></a></li>
			<li><a href="#" class="icon fa-medium"><span class="label">Medium</span></a></li>
			</ul>
                    </header>

		<%
                    Members member = (Members)session.getAttribute("Member");
                    session.setAttribute("Member", member);
                    if(member == null)
                    {
                        out.print("<h2> Please Signin first</h2>");
                    }else{
                        
                %>
                        <div class="container" style="padding-top: 30px">
    <form class="col-6 offset-3" action="makePaymentController" method="post">
        <input type="hidden" name="mem_id" value="<% out.print(member.getId()); %>">
        <h3>Payment Gateway</h3>
        <hr>
        <div class="form-group">
      <label for="fname">Amount</label>
      <input type="text" name="amount" class="form-control" id="amount"  required>
    </div>
        
        
    <div class="form-group">
      <label for="fname">Name on card</label>
      <input type="text" name="namecard" class="form-control" id="nameoncard"  required>
    </div>

                
  
  <div class="form-group">
    <label for="upassword">Card Number</label>
    <input type="text" name="cardno" class="form-control" id="cardno"  required>
  </div>
        
        <div class="form-group">
    <label for="upassword">CSV</label>
    <input type="text" name="cv2" class="form-control" id="csv"  required>
  </div>
        
        <div class="form-group">
    <label for="upassword">Date of Expire</label>
    <input type="text" name="doe" class="form-control" id="doe"  required>
  </div>
  
       <br>         
  
  
  <button type="submit" class="btn btn-primary float-right">Pay Now</button>
  <div class="clearfix"></div>

</form>
    <hr>
</div>
                     <%}%>
                    <%
//                        HttpSession session=getSesssio;
                    
                                   %>
                    <!-- Footer -->
                    <footer id="footer">
                            <p class="copyright">&copy; Untitled. All rights reserved. Demo Images: <a href="https://unsplash.com">Unsplash</a>. Design: <a href="https://html5up.net">HTML5 UP</a>.</p>
                    </footer>

                </div> 
            </div>
	</div>

	<!-- Scripts -->
	<script src="assets/js/jquery.min.js"></script>
	<script src="assets/js/browser.min.js"></script>
	<script src="assets/js/breakpoints.min.js"></script>
	<script src="assets/js/util.js"></script>
        <script src="assets/js/main.js"></script>
    </body>
</html>
