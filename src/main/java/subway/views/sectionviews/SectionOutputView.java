package subway.views.sectionviews;

import subway.menus.SectionMenu;
import subway.views.OutputView;

import java.util.Arrays;

public class SectionOutputView implements OutputView {
    private static final String SECTION_MANAGE_PAGE = "## 구간 관리 화면";
    private static final String INPUT_LINE_MESSAGE = "## 노선을 입력하세요.";
    private static final String INPUT_STATION_MESSAGE = "## 역이름을 입력하세요.";
    private static final String INPUT_SECTION_ORDER_MESSAGE = "## 순서를 입력하세요.";
    private static final String SECTION_ADD_SUCCESS_MESSAGE = "구간이 등록되었습니다.";
    private static final String INPUT_LINE_TO_DELETE_MESSAGE = "## 삭제할 구간의 노선을 입력하세요.";
    private static final String INPUT_STATION_TO_DELETE_MESSAGE = "## 삭제할 구간의 역을 입력하세요.";
    private static final String SECTION_DELETE_SUCCESS_MESSAGE = "구간이 삭제되었습니다.";

    private SectionOutputView() {
    }

    public static void printSectionManagePage() {
        System.out.println(LINE_WRAP + SECTION_MANAGE_PAGE);
        printSectionManageMenus();
        System.out.println();
    }

    private static void printSectionManageMenus() {
        Arrays.stream(SectionMenu.values())
            .map(SectionMenu::toString)
            .forEach(System.out::println);
    }

    public static void printLineToAddSectionMessage() {
        System.out.println(LINE_WRAP + INPUT_LINE_MESSAGE);
    }

    public static void printStationToAddSectionMessage() {
        System.out.println(LINE_WRAP + INPUT_STATION_MESSAGE);
    }

    public static void printOrderToAddSectionMessage() {
        System.out.println(LINE_WRAP + INPUT_SECTION_ORDER_MESSAGE);
    }

    public static void printAddSuccess() {
        System.out.println(LINE_WRAP + INFO_PREFIX + SECTION_ADD_SUCCESS_MESSAGE + LINE_WRAP);
    }

    public static void printLineToDeleteSectionMessage() {
        System.out.println(LINE_WRAP + INPUT_LINE_TO_DELETE_MESSAGE);
    }

    public static void printStationToDeleteSectionMessage() {
        System.out.println(LINE_WRAP + INPUT_STATION_TO_DELETE_MESSAGE);
    }

    public static void printDeleteSuccess() {
        System.out.println(LINE_WRAP + INFO_PREFIX + SECTION_DELETE_SUCCESS_MESSAGE + LINE_WRAP);
    }
}
