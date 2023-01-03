package ap10x.view.resume;

import ap10x.models.Date;
import ap10x.utils.Pipe;
import ap10x.view.RenderComponent;
import ap10x.view.shared.PlaceHolder;

import java.io.PrintWriter;
import java.util.List;

public class ExperienceComponent implements RenderComponent {

  private final String roleTitle;
  private final String organization;
  private final Date startDate;
  private final Date endDate;
  private final List<String> keyPoints;
  private final String description;
  private final String thoughts;

  public ExperienceComponent(
    String roleTitle,
    String organization,
    Date startDate,
    Date endDate,
    List<String> keyPoints,
    String description,
    String thoughts
  ) {
    this.roleTitle = roleTitle;
    this.organization = organization;
    this.startDate = startDate;
    this.endDate = endDate;
    this.keyPoints = keyPoints;
    this.description = description;
    this.thoughts = thoughts;
  }

  private String keyPointsString() {
    StringBuilder sb = new StringBuilder();
    for (String keyPoint : keyPoints) {
      sb.append("<li class=\"exp-key-point-li\">").append(keyPoint).append("</li>\n");
    }
    return sb.toString();
  }

  @Override
  public void render(PrintWriter out) {
    Pipe pipe = new Pipe("templates/resume/experience.html", out);
    PlaceHolder.writeMany(pipe, out,
      roleTitle, organization,
      startDate + " - " + endDate,
      keyPointsString(), description,
      thoughts
    );
    pipe.writeUntilTheEnd();
  }
}
