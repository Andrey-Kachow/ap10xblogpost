package ap10x.view;

import utils.Pipe;

import java.io.PrintWriter;

public class Scripts implements RenderComponent {
  String[] scriptFiles;

  private Scripts(String... scriptPaths) {
    this.scriptFiles = scriptPaths;
  }

  public static Scripts asFollows(String... scriptPaths) {
    return new Scripts(scriptPaths);
  }

  @Override
  public void render(PrintWriter out) {
    for (String script : scriptFiles) {
      out.println("<script>");
      Pipe.fromFileToWriter("static/scripts/" + script, out);
      out.println("</script>");
    }
  }
}
