<%-- 
    Document   : user_dash_claims
    Created on : Jul 15, 2018, 1:31:10 AM
    Author     : sean
--%>

<%@page import="Database.Models.ClaimModel"%>
<%@page import="Database.Entities.Members"%>
<%@page import="java.util.List"%>
<%@page import="Database.Entities.Claims"%>
<%@page import="Database.Models.ClaimModel1"%>
<!-- Banner -->
<section id="banner">
    <div class="content">
	<header>
            <h1><br />See Claims</h1>
<!--            <p>A free and fully responsive site template</p>-->
	</header>
        <% 
            %>
            
    <div id="table_area">
        <table>
            <tr>
                <th>No.</th>
               
                <th>Date</th>
                <th>Rationale</th>
                <th>Status</th>
                <th>Amount</th>
            </tr>
             <%
                     Members member=(Members)session.getAttribute("Member");
                     
                     ClaimModel claimModel = new ClaimModel();
                     List<Claims> list = claimModel.getMemberClaims(""+member.getId());
                     int i=0;
                     for (Claims u : list) {
                         i++;
                 %>
                 <tr>
                     <%= member.getId() %>
                     <td><%= i %></td>
                     <td><%= u.getDate() %></td>
                     <td><%= u.getRationale() %></td>
                     <td><%= u.getStatus() %></td>
                     <td><%= u.getAmount() %></td>
                     
                 </tr>
                 <%}%>
        </table>
    </div>

    </div>
</div>
</section>



    </div>
</div>


