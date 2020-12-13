package subway.view.main;

import java.util.Scanner;

public class MainMenuInputView {

    private static final String STATION_MENU = "1";
    private static final String LINE_MENU = "2";
    private static final String SECTION_MENU = "3";
    private static final String INVALID_INPUT = "[ERROR] 선택할 수 없는 기능입니다.";
    private static final String QUIT_MENU = "Q";

    public static String getMainMenuCommand(Scanner scanner) {
        MainMenuOutputView.printMainMenu();
        try {
            String menuCommand = scanner.nextLine();
            validateMainMenuCommand(menuCommand);
            return menuCommand;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return getMainMenuCommand(scanner);
        }
    }

    private static void validateMainMenuCommand(String menuCommand) {
        if (!menuCommand.equals(STATION_MENU) && !menuCommand.equals(LINE_MENU) &&
                !menuCommand.equals(SECTION_MENU) && !menuCommand.equals(QUIT_MENU)) {
            throw new IllegalArgumentException(INVALID_INPUT);
        }
    }
}
