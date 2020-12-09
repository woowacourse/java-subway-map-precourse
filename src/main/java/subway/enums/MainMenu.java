package subway.enums;

public enum MainMenu {
    SUBJECT("## 메인 화면", "0"),
    STATION_CONTROL("1. 역 관리", "1"),
    LINE_CONTROL("2. 노선 관리","2"),
    SECTION_CONTROL("3. 구간 관리", "3"),
    PRINT_SUBWAY_MAP("4. 지하철 노선도 출력", "4"),
    EXIT("Q. 종료", "Q");

    String title = "";
    String command = "";

    MainMenu(String title, String command) {
        this.title = title;
        this.command = command;
    }

    public String getTitle() {
        return this.title;
    }

    public String getCommand() {
        return this.command;
    }
}
