package subway.view.component;

public class LineManagementViewComponent {
    private static final String MENU = "## 노선 관리 화면\n" +
            "1. 노선 등록\n" +
            "2. 노선 삭제\n" +
            "3. 노선 조회\n" +
            "B. 돌아가기";
    private static final String FINISH_PREFIX ="[INFO] ";
    private static final String LINE_REGISTER_BEGIN = "## 등록할 노선 이름을 입력하세요.";
    private static final String STATION_REGISTER_START = "## 등록할 노선의 상행 종점역 이름을 입력하세요.";
    private static final String STATION_REGISTER_END = "## 등록할 노선의 하행 종점역 이름을 입력하세요.";
    private static final String LINE_REGISTER_FINISH = "지하철 노선이 등록되었습니다.";
    private static final String LINE_REMOVE_BEGIN = "## 삭제할 노선 이름을 입력하세요.";
    private static final String LINE_REMOVE_FINISH = "지하철 노선이 삭제되었습니다.";
    private static final String SUBWAY_LINE_LIST = "## 노선 목록";

    public static String getMenu() {
        return MENU;
    }

    public static String getLineRegisterBegin() {
        return LINE_REGISTER_BEGIN;
    }

    public static String getStationRegisterStart() {
        return STATION_REGISTER_START;
    }

    public static String getStationRegisterEnd() {
        return STATION_REGISTER_END;
    }

    public static String getLineRegisterFinish() {
        return FINISH_PREFIX + LINE_REGISTER_FINISH;
    }

    public static String getLineRemoveBegin() {
        return LINE_REMOVE_BEGIN;
    }

    public static String getLineRemoveFinish() {
        return FINISH_PREFIX + LINE_REMOVE_FINISH;
    }

    public static String getSubwayLineList() {
        return SUBWAY_LINE_LIST;
    }
}
