package ap10x.utils;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Pipe {

  private final InputStream in;
  private final Scanner scanner;
  private final PipeAdapter out;
  private boolean scannerIsClosed = false;

  private Pipe(String fileName, PipeAdapter out) {
    this.in = Res.open(fileName);
    this.scanner = new Scanner(this.in, StandardCharsets.UTF_8);
    this.out = out;
  }

  public Pipe(String fileName, PrintWriter pw) {
    this(fileName, new PrintPipeAdapter(pw));
  }

  private void writeUntil(boolean untilTheEnd, String placeholder) {
    while (scanner.hasNextLine()) {
      String line = scanner.nextLine();

      if (untilTheEnd && line.trim().equals(placeholder)) {
        return;
      }

      out.println(line);
    }
    scannerIsClosed = true;
    scanner.close();
    try {
      in.close();
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

  public void writeUntilPlaceHolder() {
    writeUntil(true, "{% PLACEHOLDER %}");
  }

  public void writeUntilPlaceHolder(String placeholder) {
    writeUntil(true, placeholder);
  }

  public void writeUntilTheEnd() {
    writeUntil(false, null);
  }

  public String retreiveWritten() {
    return out.retrieve();
  }

  public boolean isClosed() {
    return scannerIsClosed;
  }

  public static void writeFromFileToWriter(String fileName, PrintWriter out) {
    new Pipe(fileName, new PrintPipeAdapter(out)).writeUntilTheEnd();
  }

  public static Pipe fromPipeToString(String fileName) {
    return new Pipe(fileName, new StringSaverPipeAdapter());
  }
}
