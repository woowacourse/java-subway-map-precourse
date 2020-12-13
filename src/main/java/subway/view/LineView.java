package subway.view;

import static subway.console.Output.printLine;
import static subway.console.Output.printPage;

import java.util.Arrays;
import java.util.List;
import subway.console.Button;
import subway.console.Input;
import subway.console.Message;
import subway.controller.LineController;

/**
 * @author yhh1056
 * @since 2020/12/11
 */
public class LineView {
    private static final List<String> LINE_PAGE = Arrays.asList(
            "\n## 노선 관리 화면",
            "1. 노선 등록",
            "2. 노선 삭제",
            "3. 노선 조회",
            "B. 돌아가기",
            "\n## 원하는 기능을 선택하세요.");
    private static final List<String> LINE_BUTTONS = Arrays.asList("1", "2", "3", "B");

    private final Input input;
    private final LineController lineController;

    public LineView(final Input input) {
        this.input = input;
        this.lineController = new LineController();
    }

    public void selectLinePage() {
        String button = inputButton();
        while (isEndLinePage(button)) {
            button = inputButton();
        }
    }

    private String inputButton() {
        printPage(LINE_PAGE);
        return input.nextButton(LINE_BUTTONS);
    }

    private boolean isEndLinePage(String button) {
        return !isCreate(button)
                && !isBack(button)
                && !isDelete(button);
    }

    private boolean isBack(final String button) {
        return button.equals(Button.BACK);
    }

    private boolean isCreate(String button) {
        if (button.equals(Button.ONE)) {
            printLine(Message.INPUT_CREATE_LINE);

            if (isCreateLine(input.nextLine())) {
                printLine(Message.INFO_CREATE_LINE);
                return true;
            }
        }
        return false;
    }

    private boolean isCreateLine(String name) {
        printLine(Message.INPUT_FIRST_STATION);
        String firstStation = input.nextLine();

        printLine(Message.INPUT_LAST_STATION);
        String lastStation = input.nextLine();

        return lineController.createSection(name, firstStation, lastStation);
    }

    private boolean isDelete(String button) {
        if (button.equals(Button.TWO)) {
            printLine(Message.INPUT_DELETE_LINE);

            if (isDeleteLine()) {
                printLine(Message.INFO_DELETE_LINE);
                return true;
            }
        }
        return false;
    }

    private boolean isDeleteLine() {
        return lineController.deleteLine(input.nextLine());
    }

    private void readLine(String button) {
        if (button.equals(Button.THREE)) {
        }
    }
}
