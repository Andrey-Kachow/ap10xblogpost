package utils;

import java.io.InputStream;

public class Res {

  public static InputStream open(String resourcePath) {
    return Res.class.getClassLoader().getResourceAsStream(resourcePath);
  }

  public static InputStream openTemplate(String templatePath) {
    return open("templates/" + templatePath);
  }
}
