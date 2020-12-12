package subway;

public enum ActionType {

    INSERT("등록"),
    DELETE("삭제"),
    SELECT("조회"),
    BACK("돌아가기");

    private final String name;

    ActionType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
