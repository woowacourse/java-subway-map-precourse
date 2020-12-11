package subway.view.selection;

import java.util.List;
import java.util.stream.Collectors;

public class Selections {
    protected List<Selection> selections;

    public Selections(List<Selection> selections) {
        this.selections = selections;
    }

    public List<Selection> toList() {
        return selections;
    }

    public List<String> values() {
        return selections.stream()
                .map(Selection::getValue)
                .collect(Collectors.toList());
    }
}
