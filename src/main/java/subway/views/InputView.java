package subway.views;

import java.util.Scanner;

public interface InputView {
    static String userInput(Scanner scanner) {
        return scanner.nextLine();
    }
}
