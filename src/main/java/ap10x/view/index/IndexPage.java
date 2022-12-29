package ap10x.view.index;

import ap10x.view.*;

import java.io.PrintWriter;

public class IndexPage implements RenderComponent {
  @Override
  public void render(PrintWriter out) {
    BasePage.with(
      "Test",
      new StyleSheets("index.css"),
      new Scripts(),
      new Include("index.html")
    ).render(out);
  }
}

