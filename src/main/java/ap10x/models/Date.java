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
      return "Now";
    }
    return day + "/" + month + "/" + year;
  }

  public static Date present() {
    return new Date(NULL_DAY, NULL_MONTH, NULL_YEAR);
  }
}
