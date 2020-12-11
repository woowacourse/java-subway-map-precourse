package subway.exception;

import subway.service.output.OutputService;
import subway.view.Screen;

public enum ErrorCode {
    CANNOT_CHOOSE_OPTION("I001", Screen.PREFIX_ERROR + "선택할 수 없는 기능입니다."),

    //Station
    STATION_NAME_LENGTH_ERROR("S001", Screen.PREFIX_ERROR + "역 이름은 2글자 이상이어야 합니다."),
    STATION_INVALID_LAST_NAME("S002", Screen.PREFIX_ERROR + "마지막 글자에 역이 들어가야합니다."),
    STATION_INVALID_CHARACTER("S003", Screen.PREFIX_ERROR + "한글, 숫자만 입력 가능합니다."),
    STATION_ALREADY_EXIST("S004", Screen.PREFIX_ERROR + "이미 등록된 지하철 역입니다."),
    STATION_NOT_EXIST("S005", Screen.PREFIX_ERROR + "등록된 지하철 역이 없습니다.");

    private final String code;
    private final String message;

    ErrorCode(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
