package subway.view;

public class LineOutputView {
    private static final String MANAGE_LINE_SCREEN = "## 노선 관리 화면";
    private static final String REGISTER_LINE = "1. 노선 등록";
    private static final String REMOVE_LINE = "2. 노선 삭제";
    private static final String PRINT_LINE = "3. 노선 조회";
    private static final String BACK = "B. 돌아가기";

    private LineOutputView() {
    }

    public static void printManageLineScreen() {
        System.out.println();
        System.out.println(MANAGE_LINE_SCREEN);
        System.out.println(REGISTER_LINE);
        System.out.println(REMOVE_LINE);
        System.out.println(PRINT_LINE);
        System.out.println(BACK);
        System.out.println();
    }
}
