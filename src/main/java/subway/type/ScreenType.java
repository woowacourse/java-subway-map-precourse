package subway.type;

/**
 * 각종 화면 출력 문구 상수를 모아둔 Enum 클래스
 */
public enum ScreenType {
    MAIN_SCREEN("## 메인 화면\n"),
    STATION_MANAGEMENT("1. 역 관리\n"),
    LINE_MANAGEMENT("2. 노선 관리\n"),
    SECTION_MANAGEMENT("3. 구간 관리\n"),
    SUBWAY_MAP_PRINT("4. 지하철 노선도 출력\n"),
    QUITTING("Q. 종료\n\n"),
    FEATURE_CHOICE("## 원하는 기능을 선택하세요.");

    private final String screen;

    ScreenType(String screen) {
        this.screen = screen;
    }

    public String getScreen() {
        return screen;
    }
}
