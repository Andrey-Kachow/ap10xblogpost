package ap10x.view.resume;

import ap10x.models.Date;

import java.util.LinkedList;
import java.util.List;

public class ExperienceBuilder {

  private String roleTitle = null;
  private String organization = null;
  private Date startDate = null;
  private Date endDate = null;
  private final List<String> keyPoints = new LinkedList<>();
  private String description = null;
  private String thoughts = null;

  private ExperienceBuilder() {}

  public ExperienceBuilder withRole(String roleTitle) {
    this.roleTitle = roleTitle;
    return this;
  }

  public ExperienceBuilder withOrganization(String company) {
    this.organization = company;
    return this;
  }

  public ExperienceBuilder workedSince(String s) {
    this.startDate = Date.fromString(s);
    return this;
  }

  public ExperienceBuilder workedUntil(String s) {
    this.endDate = Date.fromString(s);
    return this;
  }

  public void addKeyPoint(String jobKeyPoint) {
    keyPoints.add(jobKeyPoint);
  }

  public ExperienceBuilder withDescription(String description) {
    this.description = description;
    return this;
  }

  public ExperienceBuilder withThoughts(String thoughts) {
    this.thoughts = thoughts;
    return this;
  }

  public ExperienceComponent build() {
    return new ExperienceComponent(
      roleTitle, organization, startDate, endDate,
      keyPoints, description, thoughts
    );
  }

  public static ExperienceBuilder create() {
    return new ExperienceBuilder();
  }
}
