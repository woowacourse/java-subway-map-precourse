package subway.type;

/**
 * ScreenType.java : 화면 문구 상수를 모아둔 Enum 클래스
 *
 * @author Daeun Lee
 * @version 1.0
 */
public enum ScreenType {
    MAIN_SCREEN("## 메인 화면\n"),
    STATION_MANAGEMENT("1. 역 관리\n"),
    LINE_MANAGEMENT("2. 노선 관리\n"),
    SECTION_MANAGEMENT("3. 구간 관리\n"),
    SUBWAY_MAP_SHOW("4. 지하철 노선도 출력\n"),

    STATION_MANAGEMENT_SCREEN("## 역 관리 화면\n"),
    STATION_ADDITION("1. 역 등록\n"),
    STATION_DELETION("2. 역 삭제\n"),
    STATION_SHOW("3. 역 조회\n"),

    LINE_MANAGEMENT_SCREEN("## 노선 관리 화면\n"),
    LINE_ADDITION("1. 노선 등록\n"),
    LINE_DELETION("2. 노선 삭제\n"),
    LINE_SHOW("3. 노선 조회\n"),

    SECTION_MANAGEMENT_SCREEN("## 구간 관리 화면\n"),
    SECTION_ADDITION("1. 구간 등록\n"),
    SECTION_DELETION("2. 구간 삭제\n"),

    QUITTING("Q. 종료\n\n"),
    BACK("B. 돌아가기\n\n"),

    FEATURE_CHOICE("## 원하는 기능을 선택하세요.");

    private final String screen;

    ScreenType(String screen) {
        this.screen = screen;
    }

    public String getScreen() {
        return screen;
    }
}
