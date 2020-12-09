package subway.view;

import subway.enums.MainViewInput;

import java.util.Arrays;
import java.util.Scanner;

public class InputView {

    private static final String newLine = "\n";
    private final Scanner scanner;

    public InputView(Scanner scanner) {
        this.scanner = scanner;
    }

    public String mainInput() {
        System.out.println("## 메인 화면");
        for (MainViewInput mainViewInput : MainViewInput.values()) {
            System.out.println(mainViewInput.getMessage());
        }
        System.out.println(newLine + "## 원하는 기능을 선택하세요.");

        try {
            return MainViewInput.validateInput(scanner.nextLine());
        } catch (IllegalArgumentException e) {
            System.out.println(newLine + "[ERROR] 입력이 잘못되었습니다." + newLine);
            return mainInput();
        }
    }

}
