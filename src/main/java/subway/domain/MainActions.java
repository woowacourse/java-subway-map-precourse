package subway.domain;

import subway.controller.LineController;
import subway.controller.StationController;
import subway.controller.WayController;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;

public enum MainActions {
    STATION("1", "역", StationController::doAction),
    LINE("2", "노선", LineController::doAction),
    WAY("3", "구간", WayController::doAction),
    SUBWAY("4", "지하철 노선도", null),
    FINISH("Q", "종료", null);

    private final String actionNumber;
    private final String actionName;
    public final Function<DetailActions, Boolean> act;

    MainActions(String actionNumber, String actionName, Function<DetailActions, Boolean> act) {
        this.actionName = actionName;
        this.actionNumber = actionNumber;
        this.act = act;
    }

    public static MainActions haveNumber(String inputNumber) {
        for (MainActions mainActions : MainActions.values()) {
            if (mainActions.actionNumber.equals(inputNumber)) {
                return mainActions;
            }
        }
        throw new IllegalArgumentException("선택할 수 없는 기능입니다.");
    }

    public String getActionName() {
        return actionName;
    }

    public String getActionNumber() {
        return actionNumber;
    }

    public static List<String> getObjectsToString(MainActions mainActions) {
        if (mainActions.equals(STATION)) {
            return StationRepository.getStationsWithFormatting();
        }
        if (mainActions.equals(LINE)) {
            return LineRepository.getLinesWithFormatting();
        }
        return null;
    }
}
