package subway.line.view;

public class LineOutputView {
    private static final String LINE_MANAGEMENT_TITLE = "## 노선 관리 화면";
    private static final String ADD_LINE = "1. 노선 등록";
    private static final String DELETE_LINE = "2. 노선 삭제";
    private static final String PRINT_LINE = "3. 노선 조회";
    private static final String GO_BACK = "B. 돌아가기";

    public static void printLineManagement() {
        System.out.println(LINE_MANAGEMENT_TITLE);
        System.out.println(ADD_LINE);
        System.out.println(DELETE_LINE);
        System.out.println(PRINT_LINE);
        System.out.println(GO_BACK);
        System.out.println();
    }
}
