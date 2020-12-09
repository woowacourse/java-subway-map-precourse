package subway.enums;

public enum StationMenu {
    SUBJECT("## 역 관리 화면","0"),
    ENROLL("1. 역 등록", "1"),
    DELETE("2. 역 삭제", "2"),
    CHECK("3. 역 조회", "3"),
    BACK("B. 돌아가기", "B"),

    ASK_STATION_NAME("## 등록할 역 이름을 입력하세요.", "");

    String title = "";
    String command = "";

    StationMenu(String title, String command) {
        this.title = title;
        this.command = command;
    }

    public String getTitle() {
        return title;
    }

    public String getCommand() {
        return command;
    }
}
