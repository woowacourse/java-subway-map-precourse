package subway.view.screen;

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
    private static final List<Action> MANAGE_MENU_ACTION = Arrays.asList(
            Action.INSERT, Action.DELETE, Action.SELECT, Action.BACK
    );

    public ManageScreen(String name) {
        this.name = name;
    }

    @Override
    public void show() {
        OutputView.printTitle(CHANGE_LINE + DOUBLE_SHARP + name + SPACE + TITLE);
        int i;
        for (i = 0; i < MANAGE_MENU_ACTION.size() - 1; i++) {
            OutputView.printMenus(Integer.toString(i + 1) + DOT + name + SPACE + MANAGE_MENU_ACTION.get(i).toString());
        }
        OutputView.printMenus(BACK_MARK + MANAGE_MENU_ACTION.get(i).toString());
    }

    @Override
    public void run(Scanner scanner) {
        OutputView.print(CHANGE_LINE + DOUBLE_SHARP + SELECT_FUNCTION);
        String command = InputView.getCommand(scanner);
        if (command.equals(BACK_COMMAND)) {
            ScreenStack.back();
            return;
        }
    }
}
