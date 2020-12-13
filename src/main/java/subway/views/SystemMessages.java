package subway.views;

public class SystemMessages {
    public static final String INFO = "[INFO] ";
    public static final String DIVIDE = "---";
    public static final String MAIN_VIEW_MESSAGE = "## 메인 화면";
    public static  String[] MAIN_CONTROL_MESSAGE = {
        "1. 역 관리",
        "2. 노선 관리",
        "3. 구간 관리",
        "4. 지하철 노선도 출력",
        "Q. 종료"
    };
    public static final String SELECT_OPTION_MESSAGE = "## 원하는 기능을 선택하세요.";
    
    public static final String STATION_VIEW_MESSAGE = "## 역 관리 화면";
    public static final String[] STATION_CONTROL_MESSAGE = {
        "1. 역 등록",
        "2. 역 삭제",
        "3. 역 조회",
        "B. 돌아가기"
    };
    public static final String ADD_STATION_MESSAGE = "## 등록할 역 이름을 입력하세요";
    public static final String ADD_STATION_COMPLETE_MESSAGE = "지하철 역이 등록되었습니다.";
    public static final String DEL_STATION_MESSAGE = "## 삭제할 역 이름을 입력하세요.";
    public static final String DEL_STATION_COMPLETE_MESSAGE = "지하철 역이 삭제되었습니다.";
    public static final String STATION_LIST_MESSAGE = "## 역 목록";
    
    public static final String LINE_VIEW_MESSAGE = "## 노선 관리 화면";
    public static final String[] LINE_CONTROL_MESSAGE = {
        "1. 노선 등록",
        "2. 노선 삭제",
        "3. 노선 조회",
        "B. 돌아가기"
    };
    public static final String ADD_LINE_MESSAGE = "## 등록할 노선 이름을 입력하세요.";
    public static final String ADD_UPLINE_STATION_MESSAGE = "## 등록할 노선의 상행 종점역 이름을 입력하세요.";
    public static final String ADD_DOWNLINE_STATION_MESSAGE = "## 등록할 노선의 하행 종점역 이름을 입력하세요.";
    public static final String ADD_LINE_COMPLETE_MESSAGE = "지하철 노선이 등록되었습니다.";
    public static final String DEL_LINE_MESSAGE = "## 삭제할 노선 이름을 입력하세요.";
    public static final String DEL_LINE_COMPLETE_MESSAGE = "지하철 노선이 삭제되었습니다.";
    public static final String LINE_LIST_MESSAGE = "## 노선 목록";

    public static final String SECTION_VIEW_MESSAGE = "## 구간 관리 화면";
    public static final String[] SECTION_CONTROL_MESSAGE = {
            "1. 구간 등록",
            "2. 노선 삭제",
            "B. 돌아가기"
    };
    public static final String ADD_SECTION_LINE_MESSAGE = "## 노선을 입력하세요.";
    public static final String ADD_SECTION_STATION_MESSAGE = "## 역이름을 입력하세요.";
    public static final String ADD_SECTION_ORDER_MESSAGE = "## 순서를 입력하세요.";
    public static final String ADD_SECTION_COMPLETE_MESSAGE = "구간이 등록되었습니다.";
    public static final String DEL_SECTION_LINE_MESSAGE = "## 삭제할 구간의 노선을 입력하세요.";
    public static final String DEL_SECTION_STATION_MESSAGE = "## 삭제할 구간의 역을 입력하세요.";
    public static final String DEL_SECTION_COMPLETE_MESSAGE = "구간이 삭제되었습니다.";

    public static final String SUBWAY_MAP_MESSAGE = "## 지하철 노선도";
}
