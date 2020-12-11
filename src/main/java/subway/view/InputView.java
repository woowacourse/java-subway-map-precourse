package subway.view;

import java.util.Scanner;

public class InputView {
    private final Scanner scanner;

    public InputView(Scanner scanner) {
        this.scanner = scanner;
    }

    public String receiveFunction() {
        System.out.println("## 원하는 기능을 선택하세요.");
        return this.scanner.nextLine();
    }
}
