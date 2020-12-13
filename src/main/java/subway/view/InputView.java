package subway.view;

import java.util.Scanner;

public class InputView {
    Scanner scanner;
    
    InputView(Scanner scanner) {
        this.scanner = scanner;
    }
    
    String userInput() {
        return scanner.nextLine().trim();
    }
}
