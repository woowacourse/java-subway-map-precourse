package subway.enums;

public enum LineMenu {
    SUBJECT("## 노선 관리 화면","0"),
    ENROLL("1. 노선 등록", "1"),
    DELETE("2. 노선 삭제", "2"),
    CHECK("3. 노선 조회", "3"),
    BACK("B. 돌아가기", "B");

    String title = "";
    String command = "";

    LineMenu(String title, String command) {
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
