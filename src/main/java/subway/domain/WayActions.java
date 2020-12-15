package subway.domain;

import subway.controller.WayController;

public enum WayActions {
    WAY_ENROLL(DetailActions.ENROLL, WayController::enrollWay),
    WAY_REMOVE(DetailActions.REMOVE, WayController::removeWay),
    BACK(DetailActions.BACK, null);

    private final DetailActions detailActions;
    private final Runnable runnable;

    WayActions(DetailActions detailActions, Runnable runnable) {
        this.detailActions = detailActions;
        this.runnable = runnable;
    }

    public static Runnable findAction(DetailActions detailActions) {
        for (WayActions wayActions : WayActions.values()) {
            if (detailActions.equals(wayActions.detailActions)) {
                return wayActions.runnable;
            }
        }
        throw new IllegalArgumentException("옳지 않은 입력입니다.");
    }

}
