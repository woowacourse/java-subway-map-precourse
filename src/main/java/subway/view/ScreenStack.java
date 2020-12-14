package subway.view;

import java.util.Stack;

public class ScreenStack {
    private static final Stack<Screen> stack = new Stack<>();

    public static void pushScreen(Screen item) {
        stack.push(item);
    }

    public static Screen popScreen() {
        return stack.pop();
    }
}
