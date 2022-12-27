package ap10x.utils;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Pipe {

  private final InputStream in;
  private final Scanner scanner;
  private final PrintWriter out;

  public Pipe(String fileName, PrintWriter out) {
    this.in = Res.open(fileName);
    this.scanner = new Scanner(this.in, StandardCharsets.UTF_8);
    this.out = out;
  }

  private void writeUntil(boolean untilTheEnd) {
    while (scanner.hasNextLine()) {
      String line = scanner.nextLine();

      if (untilTheEnd && line.trim().equals("{% PLACEHOLDER %}")) {
        return;
      }

      out.println(line);
    }
    scanner.close();
    try {
      in.close();
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

  public void writeUntilPlaceHolder() {
    writeUntil(true);
  }

  public void writeUntilTheEnd() {
    writeUntil(false);
  }

  public static void fromFileToWriter(String fileName, PrintWriter out) {
    new Pipe(fileName, out).writeUntilTheEnd();
  }
}
