<%-- 
    Document   : admin_dash_content.jsp
    Created on : Jul 15, 2018, 1:45:11 AM
    Author     : sean
--%>

<%@page import="java.util.Calendar"%>
<%@page import="java.util.Calendar"%>
<%@page import="Database.Entities.Users"%>
<%@page import="Database.Entities.Payments"%>
<%@page import="java.util.Iterator"%>
<%@page import="Database.Entities.Claims"%>
<%@page import="Database.Entities.Members"%>
<%@page import="Database.Models.MemberModel"%>
<!-- Banner -->
<%
    Members member = null;
    String id = request.getParameter("userid");
    if (id != null) {
        MemberModel memberModel = new MemberModel();
        member = memberModel.getMember(Integer.parseInt(id));

    }


%>
								
								<section id="banner">
									
										<header>
											<h1><%out.print(member.getName());%></h1>
                                                                                        <br/>
                                                                                        <p id="UserStatus"><b>Status:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</b><%out.print(((Users)member.getUserses().iterator().next()).getStatus());%></p>
                                                                                        <p><b>Address:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</b><%out.print(member.getAddress());%></p>
                                                                                        <p><b>Date of birth:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</b><%out.print(member.getDob().toString());%></p>
                                                                                        <p><b>Date of Registration:&nbsp;&nbsp;&nbsp;</b><%out.print(member.getDor().toString());%></p>
                                                                                        <p id ="member-areas"><b>Current Areas:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</b>&pound;<%out.print(member.getBalance());%></p>
                                                                                        <button id="UserStatusButton" onclick="changeUserStatus();" style="background-color:<%
                                                                                            if("NA".equals(((Users)member.getUserses().iterator().next()).getStatus()))
                                                                                            {
                                                                                                out.print("white");
                                                                                            }else
                                                                                            {
                                                                                                out.print("lightblue");
                                                                                            }
                                                                                        %>;"><i class="fa fa-user"></i></button>
										</header>									
								</section>
                                                                <section >
                                                                 
									<header>
										<h2>Claims Made</h2>
                                                                                <table>
                                                                                    <th>Date</th>
                                                                                    <th>Rationale</th>
                                                                                    <th>Status</th>
                                                                                    <th>Amount</th>
                                                                                    <th>Control</th>
                                                                                    <%
                                                                                        float sum = 0.0f;
                                                                                        for( Iterator<Claims> it = member.getClaimses().iterator();it.hasNext();)
                                                                                        {
                                                                                            out.print("<tr>");
                                                                                            Claims claim = it.next();
                                                                                            
                                                                                            out.print("<td>");
                                                                                            out.print(claim.getDate().toString());
                                                                                            out.print("</td>");
                                                                                            
                                                                                            out.print("<td>");
                                                                                            out.print(claim.getRationale());
                                                                                            out.print("</td>");
                                                                                            
                                                                                            out.print("<td id='claim-"+claim.getId()+"'>");
                                                                                            out.print(claim.getStatus());
                                                                                            out.print("</td>");
                                                                                            
                                                                                            out.print("<td id='claim-ammount-"+claim.getId()+"'>");
                                                                                            out.print("&pound;"+claim.getAmount());
                                                                                            out.print("</td>");
                                                                                            
                                                                                            out.print("<td>");
                                                                                            out.print("<button onclick=changeClaimStatus("+ claim.getId()+",'APPROVED');><i class='fa fa-check'></i></button>");
                                                                                            out.print("&nbsp;");
                                                                                            out.print("<button onclick=changeClaimStatus("+ claim.getId()+",'REJECTED');><i class='fa fa-times'></i></button>");
                                                                                            out.print("</td>");
                                                                                            out.print("</tr>");
                                                                                            
                                                                                            if (!"NA".equals(claim.getStatus()) && !"REJECTED".equals(claim.getStatus())) {

                                                                                                sum += claim.getAmount();
                                                                                            }
                                                                                            
                                                                                        }    
                                                                                            
                                                                                        out.print("<tr>");
                                                                                        out.print("<td>");
                                                                                        out.print("<b>Total</b>");
                                                                                        out.print("</td>");
                                                                                        out.print("<td>");
                                                                                        out.print("</td>");
                                                                                        out.print("<td>");
                                                                                        out.print("</td>");
                                                                                        out.print("<td>");
                                                                                        out.print("<b id='claim-total'>&pound;"+sum+"</b>");
                                                                                        out.print("</td>");
                                                                                        out.print("</tr>");
                                                                                        
                                                                                        
                                                                                    %>
                                                                                </table>
                                                                                
									</header>	
																		
								</section>
                                                                <section >
                                                                 
									<header>
										<h2>Payments Made</h2>
                                                                                <table>
                                                                                    <th>Date</th>
                                                                                    <th>Type of Payment</th>
                                                                                    <th>Time of Payment</th>
                                                                                    <th>Amount</th>
                                                                                    <%
                                                                                        sum = 0.0f;
                                                                                        for( Iterator<Payments> it = member.getPaymentses().iterator();it.hasNext();)
                                                                                        {
                                                                                            out.print("<tr>");
                                                                                            Payments payment = it.next();
                                                                                            
                                                                                            out.print("<td>");
                                                                                            out.print(payment.getDate().toString());
                                                                                            out.print("</td>");
                                                                                            
                                                                                            out.print("<td>");
                                                                                            out.print(payment.getTypeOfPayment());
                                                                                            out.print("</td>");
                                                                                            
                                                                                            out.print("<td>");
                                                                                            out.print(payment.getTime().toString());
                                                                                            out.print("</td>");
                                                                                            
                                                                                            out.print("<td>");
                                                                                            out.print("&pound;"+payment.getAmount());
                                                                                            out.print("</td>");
                                                                                            out.print("</tr>");
                                                                                            sum+= payment.getAmount();
                                                                                        }
                                                                                        out.print("<tr>");
                                                                                        out.print("<td>");
                                                                                        out.print("<b>Total</b>");
                                                                                        out.print("</td>");
                                                                                        out.print("<td>");
                                                                                        out.print("</td>");
                                                                                        out.print("<td>");
                                                                                        out.print("</td>");
                                                                                        out.print("<td>");
                                                                                        out.print("<b>&pound;"+sum+"</b>");
                                                                                        out.print("</td>");
                                                                                        out.print("</tr>");

                                                                                    %>
                                                                                </table>
                                                                                
									</header>	
																		
								</section>
                                                                <section >
                                                                 
									<header>
										<h2>Annual Charge</h2>
                                                                                <p>Annual charge is 10% total claims made in year </p>
                                                                                <table>
                                                                                    <th>Date</th>
                                                                                    <th>Rationale</th>
                                                                                    <th>Status</th>
                                                                                    <th>Amount</th>
                                                                                    <%
                                                                                        int year = Calendar.getInstance().get(Calendar.YEAR);
                                                                                        Calendar now = Calendar.getInstance();
                                                                                        now.set(year, 0,0, 0, 0,0);
                                                                                        java.util.Date thisYearJava = now.getTime();
                                                                                        java.sql.Date thisYear = new  java.sql.Date(thisYearJava.getTime());
                                                                                        sum = 0.0f;
                                                                                        for( Iterator<Claims> it = member.getClaimses().iterator();it.hasNext();)
                                                                                        {
                                                                                            out.print("<tr>");
                                                                                            Claims claim = it.next();
                                                                                            if ("NA".equals(claim.getStatus()) || "REJECTED".equals(claim.getStatus())) {
                                                                                                continue;
                                                                                            }
                                                                                            if(claim.getDate().getTime()<thisYear.getTime())
                                                                                            {
                                                                                                continue;
                                                                                            }
                                                                                            out.print("<td>");
                                                                                            out.print(claim.getDate().toString());
                                                                                            out.print("</td>");
                                                                                            
                                                                                            out.print("<td>");
                                                                                            out.print(claim.getRationale());
                                                                                            out.print("</td>");
                                                                                            
                                                                                            out.print("<td id='claim-"+claim.getId()+"'>");
                                                                                            out.print(claim.getStatus());
                                                                                            out.print("</td>");
                                                                                            
                                                                                            out.print("<td id='claim-ammount-"+claim.getId()+"'>");
                                                                                            out.print("&pound;"+claim.getAmount());
                                                                                            out.print("</td>");
                                                                                            
                                                                                            
                                                                                            
                                                                                          
                                                                                            sum += claim.getAmount();
                                                                                            
                                                                                            
                                                                                        }    
                                                                                            
                                                                                        out.print("<tr>");
                                                                                        out.print("<td>");
                                                                                        out.print("<b>Total Annual Charge</b>");
                                                                                        out.print("</td>");
                                                                                        out.print("<td>");
                                                                                        out.print("</td>");
                                                                                        out.print("<td>");
                                                                                        out.print("</td>");
                                                                                        out.print("<td>");
                                                                                        out.print("<b '>&pound;"+(sum*0.10)+"</b>");
                                                                                        out.print("</td>");
                                                                                        out.print("</tr>");
                                                                                        
                                                                                        
                                                                                    %>
                                                                                </table>
                                                                                <% out.print("<button onclick=chargeAnnual() style='float:right;'><i class='fa fa-money'></i></button>");%>
                                                                                <br/>
                                                                                
									</header>	
																		
								</section>                
                                                               
				</div>
					</div>

				<!-- Sidebar -->
					<div id="sidebar">
						<div class="inner">


							<!-- Menu -->
								<nav id="menu">
									<header class="major">
										<h2>Menu</h2>
									</header>
									<ul>
										<li><a href="index.jsp">Home</a></li>
                                                                                <li><a href="admin_search_user.jsp">Search User</a></li>
                                                                                <li><a href="admin_outstanding_approvals.jsp">Outstanding Approvals</a></li>
                                                                                <li><a href="admin_see_users.jsp">See Users</a></li>
										<li><a href="admin_see_claims.jsp">See Claims</a></li>
										<li><a href="admin_see_payments.jsp">See Payments</a></li>
                                                                        </ul>
								</nav>



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

                                                </div>                         