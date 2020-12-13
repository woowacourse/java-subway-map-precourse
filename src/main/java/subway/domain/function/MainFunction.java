package subway.domain.function;

import java.util.function.Function;

import subway.controller.ManagementController;

public enum MainFunction implements Functionable {
    STATION("1", StationFunction.TITLE,
            managementController -> Functionable
                    .function(managementController, StationFunction.TITLE, StationFunction.values())),

    LINE("2", LineFunction.TITLE,
            managementController -> Functionable
                    .function(managementController, LineFunction.TITLE, LineFunction.values())),

    RANGE("3", RangeFunction.TITLE,
            managementController -> Functionable
                    .function(managementController, RangeFunction.TITLE, RangeFunction.values())),

    SUBWAY_MAP("4", "지하철 노선도 출력", ManagementController::loadSubwayMap),

    QUIT("Q", "종료", mainController -> null);

    public static final String TITLE = "메인";

    private final String identifier;

    private final String description;

    private final Function<ManagementController, ManagementController> function;

    MainFunction(final String identifier, final String description,
                 final Function<ManagementController, ManagementController> function) {
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
    public Function<ManagementController, ManagementController> getFunction() {
        return function;
    }

    @Override
    public boolean equalsIdentifier(String identifier) {
        return this.identifier.equals(identifier);
    }
}
