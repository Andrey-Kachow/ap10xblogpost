package ap10x.models;

public record Date(int day, int month, int year) {

  private static final int NULL_DAY = -1;
  private static final int NULL_MONTH = -1;
  private static final int NULL_YEAR = -1;

  public boolean isPresent() {
    return day == -1;
  }

  @Override
  public String toString() {
    if (isPresent()) {
      return "Present";
    }
    return day + "/" + month + "/" + year;
  }

  public static Date present() {
    return new Date(NULL_DAY, NULL_MONTH, NULL_YEAR);
  }

  public static Date fromString(String s) {
    s = s.strip();
    if (s.equals("Present")) {
      return Date.present();
    }
    String[] tokens = s.split("/");
    return new Date(
      Integer.parseInt(tokens[0]),
      Integer.parseInt(tokens[1]),
      Integer.parseInt(tokens[2])
    );
  }
}
