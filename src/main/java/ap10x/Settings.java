package ap10x;

public class Settings {
  public static final boolean DEBUG = System.getenv("AP10X_RES_PATH") != null;
  public static final String IMAGES_ROOT = System.getenv("AP10X_IMG_PATH");
}
