package ap10x.view.resume;

import ap10x.view.*;

import java.io.PrintWriter;
import java.time.Month;

public class ResumePage implements RenderComponent {
  @Override
  public void render(PrintWriter out) {
    BasePage.with(
      "Test",
      new StyleSheets("index.css"),
      new Scripts(),
      WorkExperienceBuilder.create()
        .withRole("Undergraduate Teaching Assistant")
        .withCompany("Imperial College London")
        .workedSince(29, Month.SEPTEMBER, 2022)
        .setAsCurrentJob()
        .addJobKeyPoint(
          "Worked as a Personal Programming Tutor / Undergraduate Teaching Assistant"
        )
        .addJobKeyPoint(
          "Tutored Java, Kotlin and Haskell for the assigned group of first year students"
        )
        .addJobKeyPoint(
          "Conducted Question-Answer seminars and revision sessions"
        )
        .addJobKeyPoint(
          "Reviewed students’ work and provided constructive feedback"
        )
        .withDescription("""
          First class second and third Year students may be hired as Undergraduate Teaching Assistants (UTAs).
          UTAs assist the first year teaching during the autumn and spring terms.
          PPT UTA Responsible for marking the weekly programming labs and running the tutorial sessions for a PPT group.
          """.stripIndent())
        .withThoughts("""
          During this job I learned how to confidently speak in front of ten people.
          I also improved my programming and communication skills.
          Marking the lab codes taught me to read other people's code carefully.
          The students assigned to me were nice people and overall I am happy with the experience.
          """.stripIndent())
        .build()
    ).render(out);
  }
}
