package subway.views.lineviews;

import subway.domain.Line;
import subway.menus.LineMenu;
import subway.views.OutputView;

import java.util.Arrays;
import java.util.List;

public class LineOutputView implements OutputView {
    private static final String LINE_MANAGE_PAGE = "## 노선 관리 화면";
    private static final String LINE_NAME_TO_ADD_MESSAGE = "## 등록할 노선 이름을 입력하세요.";
    private static final String INPUT_UPWARD_END_NAME_MESSAGE = "## 등록할 노선의 상행 종점역 이름을 입력하세요.";
    private static final String INPUT_DOWNWARD_END_NAME_MESSAGE = "## 등록할 노선의 하행 종점역 이름을 입력하세요.";
    private static final String LINE_ADD_SUCCESS_MESSAGE = "지하철 노선이 등록되었습니다.";
    private static final String LINE_NAME_TO_DELETE_MESSAGE = "## 삭제할 노선 이름을 입력하세요.";
    private static final String LINE_DELETE_SUCCESS_MESSAGE = "지하철 노선이 삭제되었습니다.";
    private static final String LINE_LIST_MESSAGE = "## 노선 목록";

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

    public static void printLineNameToAddMessage() {
        System.out.println(LINE_WRAP + LINE_NAME_TO_ADD_MESSAGE);
    }

    public static void printUpwardEndToAddMessage() {
        System.out.println(LINE_WRAP + INPUT_UPWARD_END_NAME_MESSAGE);
    }

    public static void printDownwardEndToAddMessage() {
        System.out.println(LINE_WRAP + INPUT_DOWNWARD_END_NAME_MESSAGE);
    }

    public static void printAddSuccess() {
        System.out.println(LINE_WRAP + INFO_PREFIX + LINE_ADD_SUCCESS_MESSAGE + LINE_WRAP);
    }

    public static void printLineNameToDeleteMessage() {
        System.out.println(LINE_WRAP + LINE_NAME_TO_DELETE_MESSAGE);
    }

    public static void printDeleteSuccess() {
        System.out.println(LINE_WRAP + INFO_PREFIX + LINE_DELETE_SUCCESS_MESSAGE + LINE_WRAP);
    }

    public static void printLines(List<Line> lines) {
        System.out.println(LINE_WRAP + LINE_LIST_MESSAGE);
        lines.stream()
            .map(Line::getName)
            .forEach(name -> System.out.println(INFO_PREFIX + name));
        System.out.println();
    }
}
