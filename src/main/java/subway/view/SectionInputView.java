package subway.view;

import subway.domain.Line;
import subway.domain.LineRepository;
import subway.domain.StationRepository;
import subway.type.SectionScreenFunctionType;

import java.util.Scanner;

public class SectionInputView {
    private static final String SELECT_MESSAGE = "## 원하는 기능을 선택하세요.";
    private static final String CANNOT_SELECT_MESSAGE = "[ERROR] 선택할 수 없는 기능입니다.";
    private static final String INPUT_LINE_MESSAGE = "## 노선을 입력하세요.";
    private static final String INPUT_STATION_MESSAGE = "## 역 이름을 입력하세요.";
    private static final String STATION_NOT_ON_LINE_MESSAGE = "[ERROR] 노선에 해당 역이 존재하지 않습니다.";
    private static final int INTEGER_ONE = 1;
    private static final char BACK = 'B';
    private static final int FIRST_CHARACTER = 0;
    private static final char ONE = '1';
    private static final char TWO = '2';

    private static final Scanner scanner = new Scanner(System.in);

    private SectionInputView() {
    }

    public static void getSectionScreenUserSelection() {
        SectionOutputView.printManageSectionScreen();
        System.out.println(SELECT_MESSAGE);
        String userInput = scanner.nextLine();
        try {
            validateUserInput(userInput);
            if (isUserInputBack(userInput.charAt(FIRST_CHARACTER))) {
                MainScreenInputView.getMainScreenUserSelection(scanner);
                return;
            }
            executeFunction(userInput);
        } catch (Exception e) {
            System.out.println();
            System.out.println(e.getMessage());
            getSectionScreenUserSelection();
        }
    }

    private static void executeFunction(String userInput) {
        for (SectionScreenFunctionType sectionScreenFunctionType : SectionScreenFunctionType.values()) {
            if (sectionScreenFunctionType.isSameFunctionCode(Integer.parseInt(userInput))) {
                sectionScreenFunctionType.execute();
            }
        }
    }

    private static boolean isUserInputBack(char userInput) {
        return Character.toUpperCase(userInput) == BACK;
    }

    private static void validateUserInput(String userInput) {
        validateUserInputLength(userInput);
        char characterizedUserInput = userInput.charAt(FIRST_CHARACTER);
        if (!isUserInputBack(characterizedUserInput)) {
            validateUserInputRange(characterizedUserInput);
        }
    }

    private static void validateUserInputLength(String userInput) {
        if (userInput.length() != INTEGER_ONE) {
            System.out.println(userInput.length());
            throw new IllegalArgumentException(CANNOT_SELECT_MESSAGE);
        }
    }

    private static void validateUserInputRange(char userInput) {
        if ((userInput < ONE || userInput > TWO)) {
            throw new IllegalArgumentException(CANNOT_SELECT_MESSAGE);
        }
    }

    public static void registerSection() { // TODO 순서가 노선 size 넘어가면 안됨
        try {
            String lineName = getLineName();
            String stationName = getStationName();
            validateStationRegisteredOnLine(lineName, stationName);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private static String getLineName() {
        System.out.println(INPUT_LINE_MESSAGE);
        String lineName = scanner.nextLine();
        LineRepository.isLineExist(lineName);
        return lineName;
    }

    private static String getStationName() {
        System.out.println(INPUT_STATION_MESSAGE);
        String stationName = scanner.nextLine();
        validateStationExistence(stationName);
        return stationName;
    }

    private static void validateStationExistence(String stationName) {
        if (!StationRepository.isStationExist(stationName)) {
            throw new IllegalArgumentException("존재하지 않는 역입니다.");
        }
    }

    private static void validateStationRegisteredOnLine(String lineName, String stationName) {
        for (Line line : LineRepository.lines()) {
            if (line.getName().equals(lineName) && line.isStationRegistered(stationName)) {
                throw new IllegalArgumentException("[ERROR] 노선에 이미 등록되어 있는 역이므로 등록이 불가능합니다.");
            }
        }
    }

    public static void removeSection() {

    }
}
