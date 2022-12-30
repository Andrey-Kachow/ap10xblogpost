package ap10x;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletHandler;
import servlets.FileServlet;
import servlets.IndexServlet;
import servlets.ResumeServlet;

public class MainStartServer {

  public static void main(String[] args) throws Exception {
    var server = new Server(8082);
    var handler = new ServletHandler();
    server.setHandler(handler);
    handler.addServletWithMapping(IndexServlet.class, "/*");
    handler.addServletWithMapping(FileServlet.class, "/file/*");
    handler.addServletWithMapping(ResumeServlet.class, "/resume/*");
    server.start();
    server.join();
  }
}
