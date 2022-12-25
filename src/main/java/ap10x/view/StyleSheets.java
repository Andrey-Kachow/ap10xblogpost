package ap10x.view;

import utils.Pipe;

import java.io.PrintWriter;

public class StyleSheets implements RenderComponent {

  String[] stylesheets;

  private StyleSheets(String... styleSheetsPaths) {
    this.stylesheets = styleSheetsPaths;
  }

  @Override
  public void render(PrintWriter out) {
    for (String stylesheet : stylesheets) {
      out.println("<style>");
      Pipe.fromFileToWriter("static/css/" + stylesheet, out);
      out.println("</style>");
    }
  }

  public static StyleSheets asFollows(String... styleSheetsPaths) {
    return new StyleSheets(styleSheetsPaths);
  }
}
