package subway.domain;

import subway.controller.StationController;

public enum StationActions {
    STATION_ENROLL(DetailActions.ENROLL, StationController::enrollStation),
    STATION_REMOVE(DetailActions.REMOVE, StationController::removeStation),
    STATION_RESEARCH(DetailActions.RESEARCH, StationController::researchStation),
    BACK(DetailActions.BACK, null);

    private final DetailActions detailActions;
    private final Runnable runnable;

    StationActions(DetailActions detailActions, Runnable runnable) {
        this.detailActions = detailActions;
        this.runnable = runnable;
    }

    public static Runnable findAction(DetailActions detailActions) {
        for (StationActions stationActions : StationActions.values()) {
            if (detailActions.equals(stationActions.detailActions)) {
                return stationActions.runnable;
            }
        }
        throw new IllegalArgumentException("옳지 않은 입력입니다.");
    }
}
