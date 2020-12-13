package subway.screen;

public enum ActionType {
    MANAGE("관리"),
    PRINT("출력"),
    REGISTER("등록"),
    DELETE("삭제"),
    SHOW("조회"),
    MOVE_BACK("돌아가기"),
    EXIT("나가기");
    
    private String action;
    
    ActionType(String action) {
        this.action = action;
    }
    
    public String toString() {
        return action;
    }
}
