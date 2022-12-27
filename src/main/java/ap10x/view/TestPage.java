package ap10x.view;

import java.io.PrintWriter;

public class TestPage implements RenderComponent {
  @Override
  public void render(PrintWriter out) {
    BasePage.with(
      "Test",
      new RawHtml("<h1>This is Sample Page</h1>")
    ).render(out);
  }
}
