package subway.main.view;

import subway.main.validation.CheckValidOption;

import java.util.Scanner;

public class MainInputView {
    private static final String ASK_OPTION_CHOICE = "## 원하는 기능을 선택하세요.";

    private Scanner scanner;

    public MainInputView(Scanner scanner) {
        this.scanner = scanner;
    }

    public char selectOption() {
        char option;
        while (true) {
            try {
                System.out.println(ASK_OPTION_CHOICE);
                option = scanner.next().charAt(0);
                CheckValidOption.validation(option);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return option;
    }

    public Scanner getScanner() {
        return scanner;
    }
}
