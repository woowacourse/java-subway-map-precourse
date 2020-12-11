package subway.view.menu;

import java.util.List;
import java.util.stream.Collectors;

public abstract class Menu {
    protected List<Selection> selections;
    protected String viewName;

    public List<Selection> selections() {
        return selections;
    }

    public List<String> selectionValues() {
        return selections.stream()
                .map(Selection::getValue)
                .collect(Collectors.toList());
    }

    public String getViewName() {
        return viewName;
    }

}
