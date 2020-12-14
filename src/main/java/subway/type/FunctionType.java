package subway.type;

import java.util.Objects;

public enum FunctionType {
    REGISTER("1", "등록"),
    DELETE("2", "삭제"),
    READ("3", ""),
    BACK("B", "");

    private final String functionNumber;
    private final String message;

    private FunctionType(String functionNumber, String message) {
        this.functionNumber = functionNumber;
        this.message = message;
    }

    public boolean matches(String functionNumber) {
        return Objects.equals(this.functionNumber, functionNumber);
    }

    public String toString() {
        return message;
    }
}
