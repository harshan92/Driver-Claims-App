<%-- 
    Document   : LoginStatus
    Created on : Jul 14, 2018, 1:33:11 PM
    Author     : sean
--%>
<%@page import="org.hibernate.Hibernate"%>
<%@page import="Database.Utils.DBAccessUtil"%>
<%@page import="Database.Entities.Members"%>
<%
    Members member = (Members)session.getAttribute("Member");
    String user_type = (String)session.getAttribute("user_type");
    if(member != null)
    {
        if(user_type.equals("ADMIN"))
        {
             out.print("User: " + member.getName() + " <a class=\"btn btn-outline-success my-2 my-sm-0\" href=\"admin_dash.jsp\">Dash</a> <a class=\"btn btn-outline-success my-2 my-sm-0\" href=\"SignOutController\">Logout</a>");

        }else
        {
          out.print("User: " + member.getName() + " <a class=\"btn btn-outline-success my-2 my-sm-0\" href=\"user_dash.jsp\">Dash</a> <a class=\"btn btn-outline-success my-2 my-sm-0\" href=\"SignOutController\">Logout</a>");
        }
    }else{
%>
<a class="btn btn-outline-success my-2 my-sm-0" href="signup.jsp">Sign Up</a>
<a class="btn btn-outline-success my-2 my-sm-0" href="signin.jsp">Sign In</a>
<%
    }
    %>

