package subway.view.screen;

import subway.controller.Controller;
import subway.controller.ControllerMapper;
import subway.view.InputView;
import subway.view.OutputView;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ManageScreen implements Screen {
    private static String name;
    private static final String TITLE = "관리 화면";
    public static final int MAX_MENU_NUMBER = 3;
    public static final String BACK_COMMAND = "B";
    private static Screen screen;
    private static final List<Action> MANAGE_MENU_ACTION = Arrays.asList(
            Action.INSERT, Action.DELETE, Action.SELECT, Action.BACK
    );

    public ManageScreen(String name) {
        this.name = name;
    }

    @Override
    public void show() {
        OutputView.printNewLine();
        OutputView.printWithDoubleSharp(name + SPACE + TITLE);
        int i;
        for (i = 0; i < MANAGE_MENU_ACTION.size() - 1; i++) {
            OutputView.printMenus(Integer.toString(i + 1) + DOT + name + SPACE + MANAGE_MENU_ACTION.get(i).toString());
        }
        OutputView.printMenus(BACK_MARK + MANAGE_MENU_ACTION.get(i).toString());
    }

    @Override
    public void run(Scanner scanner) {
        OutputView.printNewLine();
        OutputView.printWithDoubleSharp(SELECT_FUNCTION);
        String command = InputView.getCommand(scanner);
        if (command.equals(BACK_COMMAND)) {
            ScreenStack.back();
            return;
        }
        checkCommandValidateAndMappingAppropriateScreen(command);
    }

    // 입력 값 확인
    private static final void checkCommandValidateAndMappingAppropriateScreen(String command) {
        int parseCommandToInt = screen.isCommandValidate(command);
        if (parseCommandToInt != ERROR) {
            ControllerMapper.mapping(name).mappingCommandToValidFunction(parseCommandToInt);
        }
    }
}
