package view;

public class LineManagerOutputView {

    public static final String LINE_MAIN_TITLE = "## 노선 관리 화면";
    public static final String LINE_ENROLLMENT = "1. 노선 등록";
    public static final String LINE_DELETION = "2. 노선 삭제";
    public static final String LINE_SEARCH = "3. 노선 조회";
    static final String B_QUIT_OPTION = "B. 종료";

    public static void printLineManagerMainScreen() {
        System.out.println(LINE_MAIN_TITLE);
        System.out.println(LINE_ENROLLMENT);
        System.out.println(LINE_DELETION);
        System.out.println(LINE_SEARCH);
        System.out.println(B_QUIT_OPTION);
        System.out.println();
    }
}
