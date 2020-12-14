package subway.view.screen;

import subway.view.InputView;
import subway.view.OutputView;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class MainScreen implements Screen {
    private static final String TITLE = "메인 화면";
    public static final int MAX_MENU_NUMBER = 4;
    public static final String EXIT_COMMAND = "Q";
    private static final String DIGIT_REGEX = "^[0-9]*$";

    public static final List<Element> MAIN_MENU_ELEMENT = Arrays.asList(
            Element.STATION, Element.LINE, Element.PATH, Element.MAP
    );

    private static final List<Action> MAIN_MENU_ACTION = Arrays.asList(
            Action.MANAGE, Action.MANAGE, Action.MANAGE, Action.PRINT, Action.EXIT
    );

    @Override
    public void show() {
        OutputView.printTitle(CHANGE_LINE + DOUBLE_SHARP + TITLE);
        int i;
        for (i = 0; i < MAIN_MENU_ELEMENT.size(); i++) {
            OutputView.printMenus(Integer.toString(i + 1) + DOT + MAIN_MENU_ELEMENT.get(i).toString() + SPACE + MAIN_MENU_ACTION.get(i).toString());
        }
        OutputView.printMenus(EXIT_MARK + MAIN_MENU_ACTION.get(i).toString());
    }

    @Override
    public void run(Scanner scanner) {
        OutputView.print(CHANGE_LINE + DOUBLE_SHARP + SELECT_FUNCTION);
        String command = InputView.getCommand(scanner);
        if (command.equals(EXIT_COMMAND)) {
            ScreenStack.exit();
            OutputView.printExitMessage();
            return;
        }
        checkCommandValidateAndMappingAppropriateScreen(command);
    }

    // 입력 값 확인
    private static final void checkCommandValidateAndMappingAppropriateScreen(String command) {
        if (!command.matches(DIGIT_REGEX)) {
            OutputView.printInvalidCommandExceptionErrorMessage(command);
            return;
        }
        int parseCommandToInt = Integer.parseInt(command);
        if (parseCommandToInt < MIN_MENU_NUMBER || parseCommandToInt > MAX_MENU_NUMBER) {
            OutputView.printInvalidCommandExceptionErrorMessage(command);
            return;
        }
        ScreenMapper.mapping(parseCommandToInt);
    }
}
