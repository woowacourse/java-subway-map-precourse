package subway.domain;

import java.util.Scanner;

public class UserInput {
    private static final String HASH = "## ";
    private static final String GIVE_ME_STATION_NAME = "등록할 역 이름을 입력하세요.";

    public static String stationName(Scanner scanner) {
        System.out.print(HASH);
        System.out.println(GIVE_ME_STATION_NAME);
        String input = scanner.next();
        return input;
    }
}
