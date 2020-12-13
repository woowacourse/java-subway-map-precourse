package subway.view;

import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class MainDisplay extends Display {

    private static final String NOTICE_MAIN = "메인 화면";
    private static final String ERROR_MAIN = "선택할 수 없는 기능입니다.";

    public static void printMenu() {
        printNotice(NOTICE_MAIN);
        Arrays.stream(MainMenu.values()).forEach(
            mainMenu -> System.out.println(mainMenu.getMenuKey() + ". " + mainMenu.getMenuName()));
    }

    public static MainMenu selectMenu(Scanner scanner) {
        while (true) {
            try {
                return MainMenu.getMenuByInput(UserInput.getMenu(scanner));
            } catch (NoSuchElementException e) {
                printError(ERROR_MAIN);
            }
        }
    }
}
