package subway.domain;

import java.util.function.Function;

public enum MainFunction implements Functionable {
    STATION("1", StationFunction.TITLE,
            manageController -> Functionable
                    .function(manageController, StationFunction.TITLE, StationFunction.values())),
    LINE("2", LineFunction.TITLE,
            manageController -> Functionable
                    .function(manageController, LineFunction.TITLE, LineFunction.values())),
    RANGE("3", RangeFunction.TITLE,
            manageController -> Functionable
                    .function(manageController, RangeFunction.TITLE, RangeFunction.values())),
    SUBWAY_MAP("4", "지하철 노선도 출력",
            Function.identity()),
    QUIT("Q", "종료",
            null);

    public static final String TITLE = "메인";

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
    public String getIdentifier() {
        return identifier;
    }

    @Override
    public String getDescription() {
        return description;
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
