package ap10x;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

public class MyServlet extends HttpServlet {

  @Override
  protected void doGet(
          HttpServletRequest req,
          HttpServletResponse resp
  ) throws IOException {

    resp.setContentType("text/html");
    resp.setStatus(HttpServletResponse.SC_OK);
    PrintWriter pw = resp.getWriter();
    pw.println("<html><body>");
    pw.println("Welcome to servlet");
    pw.println("</body></html>");
  }

}