package subway.system;

import java.util.Scanner;
import subway.manager.LineManager;
import subway.validator.LineManagerValidator;
import view.LineManagerView;

public class LineSystem {

    static final String ASK_OPTION_MESSAGE = "## 원하는 기능을 선택하세요.";
    static final String ERROR_PREFIX = "[ERROR] ";

    String userOption = "";
    LineManager lineManager;

    public LineSystem() {
        lineManager = new LineManager();
    }

    public void run(Scanner scanner) {
        LineManagerView.printLineManagerMainScreen();
        userOption = getUserOption(scanner);
        callOptionMenu(userOption, scanner);
    }

    public static String getUserOption(Scanner scanner) {
        try {
            System.out.println(ASK_OPTION_MESSAGE);
            String userOption = scanner.nextLine();
            System.out.println();
            LineManagerValidator.validateUserOption(userOption);
            return userOption;
        } catch (IllegalArgumentException iae) {
            System.out.println(ERROR_PREFIX + iae.getMessage());
            return getUserOption(scanner);
        }
    }

    public void callOptionMenu(String userOption, Scanner scanner) {
        if (!Character.isDefined(userOption.charAt(0))) {
            return;
        }
        int optionNumber = Integer.parseInt(userOption);
        if (optionNumber == 1) {
            lineManager.enrollLine(scanner);
        }
        if (optionNumber == 2) {
            lineManager.deleteLine(scanner);
        }
        if (optionNumber == 3) {
            lineManager.searchLine(scanner);
        }
    }
}
