package ap10x.utils;

public class StringSaverPipeAdapter implements PipeAdapter {

  private StringBuilder builder = new StringBuilder();

  @Override
  public void println(String msg) {
    builder.append(msg).append("\n");
  }

  @Override
  public String retrieve() {
    String result = builder.toString();
    builder = new StringBuilder();
    return result;
  }
}
