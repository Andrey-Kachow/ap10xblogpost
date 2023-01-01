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
    Pipe wrapperPipe = new Pipe("templates/wrapper.html", out);
    PlaceHolder.writeMany(wrapperPipe, out,
      title, stylesheets, content, scripts
    );
    wrapperPipe.writeUntilTheEnd();
  }

  public static BasePage with(
    String title,
    StaticLoader stylesheets,
    StaticLoader scripts,
    RenderComponent content
  ) {
    return new BasePage(title, stylesheets, scripts, content);
  }
}
