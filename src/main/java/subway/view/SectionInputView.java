package subway.view;

import subway.domain.Line;
import subway.domain.LineRepository;
import subway.domain.Station;
import subway.domain.StationRepository;
import subway.type.SectionScreenFunctionType;

import java.util.Scanner;

public class SectionInputView {
    private static final String SELECT_MESSAGE = "## 원하는 기능을 선택하세요.";
    private static final String CANNOT_SELECT_MESSAGE = "[ERROR] 선택할 수 없는 기능입니다.";
    private static final String INPUT_LINE_MESSAGE = "## 노선을 입력하세요.";
    private static final String INPUT_STATION_MESSAGE = "## 역 이름을 입력하세요.";
    private static final String INPUT_ORDER_MESSAGE = "## 순서를 입력하세요.";
    private static final String INVALID_ORDER_MESSAGE = "[ERROR] 순서는 양수이며 노선에 포함된 역의 개수 이하여야 합니다.";
    private static final String INVALID_STATION_MESSAGE = "[ERROR] 노선에 이미 등록되어 있는 역이므로 등록이 불가능합니다.";
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
            int order = getOrder(lineName);
            insertStation(lineName, stationName, order);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private static void insertStation(String lineName, String stationName, int order) {
        for (Line line : LineRepository.lines()) {
            if (line.getName().equals(lineName)) {
                line.insert(new Station(stationName), order);
            }
        }
    }

    private static int getOrder(String lineName) {
        System.out.println(INPUT_ORDER_MESSAGE);
        int order = scanner.nextInt();
        if (INTEGER_ONE > order || getSizeOfLine(lineName) < order) {
            throw new IllegalArgumentException(INVALID_ORDER_MESSAGE);
        }
        return order;
    }

    private static int getSizeOfLine(String lineName) {
        for (Line line : LineRepository.lines()) {
            if (line.getName().equals(lineName)) {
                return line.getSize();
            }
        }
        return 0;
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
            throw new IllegalArgumentException(INVALID_ORDER_MESSAGE);
        }
    }

    private static void validateStationRegisteredOnLine(String lineName, String stationName) {
        for (Line line : LineRepository.lines()) {
            if (line.getName().equals(lineName) && line.isStationRegistered(stationName)) {
                throw new IllegalArgumentException(INVALID_STATION_MESSAGE);
            }
        }
    }

    public static void removeSection() {

    }
}
