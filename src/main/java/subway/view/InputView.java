package subway.view;

import subway.domain.LineRepository;
import subway.domain.SectionRepository;
import subway.domain.StationRepository;
import subway.view.text.LineText;
import subway.view.text.StationText;

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

    private final Scanner scanner;

    public InputView(Scanner scanner) {
        this.scanner = scanner;
    }

    public String getInputFunctionIndex(List<String> functionIndexList) {
        return validateInputFunctionIndex(functionIndexList, scanner.nextLine());
    }

    public String getInputRegisterStation() {
        return validateInputRegisterStation(scanner.nextLine());
    }

    public String getInputRegisterStationForSection(String line) {
        return validateInputRegisterStationForSection(line, scanner.nextLine());
    }

    public String getInputRegisterStationForSection(String line, String firstStation) {
        return validateInputRegisterStationForSection(line, firstStation, scanner.nextLine());
    }

    public String getInputDeleteStation() {
        return validateInputDeleteStation(scanner.nextLine());
    }

    public String getInputRegisterLine() {
        return validateInputRegisterLine(scanner.nextLine());
    }

    public String getInputDeleteLine() {
        return validateInputDeleteLine(scanner.nextLine());
    }

    public int getInputIndex(int length) {
        return validateInputIndex(length, converseStringToInt(scanner.nextLine()));
    }

    public String getInputLineOfDeleteSection() {
        return validateInputLineOfDeleteSection(scanner.nextLine());
    }

    public String getInputStationOfDeleteSection() {
        return validateInputStationOfDeleteSection(scanner.nextLine());
    }

    public String validateInputFunctionIndex(List<String> functionIndexList, String functionIndex) {
        if (!functionIndexList.contains(functionIndex)) {
            throw new IllegalArgumentException(ERROR_HEADER + INVALID_FUNCTION_ERROR_MESSAGE);
        }
        return functionIndex;
    }

    public String validateInputRegisterStation(String station) {
        validateInputStationLine(station);
        if (isInvalidLastChar(StationText.screenName(), station)) {
            throw new IllegalArgumentException(ERROR_HEADER +
                    String.format(INVALID_STATION_LAST_CHAR, STATION_LAST_CHAR));
        }
        if (isExistingStation(station)) {
            throw new IllegalArgumentException(ERROR_HEADER + EXISTING_STATION_ERROR_MESSAGE);
        }
        return station;
    }

    public String validateInputRegisterStationForSection(String line, String station) {
        if (!isExistingStation(station)) {
            throw new IllegalArgumentException(ERROR_HEADER + NOT_EXISTING_STATION_ERROR_MESSAGE);
        }
        if (SectionRepository.searchStationInLine(line, station)) {
            throw new IllegalArgumentException(ERROR_HEADER + EXISTING_IN_SECTION_ERROR_MESSAGE);
        }
        return station;
    }

    public String validateInputRegisterStationForSection(String line, String firstStation, String station) {
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

    public String validateInputDeleteStation(String station) {
        if (!isExistingStation(station)) {
            throw new IllegalArgumentException(ERROR_HEADER + NOT_EXISTING_STATION_ERROR_MESSAGE);
        }
        if (isExistInSection(station)) {
            throw new IllegalArgumentException(ERROR_HEADER + EXISTING_IN_SECTION_ERROR_MESSAGE);
        }
        return station;
    }

    public String validateInputRegisterLine(String line) {
        validateInputStationLine(line);
        if (isInvalidLastChar(LineText.screenName(), line)) {
            throw new IllegalArgumentException(ERROR_HEADER +
                    String.format(INVALID_STATION_LAST_CHAR, LINE_LAST_CHAR));
        }
        if (isExistingLine(line)) {
            throw new IllegalArgumentException(ERROR_HEADER + NOT_EXISTING_LINE_ERROR_MESSAGE);
        }
        return line;
    }

    public String validateInputDeleteLine(String line) {
        if (!isExistingLine(line)) {
            throw new IllegalArgumentException(ERROR_HEADER + NOT_EXISTING_LINE_ERROR_MESSAGE);
        }
        return line;
    }

    private void validateInputStationLine(String value) {
        if (isNotLetter(value)) {
            throw new IllegalArgumentException(ERROR_HEADER + NOT_LETTER_ERROR_MESSAGE);
        }
        if (isInvalidLength(value)) {
            throw new IllegalArgumentException(ERROR_HEADER + INVALID_LENGTH_ERROR_MESSAGE);
        }
    }

    private int validateInputIndex(int length, int index) {
        if ((index < START_INDEX) || (index > length - 1)) {
            throw new IllegalArgumentException(ERROR_HEADER + INVALID_RANGE_ERROR_MESSAGE);
        }
        return index;
    }

    private String validateInputLineOfDeleteSection(String line) {
        if (!isExistingLine(line)) {
            throw new IllegalArgumentException(ERROR_HEADER + NOT_EXISTING_LINE_ERROR_MESSAGE);
        }
        if (SectionRepository.getLengthByLineName(line) <= MIN_STATION_OF_SECTION) {
            throw new IllegalArgumentException(ERROR_HEADER + LESS_THAN_MIN_STATION_ERROR_MESSAGE);
        }
        return line;
    }

    private String validateInputStationOfDeleteSection(String station){
        if(!isExistingStation(station)){
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
