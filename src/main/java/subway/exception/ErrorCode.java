package subway.exception;

import subway.view.Prefix;

public enum ErrorCode {
    CANNOT_CHOOSE_OPTION("I001", Prefix.ERROR.getPrefix() + "선택할 수 없는 기능입니다."),

    //InputService
    INVALID_SEQUENCE("In001", Prefix.ERROR.getPrefix() + "순서는 1이상의 자연수 입니다."),

    //Station
    STATION_NAME_LENGTH_ERROR("S001", Prefix.ERROR.getPrefix() + "역 이름은 2글자 이상이어야 합니다."),
    STATION_INVALID_LAST_NAME("S002", Prefix.ERROR.getPrefix() + "마지막 글자에 역이 들어가야합니다."),
    STATION_INVALID_CHARACTER("S003", Prefix.ERROR.getPrefix() + "한글, 숫자만 입력 가능합니다."),
    STATION_ALREADY_EXIST("S004", Prefix.ERROR.getPrefix() + "이미 등록된 지하철 역입니다."),
    STATION_NOT_EXIST("S005", Prefix.ERROR.getPrefix() + "등록된 지하철 역이 없습니다."),
    STATION_NOT_FOUND("S006", Prefix.ERROR.getPrefix() + "입력된 이름으로 등록된 지하철 역이 없습니다."),
    STATION_CONTAIN_LINE("S007", Prefix.ERROR.getPrefix() + "삭제하려는 역이 노선에 포함되어 있습니다."),

    //Line
    LINE_NAME_LENGTH_ERROR("L001", Prefix.ERROR.getPrefix() + "노선 이름은 2글자 이상이어야 합니다."),
    LINE_INVALID_LAST_NAME("L002", Prefix.ERROR.getPrefix() + "마지막 글자에 선이 들어가야합니다."),
    LINE_INVALID_CHARACTER("L003", Prefix.ERROR.getPrefix() + "한글, 숫자만 입력 가능합니다."),
    LINE_ALREADY_EXIST("S004", Prefix.ERROR.getPrefix() + "이미 등록된 지하철 노선입니다."),
    LINE_NOT_EXIST("S005", Prefix.ERROR.getPrefix() + "등록된 노선이 없습니다."),
    LINE_NOT_FOUND("S006", Prefix.ERROR.getPrefix() + "입력된 이름으로 등록된 노선이 없습니다."),

    //Section
    SECTION_UPWARD_STATION_NOT_FOUND("SE001", Prefix.ERROR.getPrefix() + "상행 종점역으로 입력된 이름의 지하철 역이 등록되지 않았습니다."),
    SECTION_DOWNWARD_STATION_NOT_FOUND("SE002", Prefix.ERROR.getPrefix() + "하행 종점역으로 입력된 이름의 지하철 역이 등록되지 않았습니다."),
    SECTION_SAME_STATION_NAME("SE003", Prefix.ERROR.getPrefix() + "상행 좀점역과 하행 종점역의 이름이 같을 수 없습니다."),
    SECTION_NOT_EXIST("SE004", Prefix.ERROR.getPrefix() + "등록된 노선이 없습니다."),
    SECTION_NOT_FOUND("SE005", Prefix.ERROR.getPrefix() + "입력된 이름으로 등록된 노선이 없습니다."),
    SECTION_HAS_STATION("SE006", Prefix.ERROR.getPrefix() + "현재 노선에 추가되어있는 역입니다."),
    SECTION_NOT_HAS_STATION("SE007", Prefix.ERROR.getPrefix() + "현재 노선에 포함되어 있지 않는 역입니다."),
    SECTION_CANNOT_DELETE_STATION("SE008", Prefix.ERROR.getPrefix() + "노선에 등록된 역이 2개 이하라 삭제할 수 없습니다.");

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
