package subway;

public class PrintStationManagementScreen {
    private static final String SCREEN
        = "\n## 역 관리 화면\n"
        + "1. 역 등록\n"
        + "2. 역 삭제\n"
        + "3. 역 조회\n"
        + "B. 돌아가기";

    public static void printStationManagementScreen() {
        System.out.println(SCREEN);
    }
}
