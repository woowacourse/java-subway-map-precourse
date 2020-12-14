package subway.view.component;

public class StationManagementViewComponent {
    private static final String MENU = "## 역 관리 화면\n" +
            "1. 역 등록\n" +
            "2. 역 삭제\n" +
            "3. 역 조회\n" +
            "B. 돌아가기";
    private static final String FINISH_PREFIX ="[INFO] ";
    private static final String STATION_REGISTER_BEGIN = "## 등록할 역 이름을 입력하세요.";
    private static final String STATION_REGISTER_FINISH = "지하철 역이 등록되었습니다.";
    private static final String STATION_REMOVE_BEGIN ="## 삭제할 역 이름을 입력하세요.";
    private static final String STATION_REMOVE_FINISH = "지하철 역이 삭제되었습니다.";

    public static String getMenu() {
        return MENU;
    }

    public static String getFinishPrefix() {
        return FINISH_PREFIX;
    }

    public static String getStationRegisterBegin() {
        return STATION_REGISTER_BEGIN;
    }

    public static String getStationRegisterFinish() {
        return FINISH_PREFIX + STATION_REGISTER_FINISH;
    }

    public static String getStationRemoveBegin() {
        return STATION_REMOVE_BEGIN;
    }

    public static String getStationRemoveFinish() {
        return FINISH_PREFIX + STATION_REMOVE_FINISH;
    }
}
