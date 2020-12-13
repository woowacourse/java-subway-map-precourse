package subway.type;

public enum  CheckType {
    STATION_CHECK("역"),
    LINE_CHECK("선");

    private final String check;

    CheckType(String check) {
        this.check = check;
    }

    public String getCheck() {
        return check;
    }
}
