package subway.domain;

public enum DetailActions {
    ENROLL("1", "등록"),
    REMOVE("2", "삭제"),
    RESEARCH("3", "조회"),
    BACK("B", "돌아가기");

    private final String actionNumber;
    private final String actionName;

    DetailActions(String actionNumber, String actionName) {
        this.actionName = actionName;
        this.actionNumber = actionNumber;
    }

    public static DetailActions haveNumber(String inputNumber, MainActions mainActions) {
        for (DetailActions detailActions : DetailActions.values()) {
            if (mainActions.equals(MainActions.WAY) && inputNumber.equals(RESEARCH.actionNumber)) {
                break;
            }
            if (detailActions.actionNumber.equals(inputNumber)) {
                return detailActions;
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
}
