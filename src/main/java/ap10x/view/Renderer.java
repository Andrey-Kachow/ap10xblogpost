package ap10x.view;

import utils.Res;
import utils.ScannerStreamStack;

import java.io.IOException;
import java.io.PrintWriter;

public class Renderer {

  private final PrintWriter out;
  private final ScannerStreamStack scan = new ScannerStreamStack();

  public Renderer(PrintWriter writer) {
    this.out = writer;
  }

  public void render(String templateName) {
    scan.push(Res.openTemplate(templateName));
    try (scan) {
      while (true) {
        while (!scan.getCurrent().hasNextLine()) {
          scan.moveToNext();
        }
        if (scan.nothingToScan()) {
          return;
        }
        String line = scan.getCurrent().nextLine();
        // TODO: 24/12/2022 Implement preprocessing and scanner stack push delegation 
      }
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }
}
