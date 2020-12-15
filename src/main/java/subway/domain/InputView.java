package subway.domain;

import java.util.List;
import java.util.Scanner;

public class InputView {
    public static String inputFunction(Scanner kbd, List<String> functions) {
        String input = "0";
        boolean check = false;
        while(!check) {
            System.out.println("\n## 원하는 기능을 선택하세요.");
            input = kbd.nextLine();
            check = Errors.checkInput(input, functions);
        }
        return input;
    }
}
