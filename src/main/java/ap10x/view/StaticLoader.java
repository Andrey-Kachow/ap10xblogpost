package ap10x.view;

import ap10x.utils.Pipe;

import java.io.PrintWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public abstract class StaticLoader implements RenderComponent {

  private final List<String> staticFiles;
  private final String tagName;
  private final String staticRoot;

  StaticLoader(String tagName, String staticRoot, String... staticPths) {
    this.tagName = tagName;
    this.staticRoot = staticRoot;
    this.staticFiles = new LinkedList<>(Arrays.asList(staticPths));
  }

  public void attach(String scriptPath) {
    staticFiles.add(scriptPath);
  }

  @Override
  public void render(PrintWriter out) {
    out.println("<" + tagName + ">");
    for (String script : staticFiles) {
      Pipe.writeFromFileToWriter(staticRoot + script, out);
    }
    out.println("</" + tagName + ">");
  }
}
