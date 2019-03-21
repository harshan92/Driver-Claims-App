<%@page import="Database.Entities.Members"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML>

<html>
    <head>
	<title>XYZ Driver Association</title>
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
			<a href="index.html" class="logo"><strong>User Dash</strong></a>
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
                    if(member == null)
                    {
                        out.print("<h2> Please Signin first <a href='index.php'>Go to Home</a></h2>");
                    }else
                    {%>
                        <jsp:include page="./user_dash_claims_content.jsp"/>;
                     <%}%>
                     <%
                    session.setAttribute("Member", member);
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
