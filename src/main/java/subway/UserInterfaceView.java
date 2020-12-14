package subway;

import java.util.Arrays;
import java.util.Scanner;

public class UserInterfaceView {

    private static final String MAIN_VIEW = "## 메인 화면";
    private static final String STATION_MANAGEMENT = "1. 역 관리";
    private static final String LINE_MANAGEMENT = "2. 노선 관리";
    private static final String SECTION_MANAGEMENT = "3. 구간 관리";
    private static final String SUBWAY_LINES_PRINT = "4. 지하철 노선도 출력";
    private static final String QUIT = "Q. 종료";
    private static final String[] MAIN_INTERFACE = {MAIN_VIEW, STATION_MANAGEMENT, LINE_MANAGEMENT,
        SECTION_MANAGEMENT, SUBWAY_LINES_PRINT, QUIT};
    private static final String STATION_MANAGEMENT_VIEW = "## 역 관리 화면";
    private static final String STATION_ADD = "1. 역 등록";
    private static final String STATION_DELETE = "2. 역 삭제";
    private static final String STATION_PRINT = "3. 역 조회";
    private static final String BACK = "B. 돌아가기";
    private static final String[] STATION_INTERFACE = {STATION_MANAGEMENT_VIEW, STATION_ADD,
        STATION_DELETE, STATION_PRINT, BACK};
    private static final String LINE_VIEW = "## 노선 관리 화면";
    private static final String LINE_ADD = "1. 노선 등록";
    private static final String LINE_DELETE = "2. 노선 삭제";
    private static final String LINE_PRINT = "3. 노선 조회";
    private static final String[] LINE_INTERFACE = {LINE_VIEW, LINE_ADD, LINE_DELETE, LINE_PRINT,
        BACK};
    private static final String CHOICE_FUNCTION = "## 원하는 기능을 선택하세요.";
    private static final String SECTION_ADD = "1. 구간 등록";
    private static final String SECTION_DELETE = "2. 구간 삭제";
    private static final String[] SECTION_INTERFACE = {SECTION_ADD, SECTION_DELETE, BACK};
    private static final String ONE_STRING = "1";
    private static final String TWO_STRING = "2";
    private static final String THREE_STRING = "3";
    private static final String FOUR_STRING = "4";
    private static final String B = "B";
    private static final String Q = "Q";
    private static final String FUNCTION_ERROR_MESSAGE = OutPut.ERROR + "선택할 수 없는 기능입니다.\n";
    private static final String[] MAIN_CHOICE_LIST = {ONE_STRING, TWO_STRING, THREE_STRING,
        FOUR_STRING, Q};
    private static final String[] STATION_AND_LINE_CHOICE_LIST = {ONE_STRING, TWO_STRING,
        THREE_STRING, B};
    private static final String[] SECTION_LIST = {ONE_STRING, TWO_STRING, B};
    private static final String STATION_LIST = "## 역 목록";
    private static final String LINE_LIST = "## 노선 목록";
    private static final String SUBWAY_LINES_LIST = "## 지하철 노선도";
    private static final String INPUT_ADD_STATION_NAME = "## 등록할 역 이름을 입력하세요.";
    private static final String INPUT_DELETE_STATION_NAME = "## 삭제할 역 이름을 입력하세요.";
    private static final String INPUT_ADD_LINE_NAME = "## 등록할 노선 이름을 입력하세요.";
    private static final String INPUT_LINE_IN_FIRST_STATION = "## 등록할 노선의 상행 종점역 이름을 입력하세요.";
    private static final String INPUT_LINE_IN_LAST_STATION = "## 등록할 노선의 하행 종점역 이름을 입력하세요.";
    private static final String INPUT_DELETE_LINE_NAME = "## 삭제할 노선 이름을 입력하세요.";
    private static final String INPUT_SECTION_LINE_NAME = "## 노선을 입력하세요.";
    private static final String INPUT_SECTION_STATION_NAME = "## 역이름을 입력하세요.";
    private static final String INPUT_SECTION_ORDER = "## 순서를 입력하세요.";
    private static final String INPUT_SECTION_DELETE_LINE_NAME = "## 삭제할 구간의 노선을 입력하세요.";
    private static final String INPUT_SECTION_DELETE_STATION_NAME = "## 삭제할 구간의 역을 입력하세요.";
    private static final String INPUT_TYPE_ERROR = OutPut.ERROR + "숫자만 입력이 가능합니다.\n";
    private static final String INPUT_NUMBER_ERROR = OutPut.ERROR + "음수는 입력이 불가능합니다.\n";
    private static final int ZERO = 0;

