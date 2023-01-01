package ap10x.view.resume;

import ap10x.view.*;

import java.io.PrintWriter;

public class ResumePage implements RenderComponent {
  @Override
  public void render(PrintWriter out) {
    BasePage.with(
      "Resume",
      new StyleSheets("index.css"),
      new Scripts(),
      new CollectionComponent<>(WorkExperienceProvider.fromTextData())
    ).render(out);
  }
}
