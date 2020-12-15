package subway.view.screen;

import java.util.Scanner;
import java.util.Stack;

public class ScreenStack {
    private static final Stack<Screen> stack = new Stack<>();

    public static void pushScreen(Screen item) {
        stack.push(item);
    }

    public static Screen popScreen() {
        return stack.pop();
    }

    public static void show() {
        stack.peek().show();
    }

    public static void run(Scanner scanner) {
        if (!stack.isEmpty()) {
            stack.peek().run(scanner);
        }
    }

    public static boolean isEmpty() {
        return stack.isEmpty();
    }

    public static int getSize() {
        return stack.size();
    }

    public static void returnToFirstScreen() {
        while (stack.size() > 1) {
            stack.pop();
        }
    }

    public static void back() {
        stack.pop();
    }

    public static void exit() {
        stack.clear();
    }
}
