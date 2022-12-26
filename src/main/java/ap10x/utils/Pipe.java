package ap10x.utils;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Pipe {
  public static void fromFileToWriter(String fileName, PrintWriter out) {
    try (
      InputStream inputStream = Res.open(fileName);
      Scanner sc = new Scanner(inputStream, StandardCharsets.UTF_8)
    ) {
      while (sc.hasNextLine()) {
        String line = sc.nextLine();
        out.println(line);
      }
      // note that Scanner suppresses exceptions
      if (sc.ioException() != null) {
        System.out.println(fileName + " sc.ioException()");
      }
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }
}
