package subway.domain.type;

public enum FunctionType {
    REGISTER("1"),
    DELETE("2"),
    READ("3"),
    BACK("B");

    private final String functionNumber;

    private FunctionType(String functionNumber) {
        this.functionNumber = functionNumber;
    }

    public boolean matches(String functionNumber) {
        return this.functionNumber.equals(functionNumber);
    }
}
