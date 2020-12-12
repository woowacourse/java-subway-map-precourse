package subway.view;

import java.util.LinkedHashMap;
import java.util.Map;

public class ViewsContainer {
    private static final String NAVIGATION_FORM = "%s. %s\n";
    private final Map<String, ViewStrategy> views;

    private ViewsContainer(Map<String, ViewStrategy> views) {
        this.views = views;
    }

    public static ViewsContainer newInstance() {
        return new ViewsContainer(new LinkedHashMap<>());
    }

    public void add(String key, ViewStrategy view) {
        views.put(key, view);
    }

    public String navigate() {
        StringBuilder sb = new StringBuilder();
        views.forEach((key, value) -> sb.append(String.format(NAVIGATION_FORM, key, value)));
        return sb.toString();
    }

    public ViewStrategy getView(String key) {
        return views.get(key);
    }
}
