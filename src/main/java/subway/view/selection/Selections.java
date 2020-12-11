package subway.view.selection;

import java.util.List;

public class Selections {
    private static final String ERROR_NOT_EXIST = "없는 선택지입니다.";

    protected List<Selection> selections;

    public Selections(List<Selection> selections) {
        this.selections = selections;
    }

    public List<Selection> toList() {
        return selections;
    }

    public Selection searchByValue(String value) {
        for (Selection selection : selections) {
            if(selection.getValue().equals(value)) {
                return selection;
            }
        }
        throw new IllegalArgumentException(ERROR_NOT_EXIST);
    }
}
