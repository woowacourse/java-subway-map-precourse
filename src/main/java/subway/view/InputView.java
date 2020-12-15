package subway.view;

import java.util.Scanner;

import static subway.view.OutputView.NOTICE_HEAD;

public class InputView {
    private final Scanner scanner;

    public InputView(Scanner scanner) {
        this.scanner = scanner;
    }

    public String receiveAction() {
        System.out.println(NOTICE_HEAD + "원하는 기능을 선택하세요.");
        return this.scanner.nextLine();
    }

    public String receiveActionInfo() {
        return this.scanner.nextLine();
    }
}
