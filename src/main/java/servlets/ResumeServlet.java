package servlets;

import ap10x.view.index.IndexPage;
import ap10x.view.resume.ResumePage;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

public class ResumeServlet extends HttpServlet {
  @Override
  protected void doGet(
    HttpServletRequest req,
    HttpServletResponse resp
  ) throws ServletException, IOException {
    resp.setContentType("text/html");
    resp.setStatus(HttpServletResponse.SC_OK);
    PrintWriter pw = resp.getWriter();
    new ResumePage().render(pw);
  }
}
