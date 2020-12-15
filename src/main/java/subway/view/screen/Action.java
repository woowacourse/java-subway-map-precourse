package subway.view.screen;

public enum Action {
    INSERT("등록", 1),
    DELETE("삭제", 2),
    SELECT("조회", 3),
    BACK("돌아가기", 0),
    MANAGE("관리", 0),
    PRINT("출력", 0),
    EXIT("종료", 0);

    private final String action;
    private final int actionNumber;

    Action(String action, int actionNumber) {
        this.action = action;
        this.actionNumber = actionNumber;
    }

    public String getAction() {
        return action;
    }

    public int getActionNumber() {
        return actionNumber;
    }

    @Override
    public String toString() {
        return action;
    }
}
