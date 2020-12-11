package subway.domain;

import java.util.Scanner;

public class UserInterface {
    public static void mainMenu(Scanner scanner) {
        Print.mainMenu();
        String input = scanner.next();
    }

    static String getStationName(Scanner scanner) {
        System.out.printf(Constant.HASH + Constant.ENTER_NAME + "%n", Constant.ADD, Constant.STATION);
        String input = scanner.next();
        return Exception.passNameExceptionTest(input);
    }
}
