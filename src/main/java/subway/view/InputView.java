package subway.view;

import java.util.Scanner;

public class InputView {
    private static final String ERR_SHORT_STRING = "입력값의 길이가 짧습니다.";
    private static final String ERR_CONTAIN_SPACE = "입력값이 공백을 포함하면 안됩니다.";
    private static final String ERR_NOT_INTEGER = "입력값은 정수값이여야 합니다.";
    private static final String ERR_NOT_POSITIVE = "입력값은 양수여야 합니다";
    private static final String ERR_NOT_SUBWAY_LINE_NAME_PATTERN = "잘못된 형식의 이름입니다.";
    private static final int MIN_STATION_LENGTH = 2;
    private static final int MIN_LINE_LENGTH = 2;
    final private static String SUBWAY_LINE_NAME_PATTERN = "^[가-힣0-9]+[\\s]?[가-힣0-9]+$";
    private static final Scanner scanner = new Scanner(System.in);

    private InputView() {
    }

    public static int getOrder() {
        int number = getInt();
        if (number <= 0) {
            throw new IllegalArgumentException(ERR_NOT_POSITIVE);
        }
        return number;
    }

    private static int getInt() {
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ERR_NOT_INTEGER);
        }
    }

    public static String getAnswer() {
        return scanner.nextLine().strip();
    }

    public static String getStationName() {
        String stationName = scanner.nextLine().strip();
        validateStringLength(stationName, MIN_STATION_LENGTH);
        validateSubwayNamePattern(stationName);
        return stationName;
    }

    public static String getLineName() {
        String lineName = scanner.nextLine().strip();
        validateStringLength(lineName, MIN_LINE_LENGTH);
        validateSubwayNamePattern(lineName);
        return lineName;
    }

    private static void validateStringLength(String string, int minLength) {
        if (string.length() < minLength) {
            throw new IllegalArgumentException(ERR_SHORT_STRING);
        }
    }

    public static void validateSubwayNamePattern(String string) {
        if (!string.matches(SUBWAY_LINE_NAME_PATTERN)) {
            throw new IllegalArgumentException(ERR_NOT_SUBWAY_LINE_NAME_PATTERN);
        }
    }
}
