package subway.constant;

public enum BoundaryCheckDigit {
    STATION_ADD_LIMIT_MINIMUM(2),
    STATION_LIST_LIMIT_MINIMUM(1),
    LINE_LIST_LIMIT_MINIMUM(1),
    LIST_GET_FIRST(0),
    LINE_ADD_LIMIT(2),
    ;



    private final int digit;

    BoundaryCheckDigit(int digit) {
        this.digit = digit;
    }

    public int getBoundaryCheckDigit() {
        return this.digit;
    }
}
