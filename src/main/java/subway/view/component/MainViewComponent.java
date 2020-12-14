package subway.view.component;

public class MainViewComponent {
    private static final String MENU = "## 메인 화면\n" +
            "1. 역 관리\n" +
            "2. 노선 관리\n" +
            "3. 구간 관리\n" +
            "4. 지하철 노선도 출력\n" +
            "Q. 종료";
    private static final String SUBWAY_LINE_MAP = "## 지하철 노선도";

    public static String getMenu() {
        return MENU;
    }

    public static String getSubwayLineMap() {
        return SUBWAY_LINE_MAP;
    }
}
