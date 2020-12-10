package subway.main.view;

import java.util.Scanner;

public class MainInputView {
    private static final String ASK_OPTION_CHOICE = "## 원하는 기능을 선택하세요.";

    private Scanner scanner;

    public MainInputView(Scanner scanner) {
        this.scanner = scanner;
    }

    public int selectOption() {
        System.out.println(ASK_OPTION_CHOICE);
        return scanner.nextInt();
    }
}
