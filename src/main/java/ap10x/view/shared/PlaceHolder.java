package ap10x.view.shared;

import ap10x.utils.Pipe;
import ap10x.view.RenderComponent;

import java.io.PrintWriter;

public class PlaceHolder {

  public static void writeAndRender(Pipe pipe, PrintWriter out, RenderComponent component) {
    pipe.writeUntilPlaceHolder();
    component.render(out);
  }

  public static void writeAndPrint(Pipe pipe, PrintWriter out, Object msg) {
    pipe.writeUntilPlaceHolder();
    out.println(msg.toString());
  }

  public static void writeMany(Pipe pipe, PrintWriter out, Object... things) {
    for (Object thing : things) {
      if (thing instanceof RenderComponent) {
        writeAndRender(pipe, out, (RenderComponent) thing);
      } else {
        writeAndPrint(pipe, out, thing);
      }
    }
  }
}
