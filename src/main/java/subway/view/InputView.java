package subway.view;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputView {
    private final String ERR_SHORT_STRING = "입력값의 길이가 짧습니다.";
    private final String ERR_CONTAIN_SPACE = "입력값이 공백을 포함하면 안됩니다.";
    private final String ERR_NOT_INTEGER = "입력값은 정수값이여야 합니다.";
    private final String ERR_NOT_POSITIVE = "입력값은 양수여야 합니다";
    private final int MIN_STATION_LENGTH = 2;
    private final int MIN_LINE_LENGTH = 2;
    private final String SPACE = " ";
    private final Scanner scanner;

    public InputView(Scanner scanner) {
        this.scanner = scanner;
    }

    public int getOrder() {
        int number = getInt();
        if (number <= 0) {
            throw new IllegalArgumentException(ERR_NOT_POSITIVE);
        }
        return number;
    }

    private int getInt() {
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ERR_NOT_INTEGER);
        }
    }

    public String getAnswer() {
        return scanner.nextLine().strip();
    }

    public String getStationName() {
        String stationName = scanner.nextLine().strip();
        validateStringLength(stationName, MIN_STATION_LENGTH);
        validateContainSpace(stationName);
        return stationName;
    }

    public String getLineName() {
        String lineName = scanner.nextLine().strip();
        validateStringLength(lineName, MIN_LINE_LENGTH);
        validateContainSpace(lineName);
        return lineName;
    }

    private void validateStringLength(String string, int minLength) {
        if (string.length() < minLength) {
            throw new IllegalArgumentException(ERR_SHORT_STRING);
        }
    }

    private void validateContainSpace(String string) {
        if (string.contains(SPACE)) {
            throw new IllegalArgumentException(ERR_CONTAIN_SPACE);
        }
    }
}
