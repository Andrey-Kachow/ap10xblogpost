package ap10x.view;

import utils.Pipe;

import java.io.PrintWriter;

public class Includes {
  public static void include(String templatePath, PrintWriter writer) {
    Pipe.fromTemplateToWriter(templatePath, writer);
  }
}
