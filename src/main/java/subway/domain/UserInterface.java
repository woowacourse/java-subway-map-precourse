package subway.domain;

import java.util.Scanner;

public class UserInterface {
    public static void mainMenu() {
        System.out.printf(Constant.HASH + Constant.MAIN_MENU + "%n"
                + Constant.ONE + Constant.DOT + Constant.STATION + Constant.SETTING + "%n"
                + Constant.TWO + Constant.DOT + Constant.LINE + Constant.SETTING + "%n"
                + Constant.THREE + Constant.DOT + Constant.SECTION + Constant.SETTING + "%n"
                + Constant.FOUR + Constant.DOT + Constant.SUBWAY_MAP + "%n"
                + Constant.Q + Constant.DOT + Constant.LINE + Constant.SETTING + "%n"
        );
    }

    static String getStationName(Scanner scanner) {
        System.out.printf(Constant.HASH + Constant.ENTER_NAME + "%n", Constant.ADD, Constant.STATION);
        String input = scanner.next();
        return Exception.passNameExceptionTest(input);
    }
}
