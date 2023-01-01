package ap10x.view.resume;

import ap10x.models.Date;
import ap10x.utils.Pipe;
import ap10x.view.RenderComponent;
import ap10x.view.shared.PlaceHolder;

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

  private String keyPointsString() {
    StringBuilder sb = new StringBuilder();
    for (String keyPoint : keyPoints) {
      sb.append("<li class=\"wexp-key-point-li\">").append(keyPoint).append("</li>\n");
    }
    return sb.toString();
  }

  @Override
  public void render(PrintWriter out) {
    Pipe pipe = new Pipe("templates/resume/work_experience.html", out);
    PlaceHolder.writeMany(pipe, out,
      roleTitle, company,
      startDate + " - " + endDate,
      keyPointsString(), description,
      thoughts
    );
    pipe.writeUntilTheEnd();
  }
}
