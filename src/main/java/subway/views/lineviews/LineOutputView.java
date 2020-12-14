package subway.views.lineviews;

import subway.menus.LineMenu;
import subway.views.OutputView;

import java.util.Arrays;

public class LineOutputView implements OutputView {
    private static final String LINE_MANAGE_PAGE = "## 노선 관리 화면";
    private static final String LINE_ADD_SUCCESS_MESSAGE = "지하철 노선이 등록되었습니다.\n";
    private static final String LINE_DELETE_SUCCESS_MESSAGE = "지하철 노선이 삭제되었습니다.\n";

    private LineOutputView() {
    }

    public static void printLineManagePage() {
        System.out.println(LINE_WRAP + LINE_MANAGE_PAGE);
        printLineManageMenus();
        System.out.println();
    }

    private static void printLineManageMenus() {
        Arrays.stream(LineMenu.values())
            .map(LineMenu::toString)
            .forEach(System.out::println);
    }

    public static void printAddSuccess() {
        System.out.println(LINE_WRAP + INFO_PREFIX + LINE_ADD_SUCCESS_MESSAGE);
    }

    public static void printDeleteSuccess() {
        System.out.println(LINE_WRAP + INFO_PREFIX + LINE_DELETE_SUCCESS_MESSAGE);
    }
}
