package ap10x.view.resume;

import ap10x.models.Date;

import java.time.Month;
import java.util.LinkedList;
import java.util.List;

public class WorkExperienceBuilder {

  private String roleTitle = null;
  private String company = null;
  private Date startDate = null;
  private Date endDate = null;
  private final List<String> keyPoints = new LinkedList<>();
  private String description = null;
  private String thoughts = null;

  private WorkExperienceBuilder() {}

  public WorkExperienceBuilder withRole(String roleTitle) {
    this.roleTitle = roleTitle;
    return this;
  }

  public WorkExperienceBuilder withCompany(String company) {
    this.company = company;
    return this;
  }

  public WorkExperienceBuilder workedSince(int day, Month month, int year) {
    this.startDate = new Date(day, month.getValue(), year);
    return this;
  }

  public WorkExperienceBuilder workedSince(String s) {
    this.startDate = Date.fromString(s);
    return this;
  }

  public WorkExperienceBuilder workedUntil(int day, Month month, int year) {
    this.endDate = new Date(day, month.getValue(), year);
    return this;
  }

  public WorkExperienceBuilder workedUntil(String s) {
    this.endDate = Date.fromString(s);
    return this;
  }

  public WorkExperienceBuilder setAsCurrentJob() {
    this.endDate = Date.present();
    return this;
  }

  public WorkExperienceBuilder addJobKeyPoint(String jobKeyPoint) {
    keyPoints.add(jobKeyPoint);
    return this;
  }

  public WorkExperienceBuilder withDescription(String description) {
    this.description = description;
    return this;
  }

  public WorkExperienceBuilder withThoughts(String thoughts) {
    this.thoughts = thoughts;
    return this;
  }

  public WorkExperienceComponent build() {
    return new WorkExperienceComponent(
      roleTitle, company, startDate, endDate,
      keyPoints, description, thoughts
    );
  }

  public static WorkExperienceBuilder create() {
    return new WorkExperienceBuilder();
  }
}
