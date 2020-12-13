package subway.main;

import java.util.Scanner;
import subway.common.validator.CommonValidator;
import subway.common.print.info.CommonInfoPrinter;

public class SubwayMapProgram {

    public static void start(Scanner scanner) {
        Initializer.initialize();
        while (true) {
            PrintMainScreen.printMainScreen();
            MainSelectionType type = getSelectionInput(scanner);
            if (type == MainSelectionType.QUIT) {
                return;
            }
            MainTypeResolver.resolveUserSelection(type, scanner);
        }
    }

    private static MainSelectionType getSelectionInput(Scanner scanner) {
        String userInput = "";
        while (true) {
            CommonInfoPrinter.printUserFunctionSelectionMessage();
            userInput = scanner.nextLine();
            try {
                CommonValidator
                    .validateSelectionInput(CommonValidator.SELECTION_INPUT_PATTERN_1234Q,
                        userInput);
            } catch (Exception ignored) {
                continue;
            }
            return MainTypeResolver.getMainUserSelectionType(userInput);
        }
    }
}
