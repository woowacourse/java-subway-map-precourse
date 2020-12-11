package subway.domain;

import java.util.Scanner;

public class UserInterface {


    public static void mainMenu() {
        System.out.println(Constant.HASH + Constant.MAIN_MENU);
    }

    static String getStationName(Scanner scanner) {
        System.out.print(Constant.HASH);
        System.out.println(Constant.GIVE_ME_STATION_NAME);
        String input = scanner.next();
        return Exception.passNameExceptionTest(input);
    }
}
