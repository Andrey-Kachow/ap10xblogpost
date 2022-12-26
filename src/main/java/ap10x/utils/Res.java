package ap10x.utils;

import java.io.File;
import java.io.InputStream;

public class Res {

  public static String get(String resourcePath) {
    try {
      return new File(
        String.valueOf(Res.class.getClassLoader().getResource(resourcePath))
      ).getName();
    } catch (NullPointerException npe) {
      return "#";
    }
  }

  public static InputStream open(String resourcePath) {
    return Res.class.getClassLoader().getResourceAsStream(resourcePath);
  }
}
