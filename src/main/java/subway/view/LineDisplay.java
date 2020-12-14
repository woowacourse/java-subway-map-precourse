package subway.view;

import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
import subway.domain.Line;

public class LineDisplay extends Display {

    private static final String NOTICE_LINE = "노선 관리 화면";
    private static final String ERROR_LINE = "선택할 수 없는 기능입니다.";
    private static final String SAVE_SUCCESS_LINE = "지하철 노선이 등록되었습니다.";
    private static final String DELETE_SUCCESS_LINE = "지하철 노선이 삭제되었습니다.";
    private static final String PRINT_ALL_LINES = "노선 목록";

    public static void printSaveSuccess() {
        printInformation(SAVE_SUCCESS_LINE);
    }

    public static void printDeleteSuccess() {
        printInformation(DELETE_SUCCESS_LINE);
    }

    public static void printAllLines(List<Line> lines) {
        printNotice(PRINT_ALL_LINES);
        lines.stream().forEach(line -> printInformationList(line.getName()));
    }

    public static void loadLineMenu() {
        while (true) {
            printMenu();
            LineMenu selectedMenu = selectMenuByInput();
            try {
                selectedMenu.executeMenu(selectedMenu.getMenuKey());
                break;
            } catch (IllegalArgumentException e) {
                printError(e.getMessage());
            }
        }
    }

    private static void printMenu() {
        printNotice(NOTICE_LINE);
        Arrays.stream(LineMenu.values()).forEach(
            lineMenu -> System.out
                .println(lineMenu.getMenuKey() + ". " + lineMenu.getMenuName()));
    }

    private static LineMenu selectMenuByInput() {
        while (true) {
            try {
                return LineMenu.getMenuByInput(UserInput.getMenu());
            } catch (NoSuchElementException e) {
                printError(ERROR_LINE);
            }
        }
    }
}
