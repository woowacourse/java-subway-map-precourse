package subway.view.screen;

import java.util.Stack;
import subway.view.InputView;

public class ScreenManager {

    public static final Stack<Screen> stack = new Stack<>();

    public static void push(Screen screen) {
        stack.push(screen);
    }

    public static void goBack() {
        stack.pop();
    }

    public static Screen peek() {
        return stack.peek();
    }

    public static boolean isEmpty() {
        return stack.isEmpty();
    }

    public static void visualize() {
        peek().visualize();
    }

    public static void logic(InputView inputView) {
        peek().logic(inputView);
    }

    public static void exit() {
        stack.clear();
    }

    public static void goToFirstScreen() {
        while (stack.size() > 1) {
            goBack();
        }
    }
}
