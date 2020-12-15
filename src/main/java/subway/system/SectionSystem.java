package subway.system;

import java.util.Scanner;
import subway.system.manager.SectionManager;
import subway.system.validator.SectionSystemInputValidator;
import subway.system.view.SectionManagerView;

public class SectionSystem {

    static final String ASK_OPTION_MESSAGE = "## 원하는 기능을 선택하세요.";
    static final String ERROR_PREFIX = "[ERROR] ";

    private String userOption = "";
    SectionManager sectionManager;

    public SectionSystem() {
        sectionManager = new SectionManager();
    }

    public void run(Scanner scanner) {
        SectionManagerView.printSectionManagerMainScreen();
        userOption = getUserOption(scanner);
        callOptionMenu(userOption, scanner);
    }

    public String getUserOption(Scanner scanner) {
        try {
            System.out.println(ASK_OPTION_MESSAGE);
            String userOption = scanner.nextLine();
            System.out.println();
            SectionSystemInputValidator.validateUserOption(userOption);
            return userOption;
        } catch (IllegalArgumentException iae) {
            System.out.println(ERROR_PREFIX + iae.getMessage());
            return getUserOption(scanner);
        }
    }

    public void callOptionMenu(String userOption, Scanner scanner) {
        if (!Character.isDigit(userOption.charAt(0))) {
            return;
        }
        int optionNumber = Integer.parseInt(userOption);
        if (optionNumber == 1) {
            sectionManager.enrollSection(scanner);
        }
        if (optionNumber == 2) {
            sectionManager.deleteSection(scanner);
        }
    }
}
