package ap10x.utils;

import ap10x.Settings;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class Res {

  public static InputStream open(String resourcePath) {
    if (!Settings.DEBUG) {
      return Res.class.getClassLoader().getResourceAsStream(resourcePath);
    }
    try {
      return new FileInputStream(System.getenv("AP10X_RES_PATH") + resourcePath);
    } catch (FileNotFoundException e) {
      throw new RuntimeException(e);
    }
  }
}