    private Scanner scanner;

    public UserInterfaceView(Scanner scanner) {
        this.scanner = scanner;
    }

    public void start() {
        while (true) {
            if (mainStartAndReturnIsQuit()) {
                break;
            }
        }
    }

    public boolean mainStartAndReturnIsQuit() {
        printMainView();
        String userInput;
        while (true) {
            userInput = getUserInput(CHOICE_FUNCTION);
            if (Arrays.asList(MAIN_CHOICE_LIST).contains(userInput)) {
                break;
            }
            printErrorMessage();
        }
        if (isQuit(userInput)) {
            return true;
        }
        mainToNextFunction(userInput);
        return false;
    }

    private void printMainView() {
        for (String str : MAIN_INTERFACE) {
            System.out.println(str);
        }
        System.out.println();
    }

    private String getUserInput(String str) {
        System.out.println(str);
        String userInput = scanner.next();
        System.out.println();
        return userInput;
    }

    private void printErrorMessage() {
        System.out.println(FUNCTION_ERROR_MESSAGE);
    }

    private boolean isQuit(String userInput) {
        return Q.equals(userInput);
    }

    private void mainToNextFunction(String userInput) {
        if (ONE_STRING.equals(userInput)) {
            stationStart();
            return;
        }
        if (TWO_STRING.equals(userInput)) {
            lineStart();
            return;
        }
        if (THREE_STRING.equals(userInput)) {
            return;
        }
        if (FOUR_STRING.equals(userInput)) {
        }
    }

    private void stationStart() {
        printStationView();
        String userInput;
        while (true) {
            userInput = getUserInput(CHOICE_FUNCTION);
            if (Arrays.asList(STATION_AND_LINE_CHOICE_LIST).contains(userInput)) {
                break;
            }
            printErrorMessage();
        }
        stationToNextFunction(userInput);
    }

    private void printStationView() {
        for (String str : STATION_INTERFACE) {
            System.out.println(str);
        }
        System.out.println();
    }

    private void stationToNextFunction(String userInput) {
        if (ONE_STRING.equals(userInput)) {
            addStation();
            return;
        }
        if (TWO_STRING.equals(userInput)) {
            deleteStation();
            return;
        }
        if (THREE_STRING.equals(userInput)) {
            printStation();
        }
    }

    private void addStation() {
        String stationName = getUserInput(INPUT_ADD_STATION_NAME);
        if (!StationService.addStation(stationName, true)) {
            stationStart();
        }
    }

    private void deleteStation() {
        String stationName = getUserInput(INPUT_DELETE_STATION_NAME);
        if (!StationService.deleteStation(stationName)) {
            stationStart();
        }
    }

    private void printStation() {
        System.out.println(STATION_LIST);
        StationService.print();
        System.out.println();
    }

    private void lineStart() {
        printLineView();
        String userInput;
        while (true) {
            userInput = getUserInput(CHOICE_FUNCTION);
            if (Arrays.asList(STATION_AND_LINE_CHOICE_LIST).contains(userInput)) {
                break;
            }
            printErrorMessage();
        }
    }

    private void printLineView() {
        for (String str : LINE_INTERFACE) {
            System.out.println(str);
        }
        System.out.println();
    }
}
