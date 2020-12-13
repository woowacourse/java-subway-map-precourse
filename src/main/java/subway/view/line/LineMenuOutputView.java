package subway.view.line;

public class LineMenuOutputView {

    private static final String LINE_MENU = "## 노선 관리 화면\n1. 노선 등록\n2. 노선 삭제\n3. 노선 조회\nB. 돌아가기\n";
    private static final String CHOOSE_COMMAND_MESSAGE = "## 원하는 기능을 선택하세요.";

    public static void printLineMenu() {
        System.out.println();
        System.out.println(LINE_MENU);
        printChooseCommandMessage();
    }

    public static void printChooseCommandMessage() {
        System.out.println(CHOOSE_COMMAND_MESSAGE);
    }
}
