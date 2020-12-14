package subway.view;

import static subway.console.Output.print;
import static subway.console.Output.printPage;

import java.util.Arrays;
import java.util.List;
import subway.console.Button;
import subway.console.Input;
import subway.console.message.InfoMessage;
import subway.console.message.InputMessage;
import subway.console.Output;
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

    private boolean isEndLinePage(String button) {
        return !isCreate(button)
                && !isDelete(button)
                && !isRead(button)
                && !isBack(button);
    }

    private String inputButton() {
        printPage(LINE_PAGE);
        return input.nextButton(LINE_BUTTONS);
    }

    private boolean isCreate(String button) {
        if (button.equals(Button.ONE)) {
            print(InputMessage.CREATE_LINE);
            if (isCreateLine(input.nextLine())) {
                print(InfoMessage.CREATE_LINE);
            }
        }
        return false;
    }

    private boolean isCreateLine(String name) {
        return createLine(name)
                && createFirstStation(name)
                && createLastStation(name);
    }

    private boolean createLine(String name) {
        return lineController.createLine(name);
    }

    private boolean createFirstStation(String name) {
        print(InputMessage.FIRST_STATION);
        return lineController.createSection(name, input.nextLine());
    }

    private boolean createLastStation(String name) {
        print(InputMessage.LAST_STATION);
        return lineController.createSection(name, input.nextLine());
    }

    private boolean isDelete(String button) {
        if (button.equals(Button.TWO)) {
            print(InputMessage.DELETE_LINE);
            return isDeleteLine();
        }
        return false;
    }

    private boolean isDeleteLine() {
        print(InfoMessage.DELETE_LINE);
        return lineController.deleteLine(input.nextLine());
    }

    private boolean isRead(String button) {
        if (button.equals(Button.THREE)) {
            readLines();
            return true;
        }
        return false;
    }

    private void readLines() {
        Output.printLines(lineController.getLines());
    }

    private boolean isBack(final String button) {
        return button.equals(Button.BACK);
    }
}
