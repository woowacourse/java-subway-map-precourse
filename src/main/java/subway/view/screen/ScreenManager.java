package subway.view.screen;

import java.util.Stack;
import subway.view.InputView;
import subway.view.OutputView;

public class ScreenManager {

    public static final Stack<Screen> stack = new Stack<>();

    public static void push(Screen screen) {
        stack.push(screen);
    }

    public static Screen goBack() {
        return stack.pop();
    }

    public static Screen peek() {
        return stack.peek();
    }

    public static boolean isEmpty() {
        return stack.isEmpty();
    }

    public static void visualize() {
        peek().visualize();
        OutputView.println();
    }

    public static void logic(InputView inputView) {
        peek().logic(inputView);
        OutputView.println();
    }

    public static void exit() {
        stack.clear();
    }

    public static void goToFirstScreen() {
        while (stack.size() > 1) {
            goBack();
        }
    }

    public static boolean isMainScreen() {
        return peek() instanceof MainScreen;
    }

    public static boolean isManagementScreen() {
        return peek() instanceof ManagementScreen;
    }
}
