package subway.domain;

import java.util.function.Function;

public enum MainFunction implements Functionable {
    STATION("1", "역 관리",
            manageController -> Functionable.function(manageController, StationFunction.values())),
    LINE("2", "노선 관리",
            manageController -> Functionable.function(manageController, LineFunction.values())),
    RANGE("3", "구간 관리",
            manageController -> Functionable.function(manageController, RangeFunction.values())),
    SUBWAY_MAP("4", "지하철 노선도 출력",
            Function.identity()),
    QUIT("Q", "종료",
            null);

    private final String identifier;

    private final String description;

    private final Function<ManageController, ManageController> function;

    MainFunction(String identifier, String description,
                 Function<ManageController, ManageController> function) {
        this.identifier = identifier;
        this.description = description;
        this.function = function;
    }

    @Override
    public Function<ManageController, ManageController> getFunction() {
        return function;
    }

    @Override
    public boolean equalsIdentifier(String identifier) {
        return this.identifier.equals(identifier);
    }
}
