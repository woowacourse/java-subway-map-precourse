package subway.enums;

public enum SectionMenu {
    SUBJECT("## 구관 관리 화면","0"),
    ENROLL("1. 구간 등록", "1"),
    DELETE("2. 구간 삭제", "2"),
    BACK("B. 돌아가기", "B");

    String title = "";
    String command = "";

    SectionMenu(String title, String command) {
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