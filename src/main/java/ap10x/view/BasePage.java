package ap10x.view;

import ap10x.utils.Pipe;
import ap10x.view.shared.PlaceHolder;

import java.io.PrintWriter;

public class BasePage implements RenderComponent {

  private final String title;
  private final StaticLoader stylesheets;
  private final RenderComponent content;
  private final StaticLoader scripts;

  private BasePage(
    String title,
    StaticLoader stylesheets,
    StaticLoader scripts,
    RenderComponent content
  ) {
    this.title = title;
    this.stylesheets = stylesheets;
    this.stylesheets.attach("style.css");
    this.scripts = scripts;
    this.scripts.attach("base.js");
    this.content = content;
  }

  @Override
  public void render(PrintWriter out) {
    out.print("""
      <!DOCTYPE html>
      <html lang="en">
      <head>
          <meta charset="UTF-8">
          <meta name="viewport" content="width=device-width, initial-scale=1.0">
          <title>""");
    out.print(title);
    out.print("</title>\n");
    stylesheets.render(out);
    out.print("</head>\n<body>\n");

    // Handling wrapper
    Pipe wrapperPipe = new Pipe("templates/wrapper.html", out);
    PlaceHolder.writeAndRender(wrapperPipe, out, content);
    wrapperPipe.writeUntilTheEnd();

    out.println("</body>");
    scripts.render(out);
    out.println("</html>\n");
  }

  public static BasePage with(
    String title,
    StaticLoader stylesheets,
    StaticLoader scripts,
    RenderComponent content
  ) {
    return new BasePage(title, stylesheets, scripts, content);
  }

  public static BasePage with(
    String title,
    RenderComponent content
  ) {
    return new BasePage(title, new StyleSheets(), new Scripts(), content);
  }
}
