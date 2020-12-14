package subway.controller.enums;

public enum ActionType {
    ADD("1"),
    DELETE("2"),
    PRINT("3");

    private String action;

    ActionType(String action) {
        this.action = action;
    }

    public String getAction() {
        return action;
    }
}