package subway.views;

import java.util.Scanner;

public class UserInput {
    Scanner scanner;

    public UserInput(Scanner scanner) {
        this.scanner = scanner;
    }

    public String getMainInput() {
        String input = scanner.nextLine();
        // 1, 2, 3, 4, Q 만 받을 것
        return input;
    }

    public String getStationLineInput() {
        String input = scanner.nextLine();
        // 1, 2, 3, 4, B 만 받을 것
        return input;
    }

    public String getSectionInput() {
        String input = scanner.nextLine();
        // 1, 2, 3, B 만 받을 것
        return input;
    }

    public String getNameInput() {
        String input = scanner.nextLine();
        // 2글자 이상 5글자 이하
        // 중복 방지
        return input;
    }
}
