package base;

import java.util.Scanner;

public abstract class BaseView {
    private static final String INPUT_MESSAGE = "## 원하는 기능을 선택하세요.";
    private Scanner scanner;

    protected String GUIDE_MESSAGE;

    public BaseView(Scanner scanner) {
        this.scanner = scanner;
    }

    public void printMessage(String s) {
        System.out.println(s);
    }

    public void printGuideMessage() {
        printMessage(GUIDE_MESSAGE);
    }

    public void printInputMessage() {
        printMessage(INPUT_MESSAGE);
    }

    public String input() {
        return scanner.next();
    }
}
