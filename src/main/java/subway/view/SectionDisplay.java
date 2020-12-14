package subway.view;

import java.util.Arrays;
import java.util.NoSuchElementException;

public class SectionDisplay extends Display {

    private static final String NOTICE_SECTION = "구간 관리 화면";
    private static final String ERROR_SECTION = "선택할 수 없는 기능입니다.";
    private static final String SAVE_SUCCESS_SECTION = "구간이 등록되었습니다.";
    private static final String DELETE_SUCCESS_SECTION = "구간이 삭제되었습니다.";

    public static void printInsertSuccess() {
        printInformation(SAVE_SUCCESS_SECTION);
    }

    public static void printDeleteSuccess() {
        printInformation(DELETE_SUCCESS_SECTION);
    }

    public static void loadSectionMenu() {
        while (true) {
            printMenu();
            SectionMenu selectedMenu = selectMenuByInput();
            try {
                selectedMenu.executeMenu(selectedMenu.getMenuKey());
                break;
            } catch (IllegalArgumentException e) {
                printError(e.getMessage());
            }
        }
    }

    private static void printMenu() {
        printNotice(NOTICE_SECTION);
        Arrays.stream(SectionMenu.values()).forEach(
            sectionMenu -> System.out
                .println(sectionMenu.getMenuKey() + ". " + sectionMenu.getMenuName()));
    }

    private static SectionMenu selectMenuByInput() {
        while (true) {
            try {
                return SectionMenu.getMenuByInput(UserInput.getMenu());
            } catch (NoSuchElementException e) {
                printError(ERROR_SECTION);
            }
        }
    }
}
