package ap10x.utils;

import java.io.PrintWriter;

public class PrintPipeAdapter implements PipeAdapter{

  private final PrintWriter out;

  public PrintPipeAdapter(PrintWriter out) {
    this.out = out;
  }

  @Override
  public void println(String msg) {
    out.println(msg);
  }

  @Override
  public String retrieve() {
    throw new IllegalCallerException("PrintPipeAdapter is not retrievable");
  }
}
