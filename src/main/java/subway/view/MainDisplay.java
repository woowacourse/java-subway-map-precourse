package subway.view;

import java.util.Arrays;
import java.util.NoSuchElementException;

public class MainDisplay extends Display {

    private static final String NOTICE_MAIN = "메인 화면";
    private static final String ERROR_MAIN = "선택할 수 없는 기능입니다.";

    public static void loadMainMenu() {
        while (true) {
            printMenu();
            MainMenu selectedMenu = selectMenuByInput();
            if (selectedMenu == MainMenu.QUIT_PROGRAM) {
                break;
            }
            selectedMenu.executeMenu(selectedMenu.getMenuKey());
        }
    }

    private static void printMenu() {
        printNotice(NOTICE_MAIN);
        Arrays.stream(MainMenu.values()).forEach(
            mainMenu -> System.out.println(mainMenu.getMenuKey() + ". " + mainMenu.getMenuName()));
    }

    private static MainMenu selectMenuByInput() {
        while (true) {
            try {
                return MainMenu.getMenuByInput(UserInput.getMenu());
            } catch (NoSuchElementException e) {
                printError(ERROR_MAIN);
            }
        }
    }
}
