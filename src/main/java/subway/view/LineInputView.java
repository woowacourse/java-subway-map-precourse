package subway.view;

import subway.domain.Line;
import subway.domain.LineRepository;
import subway.domain.Station;
import subway.domain.StationRepository;
import subway.type.LineScreenFunctionType;

import java.util.Scanner;

public class LineInputView {
    private static final String SELECT_MESSAGE = "## 원하는 기능을 선택하세요.";
    private static final String CANNOT_SELECT_MESSAGE = "[ERROR] 선택할 수 없는 기능입니다.";
    private static final String REGISTER_LINE_MESSAGE = "## 등록할 노선 이름을 입력하세요.";
    private static final String REGISTER_COMPLETE_MESSAGE = "[INFO] 지하철 노선이 등록되었습니다.";
    private static final String REMOVE_LINE_MESSAGE = "## 삭제할 노선 이름을 입력하세요.";
    private static final char LINE_NAME_ENDED_WITH = '선';
    private static final String LINE_NAME_LENGTH_MESSAGE = "[ERROR] 노선 이름은 두 글자 이상이어야 합니다.";
    private static final String LINE_NAME_INCLUDE_NOT_KOREAN_MESSAGE = "[ERROR] 노선 이름은 한글이어야 합니다.";
    private static final String LINE_NAME_SHOULD_BE_ENDED_WITH_LINE_MESSAGE = "[ERROR] 노선 이름 맨 뒤에 '선'을 붙여주세요.";
    private static final String LINE_NAME_INCLUDE_NUMBER_MESSAGE = "[ERROR] 노선 이름에 숫자를 포함하면 안 됩니다.";
    private static final String LINE_NAME_INCLUDE_SPACE_MESSAGE = "[ERROR] 노선 이름에 공백을 포함하면 안 됩니다.";
    private static final String LINE_NAME_HAS_DUPLICATION_MESSAGE = "[ERROR] 이미 등록되어 있는 노선입니다.";
    private static final char ONE = '1';
    private static final int INTEGER_ONE = 1;
    private static final char MINIMUM_LINE_NAME_LENGTH = 2;
    private static final char THREE = '3';
    private static final char BACK = 'B';
    private static final String SPACE = " ";
    private static final int FIRST_CHARACTER = 0;
    private static final String KOREAN_REGULAR_EXPRESSION = "^[가-힣]*$";
    private static final String HAS_NUMBER_REGULAR_EXPRESSION = ".*[0-9].*";


    private static final Scanner scanner = new Scanner(System.in);

    private LineInputView() {

    }

