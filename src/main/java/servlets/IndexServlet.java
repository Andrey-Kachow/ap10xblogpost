package servlets;

import ap10x.view.index.IndexPage;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

public class IndexServlet extends HttpServlet {
  @Override
  protected void doGet(
          HttpServletRequest req,
          HttpServletResponse resp
  ) throws IOException {
    resp.setContentType("text/html");
    resp.setStatus(HttpServletResponse.SC_OK);
    PrintWriter pw = resp.getWriter();
    new IndexPage().render(pw);
  }
}