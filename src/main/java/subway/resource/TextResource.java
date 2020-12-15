package subway.resource;


import static subway.domain.Line.MIN_LINE_NAME_LENGTH;
import static subway.domain.Station.MIN_STATION_NAME_LENGTH;

public class TextResource {

    public static final String PREFIX_ERROR = "\n[ERROR]";
    public static final String PREFIX_INFO = "[INFO]";
    public static final String PREFIX_INFO_LINE = "\n[INFO]";

    public static final String ERROR_STATION_NAME_LENGTH
        = String.format(PREFIX_ERROR + "지하철역의 이름은 %d 글자 이상이어야 합니다.",
        MIN_STATION_NAME_LENGTH);

    public static final String ERROR_STATION_NAME_DUPLICATED = PREFIX_ERROR
        + "이미 해당 지하철역이 존재 합니다. 등록 할 수 없습니다.";

    public static final String ERROR_LINE_NAME_LENGTH
        = String.format(PREFIX_ERROR + "노선의 이름은 %d 글자 이상이어야 합니다.",
        MIN_LINE_NAME_LENGTH);

    public static final String ERROR_DELETE_STATION_IN_LINE = PREFIX_ERROR
        + "노선에 등록된 역은 삭제 할 수 없습니다.";


    public static final String ERROR_NOT_EXISTENCE_STATION = PREFIX_ERROR
        + "등록하려는 역이 존재 하지 않습니다.";

    public static final String ERROR_START_END_STATION_DUPLICATED = PREFIX_ERROR
        + "상행 종점역과 하행 종점역이 같을 수 없습니다.";

    public static final String ERROR_LINE_NAME_DUPLICATED = PREFIX_ERROR
        + "이미 해당 노선이 존재 합니다. 등록 할 수 없습니다.";

    public static final String ERROR_LINE_NOT_EXISTENCE = PREFIX_ERROR
        + "해당 노선이 존재하지 않습니다.";

    public static final String ERROR_INVALID_FUNCTION = PREFIX_ERROR
        + "선택할 수 없는 기능입니다.";

    public static final String ERROR_STATION_DUPLICATED_IN_SECTION = PREFIX_ERROR
        + "해당 노선의 구간에 입력한 역이 이미 존재 합니다.";

    public static final String ERROR_SECTIONS_POSITION_NOT_VALID = PREFIX_ERROR
        + "입력한 순서가 올바르지 않습니다.";

    public static final String ERROR_STATION_NOT_IN_SECTION = PREFIX_ERROR
        + "해당 노선의 구간에 입력한 역이 존재 하지 않습니다.";

    public static final String ERROR_SECTIONS_SIZE_UNDER_TWO = PREFIX_ERROR
        + "노선에 포함된 역이 두개 이하일 때는 역을 제거할 수 없습니다.";

    public static String HEADER_MAIN_VIEW = "\n## 메인 화면";
    public static String HEADER_STATION_MANAGEMENT_VIEW = "\n## 역 관리 화면";
    public static String HEADER_LINE_MANAGEMENT_VIEW = "\n## 노선 관리 화면";
    public static String HEADER_SECTION_MANAGEMENT_VIEW = "\n## 구간 관리 화면";
    public static String HEADER_ROUTE_MAP_PRINT_VIEW = "\n## 지하철 노선도";
    public static String HEADER_STATION_LIST = "\n## 역 목록";
    public static String HEADER_LINE_LIST = "\n## 노선 목록";

    public static String FUNCTION_STATION_MANAGEMENT = "역 관리";
    public static String FUNCTION_LINE_MANAGEMENT = "노선 관리";
    public static String FUNCTION_SECTION_MANAGEMENT = "구간 관리";
    public static String FUNCTION_ROUTE_MAP_PRINT = "지하철 노선도 출력";

    public static String FUNCTION_STATION_ADD = "역 등록";
    public static String FUNCTION_STATION_DELETE = "역 삭제";
    public static String FUNCTION_STATION_LIST_SHOW = "역 조회";

    public static String FUNCTION_LINE_ADD = "노선 등록";
    public static String FUNCTION_LINE_DELETE = "노선 삭제";
    public static String FUNCTION_LINE_LIST_SHOW = "노선 조회";

    public static String FUNCTION_SECTION_ADD = "구간 등록";
    public static String FUNCTION_SECTION_DELETE = "구간 삭제";

    public static String FUNCTION_QUIT = "종료";
    public static String FUNCTION_BACK = "돌아가기";

    public static String ASK_FUNCTION = "\n## 원하는 기능을 선택하세요.";
    public static String ASK_ADD_STATION_NAME = "\n## 등록할 역 이름을 입력하세요.";
    public static String ASK_DELETE_STATION_NAME = "\n## 삭제할 역 이름을 입력하세요.";

    public static String ASK_ADD_LINE_NAME = "\n## 등록할 노선 이름을 입력하세요.";
    public static String ASK_ADD_LINE_START = "\n## 등록할 노선의 상행 종점역 이름을 입력하세요.";
    public static String ASK_ADD_LINE_END = "\n## 등록할 노선의 하행 종점역 이름을 입력하세요.";
    public static String ASK_DELETE_LINE_NAME = "\n## 삭제할 노선 이름을 입력하세요.";


    public static String ASK_LINE_NAME_WHEN_ADD_SECTION = "\n## 노선을 입력하세요.";
    public static String ASK_STATION_NAME_WHEN_ADD_SECTION = "\n## 역이름을 입력하세요.";
    public static String ASK_ORDER_WHEN_ADD_SECTION = "\n## 순서를 입력하세요.";
    public static String ASK_LINE_NAME_WHEN_DELETE_SECTION = "\n## 삭제할 구간의 노선을 입력하세요.";
    public static String ASK_STATION_NAME_WHEN_DELETE_SECTION = "\n## 삭제할 구간의 역을 입력하세요.";

    public static String COMPLETE_STATION_ADD = PREFIX_INFO_LINE + " 지하철 역이 등록되었습니다.";
    public static String COMPLETE_STATION_DELETE = PREFIX_INFO_LINE + " 지하철 역이 삭제되었습니다.";

    public static String COMPLETE_LINE_ADD = PREFIX_INFO_LINE + " 지하철 노선이 등록되었습니다.";
    public static String COMPLETE_LINE_DELETE = PREFIX_INFO_LINE + " 지하철 노선이 삭제되었습니다.";

    public static String COMPLETE_SECTION_ADD = PREFIX_INFO_LINE + " 구간이 등록되었습니다.";
    public static String COMPLETE_SECTION_DELETE = PREFIX_INFO_LINE + " 구간이 삭제되었습니다.";


}
