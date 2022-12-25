package ap10x.view;

import java.io.PrintWriter;

public class BasePage implements RenderComponent {

  private final String title;
  private final RenderComponent stylesheets;
  private final RenderComponent content;
  private final RenderComponent scripts;

  private BasePage(
    String title,
    RenderComponent stylesheets,
    RenderComponent scripts,
    RenderComponent content
  ) {
    this.title = title;
    this.stylesheets = stylesheets;
    this.scripts = scripts;
    this.content = content;
  }

  @Override
  public void render(PrintWriter out) {
    out.print("""
      <!DOCTYPE html>
      <html lang="en">
      <head>
          <meta charset="UTF-8">
          <title>""");
    out.print(title);
    out.print("</title>\n");
    stylesheets.render(out);
    out.print("</head>\n<body>\n");
    content.render(out);
    out.println("</body>");
    scripts.render(out);
    out.println("</html>\n");
  }

  public static BasePage with(
    String title,
    RenderComponent stylesheets,
    RenderComponent scripts,
    RenderComponent content
  ) {
    return new BasePage(title, stylesheets, scripts, content);
  }
}
