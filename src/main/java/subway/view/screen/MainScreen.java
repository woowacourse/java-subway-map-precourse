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
    private static Screen screen = new MainScreen();

    public static final List<Element> MAIN_MENU_ELEMENT = Arrays.asList(
            Element.STATION, Element.LINE, Element.PATH, Element.MAP
    );

    private static final List<Action> MAIN_MENU_ACTION = Arrays.asList(
            Action.MANAGE, Action.MANAGE, Action.MANAGE, Action.PRINT, Action.EXIT
    );

    @Override
    public void show() {
        OutputView.printNewLine();
        OutputView.printWithDoubleSharp(TITLE);
        int i;
        for (i = 0; i < MAIN_MENU_ELEMENT.size(); i++) {
            OutputView.printMenus(Integer.toString(i + 1) + DOT + MAIN_MENU_ELEMENT.get(i).toString() + SPACE + MAIN_MENU_ACTION.get(i).toString());
        }
        OutputView.printMenus(EXIT_MARK + MAIN_MENU_ACTION.get(i).toString());
    }

    @Override
    public void run(Scanner scanner) {
        OutputView.printNewLine();
        OutputView.printSelectFunction();
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
        int parseCommandToInt = screen.isCommandValidate(command, MAX_MENU_NUMBER);
        if(parseCommandToInt != ERROR) {
            ScreenMapper.mapping(parseCommandToInt, screen);
        }
    }
}
