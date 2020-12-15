package subway.domain.menu.constant;

public class ExceptionMessage {
    public static final String NOT_ACCPTED_INPUT_MESSAGE = "선택할 수 없는 기능입니다.";
    public static final String NOT_ACCPTED_INPUT_LENGTH_MESSAGE = "2글자 이상 입력해 주세요.";
    public static final String DUPLICATED_INPUT_STATION = "이미 등록된 역 이름입니다.";
    public static final String DUPLICATED_INPUT_LINE = "이미 등록된 노선 이름입니다.";
    public static final String DUPLICATED_STATION_IN_LINE = "노선에 등록된 역은 삭제할 수 없습니다.";
    public static final String NOT_ACCPTED_DELETE_INPUT_MESSAGE = "삭제하려는 입력값이 존재하지 않습니다.";
    public static final String NOT_REGISTERED_STATION = "역 리스트에 등록되어있는 역을 입력해야 합니다.";
    public static final String NOT_REGISTERED_LINE = "노선 리스트에 등록되어있는 노선을 입력해야 합니다.";
    public static final String TERMINAL_STATION_NAME_EQUAL = "상행 종점역과 하행 종점역의 이름은 달라야 합니다.";
    public static final String NOT_ACCPTED_SECTION_STATION_INPUT = "현재 노선에 없는 역을 입력해야 합니다.";
    public static final String NOT_ACCPTED_SECTION_ORDER_INPUT = "1 이상의 정수를 입력해야 합니다.";
    public static final String EXCESS_SECTION_ORDER_INPUT = "종점역 위치 이하의 정수를 입력해야 합니다.";
}
