package subway.view;

import static subway.console.Button.BACK;
import static subway.console.Button.ONE;
import static subway.console.Button.THREE;
import static subway.console.Button.TWO;
import static subway.console.Output.print;

import java.util.Arrays;
import java.util.List;
import subway.console.Input;
import subway.console.Output;
import subway.console.Page;
import subway.console.message.InfoMessage;
import subway.console.message.InputMessage;
import subway.controller.LineController;

/**
 * @author yhh1056
 * @since 2020/12/11
 */
public class LineView {
    private static final List<String> LINE_BUTTONS = Arrays.asList(ONE, TWO, THREE, BACK);

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
        Output.printPage(Page.LINE.getPages());
        return input.nextButton(LINE_BUTTONS);
    }

    private boolean isCreate(String button) {
        if (button.equals(ONE)) {
            print(InputMessage.CREATE_LINE.getMessage());
            if (isCreateLine(input.nextLine())) {
                print(InfoMessage.CREATE_LINE.getMessage());
                return true;
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
        print(InputMessage.FIRST_STATION.getMessage());
        return lineController.createSection(name, input.nextLine());
    }

    private boolean createLastStation(String name) {
        print(InputMessage.LAST_STATION.getMessage());
        return lineController.createSection(name, input.nextLine());
    }

    private boolean isDelete(String button) {
        if (button.equals(TWO)) {
            print(InputMessage.DELETE_LINE.getMessage());
            if (isDeleteLine()) {
                print(InfoMessage.DELETE_LINE.getMessage());
                return true;
            }
        }
        return false;
    }

    private boolean isDeleteLine() {
        return lineController.deleteLine(input.nextLine());
    }

    private boolean isRead(String button) {
        if (button.equals(THREE)) {
            readLines();
            return true;
        }
        return false;
    }

    private void readLines() {
        Output.printLines(lineController.getLines());
    }

    private boolean isBack(final String button) {
        return button.equals(BACK);
    }
}
