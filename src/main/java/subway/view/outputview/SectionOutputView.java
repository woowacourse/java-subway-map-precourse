package subway.view.outputview;

import static subway.view.outputview.OutputView.*;

public class SectionOutputView {
    private static String SECTION_VIEW = "구간 관리 화면\n";
    private static String SECTION_MENU = "1. 구간 등록\n2. 구간 삭제\nB. 돌아가기\n";
    private static String SECTION_LINE = "노선을 입력하세요.\n";
    private static String DELETE_SECTION_LINE = "삭제할 구간의 노선을 입력하세요.\n";
    private static String SECTION_STATION = "역이름을 입력하세요.\n";
    private static String DELETE_SECTION_STATION = "삭제할 구간의 역을 입력하세요.\n";
    private static String SECTION_ORDER = "순서를 입력하세요.\n";
    private static String SUCCESS_ADD_SECTION = "구간이 등록되었습니다.\n";
    private static String SUCCESS_DELETE_SECTION = "구간이 삭제되었습니다.\n";
    public static void showMenu() {
        stringBuilder.append(MENU_SYMBOL);
        stringBuilder.append(SECTION_VIEW);
        stringBuilder.append(SECTION_MENU);
        print();
    }
}
