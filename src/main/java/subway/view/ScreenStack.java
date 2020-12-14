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

    public static Screen peek(){
        return stack.peek();
    }

    public static void show(){
        stack.peek().show();
    }
}
