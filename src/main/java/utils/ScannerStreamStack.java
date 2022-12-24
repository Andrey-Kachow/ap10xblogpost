package utils;

import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;
import java.util.Stack;

public class ScannerStreamStack implements Closeable {

  private final Stack<Scanner> scanners = new Stack<>();
  private final Stack<InputStream> streams = new Stack<>();

  public void push(InputStream stream) {
    streams.push(stream);
    scanners.push(new Scanner(stream, StandardCharsets.UTF_8));
  }

  public Scanner getCurrent() {
    return scanners.peek();
  }

  private boolean pop() {
    try (Scanner scannerToClose = scanners.pop()) {
      InputStream streamToClose = streams.pop();
      streamToClose.close();
    } catch (IOException e) {
      return false;
    }
  }

  public boolean moveToNext() throws IOException {
    if (!pop()) {
      throw new IOException("Cannot move to next Scanner");
    }
  }

  public boolean nothingToScan() {
    return scanners.empty();
  }

  @Override
  public void close() {
    boolean ok = true;
    while (!scanners.empty()) {
      ok = ok && pop();
    }
    if (!ok) {
      throw new RuntimeException("Scanner Stack failed to close one of the templates");
    }
  }
}
