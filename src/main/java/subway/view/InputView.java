package subway.view;

import subway.domain.LineRepository;
import subway.domain.SectionRepository;
import subway.domain.StationRepository;
import subway.view.resource.Screen;

import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public class InputView {
    private static final String ERROR_HEADER = "[ERROR] ";
    private static final String INVALID_FUNCTION_ERROR_MESSAGE = "선택할 수 없는 기능입니다.";
    private static final String NOT_LETTER_ERROR_MESSAGE = " 올바른 이름이 아닙니다.";
    private static final String INVALID_LENGTH_ERROR_MESSAGE = " 이름은 2자 이상이어야 합니다.";
    private static final String INVALID_STATION_LAST_CHAR = "이름의 마지막 글자는 '%c'으로 끝나야 합니다.";
    private static final String EXISTING_STATION_ERROR_MESSAGE = "이미 등록된 역 이름입니다.";
    private static final String NOT_EXISTING_STATION_ERROR_MESSAGE = "등록되지 않은 역 이름입니다.";
    private static final String NOT_EXISTING_LINE_ERROR_MESSAGE = "등록되지 않은 노선 이름입니다.";
    private static final String EXISTING_IN_SECTION_ERROR_MESSAGE = "노선에 등록된 역입니다.";
    private static final String EQUAL_STATION_ERROR_MESSAGE = "상행 종점역과 하행 종점역이 같습니다.";
    private static final String NOT_DIGIT_ERROR_MESSAGE = "순서는 숫자여야 합니다.";
    private static final String INVALID_RANGE_ERROR_MESSAGE = "순서는 1에서 구간의 길이 -1까지여야 합니다.";
    private static final String LESS_THAN_MIN_STATION_ERROR_MESSAGE = "선택한 노선의 역 개수가 2개 이하입니다.";
    private static final String REGEX_LETTER = "^[0-9가-힣]*$";
    private static final String STATION = "역";
    private static final String LINE = "노선";
    private static final char STATION_LAST_CHAR = '역';
    private static final char LINE_LAST_CHAR = '선';
    private static final int MIN_VALUE_LENGTH = 2;
    private static final int START_INDEX = 1;
    private static final int MIN_STATION_OF_SECTION = 2;

    private static final Scanner scanner = new Scanner(System.in);

    private InputView() {
    }

    public static void closeScanner() {
        scanner.close();
    }

    public static String getInputFunctionIndex(List<String> functionIndexList) {
        return validateFunctionIndex(functionIndexList, scanner.nextLine());
    }

    public static String getInputRegisterStation() {
        return validateRegisterStation(scanner.nextLine());
    }

    public static String getInputRegisterFirstStation(String line) {
        return validateRegisterFirstStation(line, scanner.nextLine());
    }

    public static String getInputRegisterLastStation(String line, String firstStation) {
        return validateRegisterLastStation(line, firstStation, scanner.nextLine());
    }

    public static String getInputDeleteStation() {
        return validateDeleteStation(scanner.nextLine());
    }

    public static String getInputRegisterLine() {
        return validateRegisterLine(scanner.nextLine());
    }

    public static String getInputDeleteLine() {
        return validateDeleteLine(scanner.nextLine());
    }

    public static int getInputIndex(int length) {
        return validateIndex(length, converseStringToInt(scanner.nextLine()));
    }

    public static String getInputLineOfDeleteSection() {
        return validateLineOfDeleteSection(scanner.nextLine());
    }

    public static String getInputStationOfDeleteSection() {
        return validateStationOfDeleteSection(scanner.nextLine());
    }

    private static String validateFunctionIndex(List<String> indexList, String functionIndex) {
        if (!indexList.contains(functionIndex)) {
            throw new IllegalArgumentException(ERROR_HEADER + INVALID_FUNCTION_ERROR_MESSAGE);
        }
        return functionIndex;
    }

    private static String validateRegisterStation(String station) {
        validateStationLine(station);
        if (isInvalidLastChar(Screen.STATION.getName(), station)) {
            throw new IllegalArgumentException(ERROR_HEADER +
                    String.format(INVALID_STATION_LAST_CHAR, STATION_LAST_CHAR));
        }
        if (isExistingStation(station)) {
            throw new IllegalArgumentException(ERROR_HEADER + EXISTING_STATION_ERROR_MESSAGE);
        }
        return station;
    }

    private static String validateRegisterFirstStation(String line, String station) {
        if (!isExistingStation(station)) {
            throw new IllegalArgumentException(ERROR_HEADER + NOT_EXISTING_STATION_ERROR_MESSAGE);
        }
        if (SectionRepository.searchStationInLine(line, station)) {
            throw new IllegalArgumentException(ERROR_HEADER + EXISTING_IN_SECTION_ERROR_MESSAGE);
        }
        return station;
    }

    private static String validateRegisterLastStation(String line, String firstStation, String station) {
        if (firstStation.equals(station)) {
            throw new IllegalArgumentException(ERROR_HEADER + EQUAL_STATION_ERROR_MESSAGE);
        }
        if (!isExistingStation(station)) {
            throw new IllegalArgumentException(ERROR_HEADER + NOT_EXISTING_STATION_ERROR_MESSAGE);
        }
        if (SectionRepository.searchStationInLine(line, station)) {
            throw new IllegalArgumentException(ERROR_HEADER + EXISTING_IN_SECTION_ERROR_MESSAGE);
        }
        return station;
    }

    private static String validateDeleteStation(String station) {
        if (!isExistingStation(station)) {
            throw new IllegalArgumentException(ERROR_HEADER + NOT_EXISTING_STATION_ERROR_MESSAGE);
        }
        if (isExistInSection(station)) {
            throw new IllegalArgumentException(ERROR_HEADER + EXISTING_IN_SECTION_ERROR_MESSAGE);
        }
        return station;
    }

    private static String validateRegisterLine(String line) {
        validateStationLine(line);
        if (isInvalidLastChar(Screen.LINE.getName(), line)) {
            throw new IllegalArgumentException(ERROR_HEADER +
                    String.format(INVALID_STATION_LAST_CHAR, LINE_LAST_CHAR));
        }
        if (isExistingLine(line)) {
            throw new IllegalArgumentException(ERROR_HEADER + NOT_EXISTING_LINE_ERROR_MESSAGE);
        }
        return line;
    }

    private static String validateDeleteLine(String line) {
        if (!isExistingLine(line)) {
            throw new IllegalArgumentException(ERROR_HEADER + NOT_EXISTING_LINE_ERROR_MESSAGE);
        }
        return line;
    }

    private static void validateStationLine(String value) {
        if (isNotLetter(value)) {
            throw new IllegalArgumentException(ERROR_HEADER + NOT_LETTER_ERROR_MESSAGE);
        }
        if (isInvalidLength(value)) {
            throw new IllegalArgumentException(ERROR_HEADER + INVALID_LENGTH_ERROR_MESSAGE);
        }
    }

    private static int validateIndex(int length, int index) {
        if ((index < START_INDEX) || (index > length + 1)) {
            throw new IllegalArgumentException(ERROR_HEADER + INVALID_RANGE_ERROR_MESSAGE);
        }
        return index;
    }

    private static String validateLineOfDeleteSection(String line) {
        if (!isExistingLine(line)) {
            throw new IllegalArgumentException(ERROR_HEADER + NOT_EXISTING_LINE_ERROR_MESSAGE);
        }
        if (SectionRepository.getLengthByLineName(line) <= MIN_STATION_OF_SECTION) {
            throw new IllegalArgumentException(ERROR_HEADER + LESS_THAN_MIN_STATION_ERROR_MESSAGE);
        }
        return line;
    }

    private static String validateStationOfDeleteSection(String station) {
        if (!isExistingStation(station)) {
            throw new IllegalArgumentException(ERROR_HEADER + NOT_EXISTING_STATION_ERROR_MESSAGE);
        }
        return station;
    }

    private static boolean isNotLetter(String value) {
        return !Pattern.matches(REGEX_LETTER, value);
    }

    private static boolean isInvalidLength(String value) {
        return value.length() < MIN_VALUE_LENGTH;
    }

    private static boolean isExistingStation(String station) {
        return StationRepository.stations()
                .stream()
                .anyMatch(
                        s -> s.getName()
                                .equals(station)
                );
    }

    private static boolean isExistingLine(String line) {
        return LineRepository.lines()
                .stream()
                .anyMatch(
                        s -> s.getName()
                                .equals(line)
                );
    }

    private static boolean isInvalidLastChar(String screenName, String station) {
        if (screenName == STATION) {
            return station.charAt(station.length() - 1) != STATION_LAST_CHAR;
        }
        if (screenName == LINE) {
            return station.charAt(station.length() - 1) != LINE_LAST_CHAR;
        }
        return true;
    }

    private static boolean isExistInSection(String station) {
        for (String key : SectionRepository.sections().keySet()) {
            if (SectionRepository.sections().get(key).contains(station)) {
                return true;
            }
        }
        return false;
    }

    private static int converseStringToInt(String value) {
        try {
            return Integer.parseInt(value);
        } catch (Exception e) {
            throw new IllegalArgumentException(ERROR_HEADER + NOT_DIGIT_ERROR_MESSAGE);
        }
    }

}
