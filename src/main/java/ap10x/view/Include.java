package ap10x.view;

import ap10x.utils.Pipe;

import java.io.PrintWriter;

public class Include implements RenderComponent {

  private final String templatePath;

  public Include(String templatePath) {
    this.templatePath = templatePath;
  }

  @Override
  public void render(PrintWriter out) {
    Pipe.writeFromFileToWriter("templates/" + templatePath, out);
  }
}
