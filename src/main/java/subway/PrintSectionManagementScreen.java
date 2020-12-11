package subway;

public class PrintSectionManagementScreen {
    private static final String SCREEN
        = "\n## 구간 관리 화면\n"
        + "1. 구간 등록\n"
        + "2. 구간 삭제\n"
        + "B. 돌아가기";

    public static void printSectionManagementScreen() {
        System.out.println(SCREEN);
    }
}
