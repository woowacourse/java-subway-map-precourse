package subway.domain;

import java.util.Scanner;

public class UserInterface {
    private static final String HASH = "## ";
    private static final String GIVE_ME_STATION_NAME = "등록할 역 이름을 입력하세요.";

    public static String getStationName(Scanner scanner) {
        System.out.print(HASH);
        System.out.println(GIVE_ME_STATION_NAME);
        String input = scanner.next();
        return Exception.passNameExceptionTest(input);
    }
}
