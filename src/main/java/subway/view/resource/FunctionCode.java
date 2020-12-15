package subway.view.resource;

public enum FunctionCode {
    REGISTER("1"),
    DELETE("2"),
    LOOKUP("3"),
    BACK("B");

    private String index;

    FunctionCode(String index) {
        this.index = index;
    }

    public String getIndex() {
        return index;
    }
}
