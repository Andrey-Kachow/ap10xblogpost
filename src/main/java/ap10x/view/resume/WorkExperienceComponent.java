package ap10x.view.resume;

import ap10x.models.Date;
import ap10x.utils.Pipe;
import ap10x.view.RenderComponent;

import java.io.PrintWriter;
import java.util.List;

public class WorkExperienceComponent implements RenderComponent {

  private final String roleTitle;
  private final String company;
  private final Date startDate;
  private final Date endDate;
  private final List<String> keyPoints;
  private final String description;
  private final String thoughts;

  public WorkExperienceComponent(
    String roleTitle,
    String company,
    Date startDate,
    Date endDate,
    List<String> keyPoints,
    String description,
    String thoughts
  ) {
    this.roleTitle = roleTitle;
    this.company = company;
    this.startDate = startDate;
    this.endDate = endDate;
    this.keyPoints = keyPoints;
    this.description = description;
    this.thoughts = thoughts;
  }

  @Override
  public void render(PrintWriter out) {
    Pipe workExperiencePipe = new Pipe("templates/resume/work_experience.html", out);
    workExperiencePipe.writeUntilPlaceHolder();
    out.println(roleTitle);
    workExperiencePipe.writeUntilPlaceHolder();
    out.println(company);
    workExperiencePipe.writeUntilPlaceHolder();
    out.println(startDate);
    out.println(" - ");
    out.println(endDate);
    workExperiencePipe.writeUntilPlaceHolder();

    for (String keyPoint : keyPoints) {
      out.println("<li class=\"wexp-key-point-li\">" + keyPoint + "</li>");
    }

    workExperiencePipe.writeUntilPlaceHolder();
    out.println(description);
    workExperiencePipe.writeUntilPlaceHolder();
    out.println(thoughts);
    workExperiencePipe.writeUntilTheEnd();
  }
}
