package subway.view.screen;

import subway.controller.ControllerMapper;
import subway.view.InputView;
import subway.view.OutputView;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class PathManageScreen implements Screen {
    private static String name;
    private static final String TITLE = "관리 화면";
    public static final int MAX_MENU_NUMBER = 3;
    public static final String BACK_COMMAND = "B";
    private static Screen screen;
    private static final List<Action> MANAGE_MENU_ACTION = Arrays.asList(
            Action.INSERT, Action.DELETE, Action.BACK
    );

    PathManageScreen(String name, Screen screen) {
        this.name = name;
        this.screen = screen;
    }

    @Override
    public void show() {
        OutputView.printWithDoubleSharp(name + SPACE + TITLE);
        int i;
        for (i = 0; i < MANAGE_MENU_ACTION.size() - 1; i++) {
            OutputView.printMenus(Integer.toString(i + 1) + DOT + name + SPACE + MANAGE_MENU_ACTION.get(i).toString());
        }
        OutputView.printMenus(BACK_MARK + MANAGE_MENU_ACTION.get(i).toString());
        OutputView.printNewLine();
    }

    @Override
    public void run(Scanner scanner) {
        OutputView.printSelectFunction();
        String command = InputView.getCommand(scanner);
        if (command.equals(BACK_COMMAND)) {
            ScreenStack.back();
            return;
        }
        checkCommandValidateAndMappingAppropriateController(command, scanner);
        ScreenStack.popScreen();
    }

    private static final void checkCommandValidateAndMappingAppropriateController(String command, Scanner scanner) {
        int parseCommandToInt = screen.isCommandValidate(command, MAX_MENU_NUMBER);
        if (parseCommandToInt != ERROR) {
            ControllerMapper.mapping(name).mappingCommandToValidFunction(parseCommandToInt, scanner);
        }
    }
}
