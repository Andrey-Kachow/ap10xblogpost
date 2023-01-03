package ap10x.view.resume;

import ap10x.view.*;

import java.io.PrintWriter;

public class ResumePage implements RenderComponent {

  private static final String WORK_EXPERIENCES_PATH = "templates/resume/work_experiences.html";
  private static final String RELEVANT_PROJECTS_PATH = "templates/resume/relevant_projects.html";

  @Override
  public void render(PrintWriter out) {
    BasePage.with(
      "Resume",
      new StyleSheets("index.css"),
      new Scripts(),
      CollectionComponent.of(
        new CollectionComponent<>(ExperienceProvider.fromTextData(WORK_EXPERIENCES_PATH)),
        new CollectionComponent<>(ExperienceProvider.fromTextData(RELEVANT_PROJECTS_PATH))
      )
    ).render(out);
  }
}
