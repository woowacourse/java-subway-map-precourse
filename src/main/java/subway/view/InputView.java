package subway.view;

import java.util.List;
import java.util.Scanner;

import subway.domain.menu.constant.CommonMessage;
import subway.domain.menu.exception.NotAccptedInputException;

public class InputView {
    private Scanner scanner;
    private Validate validate;

    public InputView(Scanner scanner) {
        this.scanner = scanner;
        validate = new Validate();
    }

    public char inputMainMenu(List<Character> selMenu) {
        char sel;
        while (true) {
            try {
                System.out.println(CommonMessage.SELECT_MESSAGE);
                sel = validate.isAccptedInput(selMenu, scanner.nextLine().charAt(0));
                System.out.println();
                break;
            } catch(NotAccptedInputException e) {
                System.out.println(e.getMessage());
            }
        }
        return sel;
    }
}
