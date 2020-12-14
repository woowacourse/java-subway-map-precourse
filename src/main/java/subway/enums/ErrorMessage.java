package subway.enums;

public enum ErrorMessage {
    ERROR("[ERROR] "),

    STATION_DUPLICATION(ERROR.getMessage() + "이미 등록된 역 이름입니다."),
    STATION_NAME_LENGTH_UNDER_2(ERROR.getMessage() + "역 이름은 2자부터 등록 가능합니다."),
    STATION_NOT_EXIST(ERROR.getMessage() + "등록된 역이 없습니다."),

    LINE_DUPLICATION(ERROR.getMessage() + "이미 등록된 노선 이름입니다."),
    LINE_NAME_LENGTH_UNDER_2(ERROR.getMessage() + "노선 이름은 2자부터 등록 가능합니다."),
    LAST_UP_AND_DOWN_STATION_DUPLICATION(ERROR.getMessage() + "상행 종점역과 중복됩니다."),
    LINE_NOT_EXIST(ERROR.getMessage() + "등록된 노선이 없습니다."),

    STATION_UNDER_2_ON_LINE(ERROR.getMessage() + "노선에 역이 두개 이하일 때는 역을 삭제할 수 없습니다."),
    STATION_ON_LINE(ERROR.getMessage() + "역이 노선에 등록되어 있어 삭제할 수 없습니다."),
    POSITION_NOT_NUMBER_FORMAT(ERROR.getMessage() + "위치는 숫자만 가능합니다."),
    SAME_OR_REVERSE_ORDER_OF_STATIONS_EXISTS(ERROR.getMessage() + "역들의 배열이 똑같은 노선이 존재합니다."),

    NO_MENU(ERROR.getMessage() + "선택할 수 없는 기능입니다.");

    String message = "";

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
