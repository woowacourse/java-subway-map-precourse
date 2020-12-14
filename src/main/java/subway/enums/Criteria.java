package subway.enums;

public enum Criteria {
    MINIMUM_NAME_LENGTH(2),
    MINIMUM_NUMBER_OF_STATIONS_ON_LINE(2),
    FIRST_PLACE_ON_LINE(0);

    int value = -1;

    Criteria(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
