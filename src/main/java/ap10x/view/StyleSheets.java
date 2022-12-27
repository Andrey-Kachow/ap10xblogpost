package ap10x.view;

public class StyleSheets extends StaticLoader {
  public StyleSheets(String... styleSheetsPaths) {
    super("style", "static/css/", styleSheetsPaths);
  }
}
