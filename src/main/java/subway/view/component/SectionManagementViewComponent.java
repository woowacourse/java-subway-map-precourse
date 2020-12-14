package subway.view.component;

public class SectionManagementViewComponent {
    private static final String MENU = "## 구간 관리 화면\n" +
            "1. 구간 등록\n" +
            "2. 구간 삭제\n" +
            "B. 돌아가기";
    private static final String FINISH_PREFIX = "[INFO] ";
    private static final String SECTION_REGISTER_LINE_NAME_INPUT = "## 노선을 입력하세요.";
    private static final String SECTION_REGISTER_STATION_NAME_INPUT = "## 역이름을 입력하세요.";
    private static final String SECTION_REGISTER_STATION_ORDER = "## 순서를 입력하세요.";
    private static final String SECTION_REGISTER_FINISH = "구간이 등록되었습니다.";
    private static final String SECTION_REMOVE_LINE_NAME_INPUT = "## 삭제할 구간의 노선을 입력하세요.";
    private static final String SECTION_REMOVE_STATION_NAME_INPUT = "## 삭제할 구간의 역을 입력하세요.";
    private static final String SECTION_REMOVE_FINISH = "구간이 삭제되었습니다.";

    public static String getMenu() {
        return MENU;
    }

    public static String getSectionRegisterLineNameInput() {
        return SECTION_REGISTER_LINE_NAME_INPUT;
    }

    public static String getSectionRegisterStationNameInput() {
        return SECTION_REGISTER_STATION_NAME_INPUT;
    }

    public static String getSectionRegisterStationOrder() {
        return SECTION_REGISTER_STATION_ORDER;
    }

    public static String getSectionRegisterFinish() {
        return FINISH_PREFIX + SECTION_REGISTER_FINISH;
    }

    public static String getSectionRemoveLineNameInput() {
        return SECTION_REMOVE_LINE_NAME_INPUT;
    }

    public static String getSectionRemoveStationNameInput() {
        return SECTION_REMOVE_STATION_NAME_INPUT;
    }

    public static String getSectionRemoveFinish() {
        return FINISH_PREFIX + SECTION_REMOVE_FINISH;
    }
}
