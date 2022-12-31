package ap10x.view.resume;

import ap10x.utils.Pipe;

import java.util.LinkedList;
import java.util.List;

public class WorkExperienceProvider {
  public static List<WorkExperienceComponent> fromTextData() {
    List<WorkExperienceComponent> components = new LinkedList<>();
    Pipe pipe = Pipe.fromPipeToString("templates/resume/work_experiences.txt");
    while (!pipe.isClosed()) {
      WorkExperienceBuilder workBuilder = WorkExperienceBuilder.create();
      pipe.writeUntilPlaceHolder("-");
      workBuilder = workBuilder.withRole(pipe.retreiveWritten());
      pipe.writeUntilPlaceHolder("-");
      workBuilder = workBuilder.withCompany(pipe.retreiveWritten());
      pipe.writeUntilPlaceHolder("-");
      workBuilder = workBuilder.workedSince(pipe.retreiveWritten());
      pipe.writeUntilPlaceHolder("-");
      workBuilder = workBuilder.workedUntil(pipe.retreiveWritten());
      pipe.writeUntilPlaceHolder("-");
      for (String keyPoint : pipe.retreiveWritten().split("\n")) {
        workBuilder.addJobKeyPoint(keyPoint);
      }
      pipe.writeUntilPlaceHolder("-");
      workBuilder = workBuilder.withDescription(pipe.retreiveWritten());
      pipe.writeUntilPlaceHolder("%");
      workBuilder = workBuilder.withThoughts(pipe.retreiveWritten());
      components.add(workBuilder.build());
    }
    return components;
  }
}
