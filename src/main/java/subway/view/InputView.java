package subway.view;

import java.util.List;
import java.util.Scanner;

public class InputView {
    private final Scanner scanner;

    public InputView(Scanner scanner) {
        this.scanner = scanner;
    }

    public String getInput(List<String> functionIndexList){
        return validateInput(functionIndexList, scanner.nextLine());
    }

    public String validateInput(List<String> functionIndexList, String str) {
        return str;
    }
}
