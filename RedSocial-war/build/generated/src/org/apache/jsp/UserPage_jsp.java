package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class UserPage_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      response.setContentType("text/html");
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
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css\" integrity=\"sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T\" crossorigin=\"anonymous\">\n");
      out.write("        <title>RedSocial</title>\n");
      out.write("\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <div class=\"bg-light p-4 rounded\">\n");
      out.write("            <div class=\"portlet light profile-sidebar-portlet bordered\">\n");
      out.write("                <div class=\"profile-userpic\">\n");
      out.write("                    <img src=\"https://pbs.twimg.com/profile_images/2755433470/331f139a4cf14ed329a893ca189154f8.jpeg\" class=\"img-responsive\" alt=\"\"> </div>\n");
      out.write("                <div class=\"profile-username\">\n");
      out.write("                    <div class=\"profile-usertitle-name\"> Jike Glynn </div>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"profile-userbuttons\">\n");
      out.write("                    <button type=\"button\" class=\"btn btn-info  btn-sm\">Add To Friends</button>\n");
      out.write("                    <button type=\"button\" class=\"btn btn-info  btn-sm\">Message</button>\n");
      out.write("                    <button type=\"button\" class=\"btn btn-info  btn-sm\">Groups</button>\n");
      out.write("                    <button type=\"button\" class=\"btn btn-info  btn-sm\">Information</button>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("        <!-- Nav tabs -->\n");
      out.write("        <div class=\"bg-light p-4 rounded\">\n");
      out.write("            <ul class=\"nav nav-tabs\" role=\"tablist\">\n");
      out.write("                <li role=\"presentation\" class=\"active\"><a href=\"#home\" aria-controls=\"home\" role=\"tab\" data-toggle=\"tab\">Posts:</a></li>\n");
      out.write("            </ul>\n");
      out.write("        </div>\n");
      out.write("        <!--- \\\\\\\\\\\\\\Post-->\n");
      out.write("        <div class=\"card gedf-card\">\n");
      out.write("            <div class=\"card-header\">\n");
      out.write("                <ul class=\"nav nav-tabs card-header-tabs\" id=\"myTab\" role=\"tablist\">\n");
      out.write("                    <li class=\"nav-item\">\n");
      out.write("                        <a class=\"nav-link active\" id=\"posts-tab\" data-toggle=\"tab\" href=\"#posts\" role=\"tab\" aria-controls=\"posts\" aria-selected=\"true\">Make\n");
      out.write("                            a publication</a>\n");
      out.write("                    </li>\n");
      out.write("                    <li class=\"nav-item\">\n");
      out.write("                        <a class=\"nav-link\" id=\"images-tab\" data-toggle=\"tab\" role=\"tab\" aria-controls=\"images\" aria-selected=\"false\" href=\"#images\">Images</a>\n");
      out.write("                    </li>\n");
      out.write("                </ul>\n");
      out.write("            </div>\n");
      out.write("            <div class=\"card-body\">\n");
      out.write("                <div class=\"tab-content\" id=\"myTabContent\">\n");
      out.write("                    <div class=\"tab-pane fade show active\" id=\"posts\" role=\"tabpanel\" aria-labelledby=\"posts-tab\">\n");
      out.write("                        <div class=\"form-group\">\n");
      out.write("                            <label class=\"sr-only\" for=\"message\">post</label>\n");
      out.write("                            <textarea class=\"form-control\" id=\"message\" rows=\"3\" placeholder=\"What are you thinking?\"></textarea>\n");
      out.write("                        </div>\n");
      out.write("\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"tab-pane fade\" id=\"images\" role=\"tabpanel\" aria-labelledby=\"images-tab\">\n");
      out.write("                        <div class=\"form-group\">\n");
      out.write("                            <div class=\"custom-file\">\n");
      out.write("                                <input type=\"file\" class=\"custom-file-input\" id=\"customFile\">\n");
      out.write("                                <label class=\"custom-file-label\" for=\"customFile\">Upload image</label>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"py-4\"></div>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"btn-toolbar justify-content-between\">\n");
      out.write("                    <div class=\"btn-group\">\n");
      out.write("                        <button type=\"submit\" class=\"btn btn-primary\">share</button>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"btn-group\">\n");
      out.write("                        <button id=\"btnGroupDrop1\" type=\"button\" class=\"btn btn-link dropdown-toggle\" data-toggle=\"dropdown\" aria-haspopup=\"true\"\n");
      out.write("                                aria-expanded=\"false\">\n");
      out.write("                            <i class=\"fa fa-globe\"></i>\n");
      out.write("                        </button>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"card-body\">\n");
      out.write("                        <div class=\"text-muted h7 mb-2\"> <i class=\"fa fa-clock-o\"></i>10 min ago</div>\n");
      out.write("                        <a class=\"card-link\" href=\"#\">\n");
      out.write("                            <h5 class=\"card-title\">Sadzonki</h5>\n");
      out.write("                        </a>\n");
      out.write("\n");
      out.write("                        <p class=\"card-text\">\n");
      out.write("                            Nie ma, ze jest dobrze, czy jest niedobrze. Lubie sadzic nawet marchew.\n");
      out.write("                        </p>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"card-footer\">\n");
      out.write("                        <br>\n");
      out.write("                        <br>\n");
      out.write("                        <a href=\"#\" class=\"card-link\"><i class=\"fa fa-gittip\"></i> Like</a>\n");
      out.write("                        <a href=\"#\" class=\"card-link\"><i class=\"fa fa-comment\"></i> Comment</a>\n");
      out.write("                        <a href=\"#\" class=\"card-link\"><i class=\"fa fa-mail-forward\"></i> Share</a>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("    </div>\n");
      out.write("</body>");
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
