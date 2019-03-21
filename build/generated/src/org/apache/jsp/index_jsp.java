package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("  <html>\n");
      out.write("    <head>\n");
      out.write("        <title>XYZ Driver Association</title>\n");
      out.write("      <link rel=\"stylesheet\" href=\"assets/css/bootstrap.min.css\" integrity=\"sha384-Smlep5jCw/wG7hdkwQ/Z5nLIefveQRIY9nfy6xoR1uRYBtpZgI6339F5dgvm/e9B\" crossorigin=\"anonymous\">\n");
      out.write("      <link rel=\"stylesheet\" href=\"assets/css/mdb.min.css\" crossorigin=\"anonymous\">\n");
      out.write("      <link rel=\"icon\" href=\"images/favicon-car.png\" sizes=\"16x16 32x32\" type=\"image/png\">\n");
      out.write("      <style>\n");
      out.write("          \n");
      out.write("      </style>\n");
      out.write("    </head>\n");
      out.write("\n");
      out.write("    <body>\n");
      out.write("        <nav class=\"navbar navbar-expand-lg navbar-dark bg-dark\">\n");
      out.write("            <!-- Navbar content -->\n");
      out.write("             <a class=\"navbar-brand\" href=\"#\">XYZ Driver</a>\n");
      out.write("  <button class=\"navbar-toggler\" type=\"button\" data-toggle=\"collapse\" data-target=\"#navbarText\" aria-controls=\"navbarText\" aria-expanded=\"false\" aria-label=\"Toggle navigation\">\n");
      out.write("    <span class=\"navbar-toggler-icon\"></span>\n");
      out.write("  </button>\n");
      out.write("  <div class=\"collapse navbar-collapse\" id=\"navbarText\">\n");
      out.write("    <ul class=\"navbar-nav mr-auto\">\n");
      out.write("\n");
      out.write("    </ul>\n");
      out.write("    <span class=\"navbar-text\">\n");
      out.write("        <ul class=\"icons\">\n");
      out.write("                ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "LoginStatus.jsp", out, false);
      out.write("\n");
      out.write("                &ensp;\n");
      out.write("                \n");
      out.write("        </ul>\n");
      out.write("        \n");
      out.write("    </span>\n");
      out.write("  </div>\n");
      out.write("        </nav>\n");
      out.write("        \n");
      out.write("            <div class=\"position-relative overflow-hidden p-3 p-md-5 m-md-3 text-center\" style=\"background-image: url('images/coverpic.jpg');background-repeat: no-repeat, repeat;background-size: cover;\" >\n");
      out.write("                <div class=\"col-md-8 p-lg-5 mx-auto my-5\" style=\"background-color: rgba(255, 255, 255, 0.5); border-radius: 10px;\" >\n");
      out.write("            <h1 class=\"display-4 font-weight-normal\" style=\"color:\">XYZ Drivers Associations</h1>\n");
      out.write("            <p class=\"lead font-weight-normal\" style=\"font-size: 24px; font-weight: bold;color:#6666ff\">Welcome to your personal claims portal.\n");
      out.write(" For all your minor claim needs.\n");
      out.write(" To proceed please login.</p>\n");
      out.write("        <a class=\"btn  btn-primary\" href=\"#\" style=\"color:whitesmoke\">Get Start</a>\n");
      out.write("      </div>\n");
      out.write("      <div class=\"product-device box-shadow d-none d-md-block\"></div>\n");
      out.write("      <div class=\"product-device product-device-2 box-shadow d-none d-md-block\"></div>\n");
      out.write("    </div>\n");
      out.write("        \n");
      out.write("    \n");
      out.write("\n");
      out.write("    \n");
      out.write("\n");
      out.write("    \n");
      out.write("\n");
      out.write("    \n");
      out.write("\n");
      out.write("    \n");
      out.write("\n");
      out.write("    <footer class=\"page-footer font-small black pt-4\">\n");
      out.write("\n");
      out.write("    <!-- Footer Links -->\n");
      out.write("    \n");
      out.write("    <!-- Footer Links -->\n");
      out.write("\n");
      out.write("    <!-- Copyright -->\n");
      out.write("    <div class=\"footer-copyright text-center py-3\">© 2018 Copyright:\n");
      out.write("      <a href=\"\"> xyzDriverAssociation</a>\n");
      out.write("    </div>\n");
      out.write("    <!-- Copyright -->\n");
      out.write("\n");
      out.write("  </footer>\n");
      out.write("  <!-- Footer -->\n");
      out.write("\n");
      out.write("        <script src=\"https://code.jquery.com/jquery-3.3.1.slim.min.js\" integrity=\"sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo\" crossorigin=\"anonymous\"></script>\n");
      out.write("        <script src=\"https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js\" integrity=\"sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49\" crossorigin=\"anonymous\"></script>\n");
      out.write("        <script src=\"js/bootstrap.min.js\" integrity=\"sha384-o+RDsa0aLu++PJvFqy8fFScvbHFLtbvScb8AjopnFD+iEQ7wo/CG0xlczd+2O/em\" crossorigin=\"anonymous\"></script>\n");
      out.write("    </body>\n");
      out.write("  </html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
