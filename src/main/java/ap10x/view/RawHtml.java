package ap10x.view;

import java.io.PrintWriter;

public class RawHtml implements RenderComponent {
  private final String html;

  public RawHtml(String html) {
    this.html = html;
  }

  @Override
  public void render(PrintWriter out) {
    out.println(html);
  }
}
