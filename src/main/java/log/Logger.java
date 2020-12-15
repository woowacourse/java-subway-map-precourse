package log;

public class Logger {
    public static final String LEVEL_GUIDE = "\n## ";
    public static final String LEVEL_ERROR = "\n[ERROR] ";
    public static final String LEVEL_INFO = "\n[INFO] ";

    public static void guidePrint(String errorBody) {
        System.out.println(LEVEL_GUIDE + errorBody);
    }

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

    public static void displayLineManageScreen() {
        System.out.println("\n## 노선 관리 화면\n"
            + "1. 노선 등록\n"
            + "2. 노선 삭제\n"
            + "3. 노선 조회\n"
            + "B. 돌아가기\n"
            + "\n"
            + "## 원하는 기능을 선택하세요.");
    }
}
