package subway.constant;

public enum BoundaryCheckDigit {
    STATION_ADD_LIMIT_MINIMUM(2),
    STATION_LIST_LIMIT_MINIMUM(1),
    LIST_GET_FIRST(0),
    ;


    private final int digit;

    BoundaryCheckDigit(int digit) {
        this.digit = digit;
    }

    public int getBoundaryCheckDigit() {
        return this.digit;
    }
}