    public static void getLineScreenUserSelection() {
        LineOutputView.printManageLineScreen();
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
            getLineScreenUserSelection();
        }
    }

    private static void executeFunction(String userInput) {
        for (LineScreenFunctionType lineScreenFunctionType : LineScreenFunctionType.values()) {
            if (lineScreenFunctionType.isSameFunctionCode(Integer.parseInt(userInput))) {
                lineScreenFunctionType.execute();
            }
        }
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

    private static boolean isUserInputBack(char userInput) {
        return Character.toUpperCase(userInput) == BACK;
    }

    private static void validateUserInputRange(char userInput) {
        if ((userInput < ONE || userInput > THREE)) {
            throw new IllegalArgumentException(CANNOT_SELECT_MESSAGE);
        }
    }

    public static void registerLine() {
        System.out.println(REGISTER_LINE_MESSAGE);
        String lineName = scanner.nextLine();
        try {
            validateLineName(lineName);
            // TODO 상행 종점 입력, 하행 종점 입력받고 존재하는 Station인지 확인하고 add
            Line newLine = new Line(lineName);
            Station upwardTerminalStation = getUpwardTerminalStation();
            Station downwardTerminalStation = getDownwardTerminalStation();
            newLine.registerStation(upwardTerminalStation);
            newLine.registerStation(downwardTerminalStation);
            validateAreStationSame(upwardTerminalStation, downwardTerminalStation);
            LineRepository.addLine(newLine);
            System.out.println(REGISTER_COMPLETE_MESSAGE);
        } catch (Exception e) {
            System.out.println();
            System.out.println(e.getMessage());
            registerLine();
        }
    }

    private static void validateAreStationSame(Station upwardTerminalStation, Station downwardTerminalStation) {
        if (upwardTerminalStation.equals(downwardTerminalStation)) {
            throw new IllegalArgumentException("상행 종점과 하행 종점끼리 같은 역일 수 없습니다.");
        }
    }

    private static Station getUpwardTerminalStation() {
        System.out.println("## 등록할 노선의 상행 종점역 이름을 입력하세요.");
        String upwardTerminalStation = scanner.nextLine();
        try {
            validateStationExistence(upwardTerminalStation);

        } catch (Exception e) {
            System.out.println(e.getMessage());
            getUpwardTerminalStation();
        }
        return new Station(upwardTerminalStation);
    }

    private static Station getDownwardTerminalStation() {
        System.out.println("## 등록할 노선의 하행 종점역 이름을 입력하세요.");
        String downwardTerminalStation = scanner.nextLine();
        try {
            validateStationExistence(downwardTerminalStation);

        } catch (Exception e) {
            System.out.println(e.getMessage());
            getDownwardTerminalStation();
        }
        return new Station(downwardTerminalStation);
    }

    private static void validateStationExistence(String upwardTerminalStation) {
        if (!StationRepository.isStationExist(upwardTerminalStation)) {
            throw new IllegalArgumentException("존재하지 않는 역입니다.");
        }
    }

    public static void removeLine() {
        System.out.println(REMOVE_LINE_MESSAGE);
        String lineName = scanner.nextLine();
        try {
            LineRepository.isLineExist(lineName);
            LineRepository.deleteLineByName(lineName);
        } catch (Exception e) {
            System.out.println();
            System.out.println(e.getMessage());
            getLineScreenUserSelection();
        }
    }

    private static void validateLineName(String lineName) {
        validateLineNameLength(lineName);
        validateLineNameEndedWithLine(lineName);
        validateLineNameHasNumber(lineName);
        validateLineNameHasOnlyKorean(lineName);
        validateLineNameHasSpace(lineName);
        validateLineNameHasDuplication(lineName);
    }

    private static void validateLineNameLength(String lineName) {
        if (lineName.length() < MINIMUM_LINE_NAME_LENGTH) {
            throw new IllegalArgumentException(LINE_NAME_LENGTH_MESSAGE);
        }
    }

    private static void validateLineNameEndedWithLine(String lineName) {
        if (!(lineName.charAt(lineName.length() - INTEGER_ONE) == LINE_NAME_ENDED_WITH)) {
            throw new IllegalArgumentException(LINE_NAME_SHOULD_BE_ENDED_WITH_LINE_MESSAGE);
        }
    }

    private static void validateLineNameHasNumber(String lineName) {
        if (lineName.matches(HAS_NUMBER_REGULAR_EXPRESSION)) {
            throw new IllegalArgumentException(LINE_NAME_INCLUDE_NUMBER_MESSAGE);
        }
    }

    private static void validateLineNameHasOnlyKorean(String lineName) {
        if (!lineName.matches(KOREAN_REGULAR_EXPRESSION)) {
            throw new IllegalArgumentException(LINE_NAME_INCLUDE_NOT_KOREAN_MESSAGE);
        }
    }

    private static void validateLineNameHasSpace(String lineName) {
        if (lineName.contains(SPACE)) {
            throw new IllegalArgumentException(LINE_NAME_INCLUDE_SPACE_MESSAGE);
        }
    }

    private static void validateLineNameHasDuplication(String lineName) {
        for (Line line : LineRepository.lines()) {
            if (line.isSameName(lineName)) {
                throw new IllegalArgumentException(LINE_NAME_HAS_DUPLICATION_MESSAGE);
            }
        }
    }
}
