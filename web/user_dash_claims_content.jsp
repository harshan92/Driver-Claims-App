<%-- 
    Document   : user_dash_claims
    Created on : Jul 15, 2018, 1:31:10 AM
    Author     : sean, harshan
--%>
<!--Import libraries-->
<%@page import="org.hibernate.Hibernate"%>
<%@page import="Database.Utils.DBAccessUtil"%>
<%@page import="Database.Entities.Members"%>
<%@page import="Database.Entities.Claims"%>
<%
//    This member session declared for get member id from logged users
    Members member = (Members)session.getAttribute("Member");
    
    
 %>
<!-- Banner -->
<section id="banner">
    <div class="content">
	<header>
            <h1><br />Make Claim</h1>

	</header>


<div class="col-md-6 col-md-offset-3">    
            <form action="MakeClaimsController" method="post">
               <% out.print(member.getId()); %>
                <div class="form-group">
                    <label for="status">Rationale:</label>
                    <input type="text" class="txtbox" id="status" name="claim_rationale">
                </div>
               
                    
                    <input type="hidden" class="txtbox" value="NA" id="status" name="claim_status">
                
                <div class="form-group">
                    <label for="name">Amount:</label>
                    <input type="text" class="txtbox" id="name" name="claim_amount">
                </div>
				<br>
                                <!--parse logged member id to claim table-->
                                <input type="hidden" name="mem_id" value="<% out.print(member.getId()); %>">
                <button type="submit" class="btn btn-primary ">Submit</button>
            </form> 
            </div>
</div>
</section>



    </div>
</div>

<!-- Sidebar -->
<div id="sidebar">
    <div class="inner">
        <!-- Search -->
        <section id="search" class="alt">
            <form method="post" action="#">
                <input type="text" name="query" id="query" placeholder="Search" />
            </form>
        </section>

        



        <!-- Section -->
        <section>
            <header class="major">
                <h2>Get in touch</h2>
            </header>
            <p>Sed varius enim lorem ullamcorper dolore aliquam aenean ornare velit lacus, ac varius enim lorem ullamcorper dolore. Proin sed aliquam facilisis ante interdum. Sed nulla amet lorem feugiat tempus aliquam.</p>
            <ul class="contact">
                <li class="fa-envelope-o"><a href="#">information@untitled.tld</a></li>
                <li class="fa-phone">(000) 000-0000</li>
                <li class="fa-home">1234 Somewhere Road #8254<br />
                Nashville, TN 00000-0000</li>
            </ul>
        </section>