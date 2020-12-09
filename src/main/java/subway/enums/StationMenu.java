package subway.enums;

public enum StationMenu {
    SUBJECT("## 역 관리 화면","0"),
    ENROLL("1. 역 등록", "1"),
    DELETE("2. 역 삭제", "2"),
    CHECK("3. 역 조회", "3"),
    BACK("B. 돌아가기", "B");

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
