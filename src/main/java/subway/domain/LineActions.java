package subway.domain;

import subway.controller.LineController;

public enum LineActions {
    LINE_ENROLL(DetailActions.ENROLL, LineController::enrollLine),
    LINE_REMOVE(DetailActions.REMOVE, LineController::removeLine),
    LINE_RESEARCH(DetailActions.RESEARCH, LineController::researchLine),
    BACK(DetailActions.BACK, null);

    private final DetailActions detailActions;
    private final Runnable runnable;

    LineActions(DetailActions detailActions, Runnable runnable) {
        this.detailActions = detailActions;
        this.runnable = runnable;
    }

    public static Runnable findAction(DetailActions detailActions) {
        for (LineActions lineActions : LineActions.values()) {
            if (detailActions.equals(lineActions.detailActions)) {
                return lineActions.runnable;
            }
        }
        throw new IllegalArgumentException("옳지 않은 입력입니다.");
    }
}
