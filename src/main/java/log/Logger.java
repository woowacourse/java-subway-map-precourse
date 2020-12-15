package log;

public class Logger {

    public static final String LEVEL_ERROR = "[ERROR] ";
    public static final String LEVEL_INFO = "[INFO] ";

    public static void errorPrint(String errorBody) {
        System.out.println(LEVEL_ERROR + errorBody);
    }

    public static void infoPrint(String infoBody) {
        System.out.println(LEVEL_INFO + infoBody);
    }

    public static void displayMainScreen() {
        System.out.println("\n## 메인 화면\n"
            + "1. 역 관리\n"
            + "2. 노선 관리\n"
            + "3. 구간 관리\n"
            + "4. 지하철 노선도 출력\n"
            + "Q. 종료\n"
            + "\n"
            + "## 원하는 기능을 선택하세요.");
    }
}
