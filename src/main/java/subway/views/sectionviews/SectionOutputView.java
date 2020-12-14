package subway.views.sectionviews;

import subway.menus.SectionMenu;
import subway.views.OutputView;

import java.util.Arrays;

public class SectionOutputView implements OutputView {
    private static final String SECTION_MANAGE_PAGE = "## 구간 관리 화면";
    private static final String SECTION_ADD_SUCCESS_MESSAGE = "구간이 등록되었습니다.\n";
    private static final String SECTION_DELETE_SUCCESS_MESSAGE = "구간이 삭제되었습니다.\n";

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

    public static void printAddSuccess() {
        System.out.println(LINE_WRAP + INFO_PREFIX + SECTION_ADD_SUCCESS_MESSAGE);
    }

    public static void printDeleteSuccess() {
        System.out.println(LINE_WRAP + INFO_PREFIX + SECTION_DELETE_SUCCESS_MESSAGE);
    }
}
