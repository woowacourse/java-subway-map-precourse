package subway.exception;

import subway.view.Screen;

public enum ErrorCode {
    CANNOT_CHOOSE_OPTION("I001", Screen.PREFIX_ERROR + "선택할 수 없는 기능입니다."),

    //InputService
    INVALID_SEQUENCE("In001", Screen.PREFIX_ERROR + "순서는 1이상의 자연수 입니다."),

    //Station
    STATION_NAME_LENGTH_ERROR("S001", Screen.PREFIX_ERROR + "역 이름은 2글자 이상이어야 합니다."),
    STATION_INVALID_LAST_NAME("S002", Screen.PREFIX_ERROR + "마지막 글자에 역이 들어가야합니다."),
    STATION_INVALID_CHARACTER("S003", Screen.PREFIX_ERROR + "한글, 숫자만 입력 가능합니다."),
    STATION_ALREADY_EXIST("S004", Screen.PREFIX_ERROR + "이미 등록된 지하철 역입니다."),
    STATION_NOT_EXIST("S005", Screen.PREFIX_ERROR + "등록된 지하철 역이 없습니다."),
    STATION_NOT_FOUND("S006", Screen.PREFIX_ERROR + "입력된 이름으로 등록된 지하철 역이 없습니다."),
    STATION_IN_LINE("S007", Screen.PREFIX_ERROR + "삭제하려는 역이 노선에 포함되어 있습니다."),

    //Line
    LINE_NAME_LENGTH_ERROR("L001", Screen.PREFIX_ERROR + "노선 이름은 2글자 이상이어야 합니다."),
    LINE_INVALID_LAST_NAME("L002", Screen.PREFIX_ERROR + "마지막 글자에 선이 들어가야합니다."),
    LINE_INVALID_CHARACTER("L003", Screen.PREFIX_ERROR + "한글, 숫자만 입력 가능합니다."),
    LINE_ALREADY_EXIST("S004", Screen.PREFIX_ERROR + "이미 등록된 지하철 노선입니다."),
    LINE_NOT_FOUND_NAME("S005", Screen.PREFIX_ERROR + "등록되지 않은 노선 이름입니다."),
    LINE_NOT_EXIST("S006", Screen.PREFIX_ERROR + "등록된 노선이 없습니다."),

    //Section
    SECTION_UPWARD_STATION_NOT_FOUND("SE001", Screen.PREFIX_ERROR + "상행 종점역으로 입력된 이름의 지하철 역이 등록되지 않았습니다."),
    SECTION_DOWNWARD_STATION_NOT_FOUND("SE002", Screen.PREFIX_ERROR + "하행 종점역으로 입력된 이름의 지하철 역이 등록되지 않았습니다."),
    SECTION_SAME_STATION_NAME("SE003", Screen.PREFIX_ERROR + "상행 좀점역과 하행 종점역의 이름이 같을 수 없습니다."),
    SECTION_NOT_EXIST("SE004", Screen.PREFIX_ERROR + "등록되지 않은 노선 이름입니다.");


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
