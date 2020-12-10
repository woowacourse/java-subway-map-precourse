package subway.view.menu;

import java.util.ArrayList;
import java.util.List;

public abstract class Menu{
    protected List<String> menu = new ArrayList<>();
    protected List<String> menuSelections = new ArrayList<>();
    protected String viewName;

    public abstract List<String> getMenu();
    public abstract List<String> getMenuSelections();
    public String getViewName() {
        return viewName;
    };
}
