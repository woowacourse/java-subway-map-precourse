package subway.function.line;

public class PrintLineManagementScreen {
    private static final String SCREEN
        = "\n## 노선 관리 화면\n"
        + "1. 노선 등록\n"
        + "2. 노선 삭제\n"
        + "3. 노선 조회\n"
        + "B. 돌아가기";

    public static void printLineManagementScreen() {
        System.out.println(SCREEN);
    }
}
