package ap10x.view.resume;

import ap10x.utils.Pipe;

import java.util.LinkedList;
import java.util.List;

public class ExperienceProvider {

  public static List<ExperienceComponent> fromTextData(String filePath) {
    List<ExperienceComponent> components = new LinkedList<>();
    Pipe pipe = Pipe.fromPipeToString(filePath);
    while (!pipe.isClosed()) {
      ExperienceBuilder workBuilder = ExperienceBuilder.create();
      pipe.writeUntilPlaceHolder("-");
      workBuilder = workBuilder.withRole(pipe.retreiveWritten());
      pipe.writeUntilPlaceHolder("-");
      workBuilder = workBuilder.withOrganization(pipe.retreiveWritten());
      pipe.writeUntilPlaceHolder("-");
      workBuilder = workBuilder.workedSince(pipe.retreiveWritten());
      pipe.writeUntilPlaceHolder("-");
      workBuilder = workBuilder.workedUntil(pipe.retreiveWritten());
      pipe.writeUntilPlaceHolder("-");
      for (String keyPoint : pipe.retreiveWritten().split("\n")) {
        workBuilder.addKeyPoint(keyPoint);
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
