package ap10x.view;

import java.io.PrintWriter;
import java.util.List;

public class CollectionComponent<T extends RenderComponent> implements RenderComponent {

  private final List<T> components;

  public CollectionComponent(List<T> components) {
    this.components = components;
  }

  @Override
  public void render(PrintWriter out) {
    for (RenderComponent component : components) {
      component.render(out);
    }
  }
}
