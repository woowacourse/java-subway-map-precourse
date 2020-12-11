package subway.domain;

import java.util.Scanner;

public class UserInterface {
    public static void mainMenu() {
    }

    static String getStationName(Scanner scanner) {
        System.out.print(Constant.HASH);
        System.out.printf(Constant.ENTER_NAME, Constant.ADD, Constant.STATION);
        String input = scanner.next();
        return Exception.passNameExceptionTest(input);
    }
}
