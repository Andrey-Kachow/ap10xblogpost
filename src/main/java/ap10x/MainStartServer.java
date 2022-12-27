package ap10x;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletHandler;
import servlets.IndexServlet;

public class MainStartServer {

  public static void main(String[] args) throws Exception {
    var server = new Server(8082);
    var handler = new ServletHandler();
    server.setHandler(handler);
    handler.addServletWithMapping(IndexServlet.class, "/");
    server.start();
    server.join();
  }
}
