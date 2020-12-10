package subway;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public enum CategoryType {

    STATION(
        "역",
        Arrays.asList(ActionType.INSERT, ActionType.DELETE, ActionType.SELECT)),
    LINE(
        "노선",
        Arrays.asList(ActionType.INSERT, ActionType.DELETE, ActionType.SELECT)),
    SECTION(
        "구간",
        Arrays.asList(ActionType.INSERT, ActionType.DELETE)),
    PRINT(
        "지하철 노선도",
        Collections.emptyList()),
    EXIT(
        "종료",
        Collections.emptyList());

    private final String name;
    private final List<ActionType> actionOrder;

    CategoryType(String name, List<ActionType> actionOrder) {
        this.name = name;
        this.actionOrder = actionOrder;
    }

    public String getName() {
        return name;
    }

    public List<ActionType> getActionOrder() {
        return actionOrder;
    }
}
