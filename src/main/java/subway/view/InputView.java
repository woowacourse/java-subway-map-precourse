package subway.view;

import subway.domain.LineRepository;
import subway.domain.SectionRepository;
import subway.domain.StationRepository;
import subway.view.resource.ErrorCode;
import subway.view.resource.Message;
import subway.view.resource.Screen;

import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public class InputView {
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
        OutputView.printMessage(Message.INPUT_FUNCTION_INDEX);
        return validateFunctionIndex(functionIndexList, scanner.nextLine());
    }

    public static String getInputRegisterStation() {
        OutputView.printMessage(Message.INPUT_REGISTER_STATION_NAME);
        return validateRegisterStation(scanner.nextLine());
    }

    public static String getInputRegisterFirstStation(String line) {
        OutputView.printMessage(Message.INPUT_REGISTER_FIRST_STATION);
        return validateRegisterFirstStation(line, scanner.nextLine());
    }

    public static String getInputRegisterLastStation(String line, String firstStation) {
        OutputView.printMessage(Message.INPUT_REGISTER_LAST_STATION);
        return validateRegisterLastStation(line, firstStation, scanner.nextLine());
    }

    public static String getInputDeleteStation() {
        OutputView.printMessage(Message.INPUT_DELETE_STATION_NAME);
        return validateDeleteStation(scanner.nextLine());
    }

    public static String getInputRegisterLine() {
        OutputView.printMessage(Message.INPUT_REGISTER_LINE_NAME);
        return validateRegisterLine(scanner.nextLine());
    }

    public static String getInputDeleteLine() {
        OutputView.printMessage(Message.INPUT_DELETE_LINE_NAME);
        return validateDeleteLine(scanner.nextLine());
    }

    public static String getInputRegisterLineInSection() {
        OutputView.printMessage(Message.INPUT_LINE);
        return validateRegisterLineInSection(scanner.nextLine());
    }

    public static int getInputIndex(int length) {
        OutputView.printMessage(Message.INPUT_INDEX);
        return validateIndex(length, converseStringToInt(scanner.nextLine(), length));
    }

    public static String getInputLineOfDeleteSection() {
        OutputView.printMessage(Message.INPUT_LINE_OF_DELETE_SECTION);
        return validateLineOfDeleteSection(scanner.nextLine());
    }

    public static String getInputStationOfDeleteSection() {
        OutputView.printMessage(Message.INPUT_STATION_OF_DELETE_SECTION);
        return validateStationOfDeleteSection(scanner.nextLine());
    }

    private static String validateFunctionIndex(List<String> indexList, String functionIndex) {
        if (!indexList.contains(functionIndex)) {
            OutputView.printErrorMessage(ErrorCode.INVALID_FUNCTION);
            return getInputFunctionIndex(indexList);
        }
        return functionIndex;
    }

    private static String validateRegisterStation(String station) {
        if (!isValidString(station)) {
            return getInputRegisterStation();
        }
        if (isInvalidLastChar(Screen.STATION.getName(), station)) {
            OutputView.printErrorMessage(ErrorCode.INVALID_STATION_LAST_CHAR);
            return getInputRegisterStation();
        }
        if (isExistingStation(station)) {
            OutputView.printErrorMessage(ErrorCode.EXISTING_STATION);
            return getInputRegisterStation();
        }
        return station;
    }

    private static String validateRegisterFirstStation(String line, String station) {
        if (!isExistingStation(station)) {
            OutputView.printErrorMessage(ErrorCode.NOT_EXISTING_STATION);
            return getInputRegisterFirstStation(line);
        }
        if (SectionRepository.searchStationInLine(line, station)) {
            OutputView.printErrorMessage(ErrorCode.EXISTING_STATION_IN_SECTION);
            return getInputRegisterFirstStation(line);
        }
        return station;
    }

    private static String validateRegisterLastStation(String line, String firstStation, String station) {
        if (firstStation.equals(station)) {
            OutputView.printErrorMessage(ErrorCode.EQUAL_STATION_FIRST_AND_LAST);
            return getInputRegisterLastStation(line, firstStation);
        }
        if (!isExistingStation(station)) {
            OutputView.printErrorMessage(ErrorCode.NOT_EXISTING_STATION);
            return getInputRegisterLastStation(line, firstStation);
        }
        if (SectionRepository.searchStationInLine(line, station)) {
            OutputView.printErrorMessage(ErrorCode.EXISTING_STATION_IN_SECTION);
            return getInputRegisterLastStation(line, firstStation);
        }
        return station;
    }

    private static String validateDeleteStation(String station) {
        if (!isExistingStation(station)) {
            OutputView.printErrorMessage(ErrorCode.NOT_EXISTING_STATION);
            return getInputDeleteStation();
        }
        if (isExistInSection(station)) {
            OutputView.printErrorMessage(ErrorCode.REGISTERED_ON_LINE);
            return getInputDeleteStation();
        }
        return station;
    }

    private static String validateRegisterLine(String line) {
        if (!isValidString(line)) {
            return getInputRegisterLine();
        }
        if (isInvalidLastChar(Screen.LINE.getName(), line)) {
            OutputView.printErrorMessage(ErrorCode.INVALID_LINE_LAST_CHAR);
            return getInputRegisterLine();
        }
        if (isExistingLine(line)) {
            OutputView.printErrorMessage(ErrorCode.NOT_EXISTING_LINE);
            return getInputRegisterLine();
        }
        return line;
    }

    private static String validateDeleteLine(String line) {
        if (!isExistingLine(line)) {
            OutputView.printErrorMessage(ErrorCode.NOT_EXISTING_LINE);
            return getInputDeleteLine();
        }
        return line;
    }

    private static String validateRegisterLineInSection(String line) {
        if (!isExistingLine(line)) {
            OutputView.printErrorMessage(ErrorCode.NOT_EXISTING_LINE);
            return getInputRegisterLineInSection();
        }
        return line;
    }

    private static int validateIndex(int length, int index) {
        if ((index < START_INDEX) || (index > length + 1)) {
            OutputView.printErrorMessage(ErrorCode.INVALID_INDEX_RANGE);
            return getInputIndex(length);
        }
        return index;
    }

    private static String validateLineOfDeleteSection(String line) {
        if (!isExistingLine(line)) {
            OutputView.printErrorMessage(ErrorCode.NOT_EXISTING_LINE);
            return getInputLineOfDeleteSection();
        }
        if (SectionRepository.getLengthByLineName(line) <= MIN_STATION_OF_SECTION) {
            OutputView.printErrorMessage(ErrorCode.LESS_THAN_MIN_STATION);
            return getInputLineOfDeleteSection();
        }
        return line;
    }

    private static String validateStationOfDeleteSection(String station) {
        if (!isExistingStation(station)) {
            OutputView.printErrorMessage(ErrorCode.NOT_EXISTING_STATION);
            return getInputStationOfDeleteSection();
        }
        return station;
    }

    private static boolean isValidString(String value) {
        if (isNotLetter(value)) {
            OutputView.printErrorMessage(ErrorCode.NOT_LETTER);
            return false;
        }
        if (isInvalidLength(value)) {
            OutputView.printErrorMessage(ErrorCode.INVALID_NAME_LENGTH);
            return false;
        }
        return true;
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

    private static int converseStringToInt(String value, int length) {
        try {
            return Integer.parseInt(value);
        } catch (Exception e) {
            OutputView.printErrorMessage(ErrorCode.NOT_DIGIT);
            getInputIndex(length);
        }
        return Integer.parseInt(value);
    }

}
