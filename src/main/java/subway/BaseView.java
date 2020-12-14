package subway;

import java.util.Scanner;

public abstract class BaseView {
    private static final String INPUT_MESSAGE = "## 원하는 기능을 선택하세요.";
    protected String GUIDE_MESSAGE;

    private Scanner scanner;

    public BaseView(Scanner scanner) {
        this.scanner = scanner;
    }

    public void printGuideMessage() {
        System.out.println(GUIDE_MESSAGE);
    }

    public void printInputMessage() {
        System.out.println(INPUT_MESSAGE);
    }

    public String input() {
        return scanner.next();
    }
}
