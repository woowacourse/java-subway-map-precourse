package subway.view;

public enum Action {
    INSERT("등록"),
    DELETE("삭제"),
    SELECT("조회"),
    BACK("돌아가기"),
    MANAGE("관리"),
    PRINT("출력"),
    EXIT("종료");

    private final String action;

    Action(String action) {
        this.action = action;
    }

    public String getAction() {
        return action;
    }

    @Override
    public String toString() {
        return action;
    }
}
