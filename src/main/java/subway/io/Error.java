package subway.io;

import subway.domain.Station;

public enum Error {
    INVALID_COMMAND("선택할 수 없는 기능입니다."),
    INVALID_STATION_NAME_LENGTH("역 이름은 " + Station.MINIMUM_NAME_LENGTH
            + "글자 이상입니다."), 
    DUPLICATE_STATION_NAME("이미 등록된 역 이름입니다.");

    private static final String ERROR_FORMAT = "\n[ERROR] %s";

    private final String message;

    Error(String message) {
        this.message = String.format(ERROR_FORMAT, message);
    }

    public String toString() {
        return message;
    }
}
