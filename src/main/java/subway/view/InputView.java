package subway.view;

import java.util.Scanner;

/**
 * 입력값을 받는 클래스
 */
public class InputView {

    private final Scanner scanner;

    public InputView(Scanner scanner) {
        this.scanner = scanner;
    }

    public String inputValue() {
        return scanner.nextLine();
    }
}
