package subway.exception;

import subway.domain.Station;
import subway.domain.Line;

public enum Error {
    OK("에러가 발생하지 않았습니다."),
    INVALID_COMMAND("선택할 수 없는 기능입니다."),
    INVALID_STATION_NAME_LENGTH("역 이름은 " + Station.getMinimumStationNameLength() + "글자 이상입니다."), 
    INVALID_LINE_NAME_LENGTH("노선 이름은 " + Line.getMinimumLineNameLength() + "글자 이상입니다."),
    INVALID_STATION_REMOVAL("노선에 등록된 역은 삭제할 수 없습니다."),
    DUPLICATE_STATION_NAME("이미 등록된 역 이름입니다."),
    DUPLICATE_LINE_NAME("이미 등록된 노선 이름입니다."),
    NON_EXISTENT_STATION_NAME("존재하지 않는 역 이름입니다."),
    NON_EXISTENT_LINE_NAME("존재하지 않는 노선 이름입니다."),
    SAME_TERMINATING_STATION("하나의 역이 한 노선의 두 개의 종점이 될 수 없습니다."),
    EXISTENT_STATION_IN_LINE("이미 노선에 해당 역이 존재합니다."),
    INVALID_NUMBER_TYPE("순서는 숫자입니다."),
    INVALID_STATION_INDEX("해당 위치에는 구간을 추가할 수 없습니다."),
    NON_EXISTENT_STATION_IN_LINE("노선에 해당 역이 존재하지 않습니다."),
    INVALID_NUMBER_OF_STATION_IN_LINE(
            "노선에는 최소 " + Line.getMinimumStationNumberInLine() + "개의 역이 필요합니다.");

    private static final String ERROR_FORMAT = "[ERROR] %s\n\n";
    private final String message;

    Error(String message) {
        this.message = String.format(ERROR_FORMAT, message);
    }

    public String toString() {
        return message;
    }
}
