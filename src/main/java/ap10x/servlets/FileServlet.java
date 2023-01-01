package ap10x.servlets;

import ap10x.Settings;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.eclipse.jetty.http.MimeTypes;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

public class FileServlet extends HttpServlet {

  private static final int BUFFER_SIZE = 1024;

  @Override
  protected void doGet(
    HttpServletRequest req,
    HttpServletResponse resp
  ) throws IOException {

    String filePath = Settings.IMAGES_ROOT + req.getPathInfo();
    String mime = MimeTypes.getDefaultMimeByExtension(filePath);

    if (mime == null) {
      resp.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
      return;
    }

    resp.setContentType(mime);
    File file = new File(filePath);
    resp.setContentLength((int) file.length());

    try (
      FileInputStream in = new FileInputStream(file);
      OutputStream out = resp.getOutputStream();
    ) {
      byte[] buf = new byte[BUFFER_SIZE];
      int count = 0;
      while (true) {
        count = in.read(buf);
        if (count == 0) {
          break;
        }
        out.write(buf, 0, count);
      }
    }
  }
}
