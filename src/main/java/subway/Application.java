package subway;

import subway.domain.Line;
import subway.domain.LineRepository;
import subway.domain.Station;
import subway.domain.StationRepository;
import subway.domain.Constants;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import static subway.domain.ErrorMessage.displayErrorMessage;

public class Application {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        initialize();
        startProgram(scanner);
    }

    public static void startProgram(Scanner kbd) {
        showMainMenu();
        String mainInput = inputFunction(kbd, Constants.MAIN_FUNCTIONS);
        goSubMenu(mainInput, kbd);
    }

    public static void initialize() {
        initializeStation();
        initializeLine();
    }

    public static void initializeStation() {
        List<String> names = Arrays.asList("교대역", "강남역", "역삼역", "남부터미널역", "양재역", "양재시민의숲역", "매봉역");
        for (String name : names)
            StationRepository.addStation(new Station(name));
    }

    public static void initializeLine() {
        Line line2 = new Line("2호선");
        LineRepository.addLine(line2, Arrays.asList("교대역", "강남역", "역삼역"));
        Line line3 = new Line("3호선");
        LineRepository.addLine(line3, Arrays.asList("교대역", "남부터미널역", "양재역", "매봉역"));
        Line lineSinbundang = new Line("신분당선");
        LineRepository.addLine(lineSinbundang, Arrays.asList("강남역", "양재역", "양재시민의숲역"));
    }

    public static void showMainMenu() {
        System.out.println("\n## 메인 화면");
        System.out.println("1. 역 관리");
        System.out.println("2. 노선 관리");
        System.out.println("3. 구간 관리");
        System.out.println("4. 지하철 노선도 출력");
        System.out.println("Q. 종료");
    }

    public static String inputFunction(Scanner kbd, List<String> functions) {
        String input = "0";
        boolean check = false;
        while(!check) {
            System.out.println("\n## 원하는 기능을 선택하세요.");
            input = kbd.nextLine();
            check = checkInput(input, functions);
        }
        return input;
    }

    public static boolean checkInput(String input, List<String> functions) {
        boolean check = true;
        if (!functions.contains(input)) {
            displayErrorMessage(Constants.FUNCTION_INPUT_ERROR);
            check = false;
        }
        return check;
    }

    public static void goSubMenu(String input, Scanner kbd) {
        System.out.println();
        if (input.equals(Constants.STATION_MENU))
            manageStation(kbd);
        if (input.equals(Constants.LINE_MENU))
            manageLine(kbd);
        if (input.equals(Constants.SECTION_MENU))
            manageSection(kbd);
        if (input.equals(Constants.PRINT_LINES))
            displayAllLines(kbd);
        if (input.equalsIgnoreCase(Constants.FINISH_PROGRAM))
            finishProgram();
    }

    public static void manageStation(Scanner kbd) {
        showStationMenu();
        String input = inputFunction(kbd, Constants.SUB_FUNCTIONS);
        if (input.equals(Constants.ADD_MENU))
            addStation(kbd);
        if (input.equals(Constants.DELETE_MENU))
            deleteStation(kbd);
        if (input.equals(Constants.SEARCH_MENU))
            searchStation(kbd);
        if (input.equalsIgnoreCase(Constants.GO_BACK_MENU))
            startProgram(kbd);
    }

    public static void manageLine(Scanner kbd) {
        showLineMenu();
        String input = inputFunction(kbd, Constants.SUB_FUNCTIONS);
        if (input.equals(Constants.ADD_MENU))
            addLine(kbd);
        if (input.equals(Constants.DELETE_MENU))
            deleteLine(kbd);
        if (input.equals(Constants.SEARCH_MENU))
            searchLine(kbd);
        if (input.equalsIgnoreCase(Constants.GO_BACK_MENU))
            startProgram(kbd);
    }

    public static void manageSection(Scanner kbd) {
        showSectionMenu();
        String input = inputFunction(kbd, Constants.SECTION_FUNCTIONS);
        if (input.equals(Constants.ADD_MENU))
            addSection(kbd);
        if (input.equals(Constants.DELETE_MENU))
            deleteSection(kbd);
        if (input.equals(Constants.GO_BACK_MENU))
            startProgram(kbd);
    }

    public static void addSection(Scanner kbd) {
        try {
            makeNewSection(kbd);
            System.out.println("\n[INFO] 구간이 등록되었습니다.");
            startProgram(kbd);
        } catch (Exception e) {
            startProgram(kbd);
        }
    }

    public static void makeNewSection(Scanner kbd) {
        System.out.println("\n## 노선을 입력하세요.");
        String lineName = kbd.nextLine();
        checkExistLine(lineName);
        System.out.println("\n## 역이름을 입력하세요.");
        String stationName = kbd.nextLine();
        checkExistStation(stationName);
        Line line = checkInSpecificLine(lineName, stationName);
        System.out.println("\n## 순서를 입력하세요.");
        String index = kbd.nextLine();
        checkValidIndex(line, index);
        LineRepository.addStationToLine(lineName, stationName, Integer.parseInt(index));
    }

    public static void deleteSection(Scanner kbd) {
        try {
            System.out.println("\n## 삭제할 구간의 노선을 입력하세요.");
            String lineName = kbd.nextLine();
            checkExistLine(lineName);
            checkValidLine(lineName);
            System.out.println("\n## 삭제할 구간의 역을 입력하세요.");
            String stationName = kbd.nextLine();
            checkNotInSpecificLine(lineName, stationName);
            LineRepository.deleteStationInLine(lineName, stationName);
            System.out.println("\n[INFO] 구간이 삭제되었습니다.");
            startProgram(kbd);
        } catch (Exception e) {
            startProgram(kbd);
        }
    }

    public static void addStation(Scanner kbd) {
        try {
            System.out.println("\n## 등록할 역 이름을 입력하세요.");
            String stationName = kbd.nextLine();
            checkSameStation(stationName);
            checkTextLength(stationName);
            StationRepository.addStation(new Station(stationName));
            System.out.println("\n[INFO] 지하철 역이 등록되었습니다.");
            startProgram(kbd);
        } catch (Exception e) {
            startProgram(kbd);
        }
    }

    public static void deleteStation(Scanner kbd) {
        try {
            System.out.println("\n## 삭제할 역 이름을 입력하세요.");
            String stationName = kbd.nextLine();
            checkExistStation(stationName);
            checkInLine(stationName);
            StationRepository.deleteStation(stationName);
            System.out.println("\n[INFO] 지하철 역이 삭제되었습니다.");
            startProgram(kbd);
        } catch (Exception e) {
            startProgram(kbd);
        }
    }

    public static void searchStation(Scanner kbd) {
        System.out.println("\n## 역 목록");
        for (Station station : StationRepository.stations())
            System.out.println("[INFO] " + station.getName());
        startProgram(kbd);
    }

    public static void addLine(Scanner kbd) {
        try {
            makeNewLine(kbd);
            System.out.println("\n[INFO] 지하철 노선이 등록되었습니다.");
            startProgram(kbd);
        } catch (Exception e) {
            startProgram(kbd);
        }
    }

    public static void makeNewLine(Scanner kbd) throws IllegalArgumentException {
        System.out.println("\n## 등록할 노선 이름을 입력하세요.");
        String lineName = kbd.nextLine();
        checkSameLine(lineName);
        checkTextLength(lineName);
        System.out.println("\n## 등록할 노선의 상행 종점역 이름을 입력하세요.");
        String firstStation = kbd.nextLine();
        checkExistStation(firstStation);
        System.out.println("\n## 등록할 노선의 하행 종점역 이름을 입력하세요.");
        String lastStation = kbd.nextLine();
        checkExistStation(lastStation);
        checkSameName(firstStation, lastStation);
        Line newLine = new Line(lineName);
        LineRepository.addLine(newLine, Arrays.asList(firstStation, lastStation));
    }

    public static void deleteLine(Scanner kbd) {
        try {
            System.out.println("\n## 삭제할 노선 이름을 입력하세요.");
            String lineName = kbd.nextLine();
            checkExistLine(lineName);
            LineRepository.deleteLineByName(lineName);
            System.out.println("\n[INFO] 지하철 노선이 삭제되었습니다.");
            startProgram(kbd);
        } catch (Exception e) {
            startProgram(kbd);
        }
    }

    public static void searchLine(Scanner kbd) {
        System.out.println("\n## 노선 목록");
        for (Line line : LineRepository.lines())
            System.out.println("[INFO] " + line.getName());
        startProgram(kbd);
    }

    public static void checkSameStation(String name) {
        if (StationRepository.isExist(name)) {
            displayErrorMessage(Constants.ALREADY_EXIST_ERROR);
            throw new IllegalArgumentException();
        }
    }

    public static void checkSameLine(String name) {
        if (LineRepository.isExist(name)) {
            displayErrorMessage(Constants.ALREADY_EXIST_ERROR);
            throw new IllegalArgumentException();
        }
    }

    public static void checkSameName(String firstName, String lastName) {
        if (firstName.equals(lastName)) {
            displayErrorMessage(Constants.SAME_NAME_ERROR);
            throw new IllegalArgumentException();
        }
    }

    public static void checkTextLength(String name) {
        if (name.length() < 2) {
            displayErrorMessage(Constants.NAME_LENGTH_ERROR);
            throw new IllegalArgumentException();
        }
    }

    public static void checkExistStation(String name) {
        if (!StationRepository.isExist(name)) {
            displayErrorMessage(Constants.NO_SUCH_NAME_ERROR);
            throw new IllegalArgumentException();
        }
    }

    public static void checkExistLine(String name) {
        if (!LineRepository.isExist(name)) {
            displayErrorMessage(Constants.NO_SUCH_NAME_ERROR);
            throw new IllegalArgumentException();
        }
    }

    public static void checkInLine(String name) {
        for (Line line : LineRepository.lines())
            if (line.hasStation(name)) {
                displayErrorMessage(Constants.HAS_IN_LINE_ERROR);
                throw new IllegalArgumentException();
            }
    }

    public static Line checkInSpecificLine(String lineName, String stationName) {
        Line line = LineRepository.getLineByName(lineName);
        if (line.hasStation(stationName)) {
            displayErrorMessage(Constants.HAS_IN_SPECIFIC_LINE_ERROR);
            throw new IllegalArgumentException();
        }
        return line;
    }

    public static void checkNotInSpecificLine(String lineName, String stationName) {
        Line line = LineRepository.getLineByName(lineName);
        if (!line.hasStation(stationName)) {
            displayErrorMessage(Constants.HAS_NOT_IN_SPECIFIC_LINE_ERROR);
            throw new IllegalArgumentException();
        }
    }

    public static void checkValidIndex(Line line, String index) {
        try {
            int intIndex = Integer.parseInt(index);
            int size = line.getSize();
            if (intIndex < 1 || intIndex > size+1)
                throw new IndexOutOfBoundsException();
        } catch (Exception e) {
            displayErrorMessage(Constants.UNVALID_INDEX_ERROR);
            throw new IllegalArgumentException();
        }
    }

    public static void checkValidLine(String name) {
        Line line = LineRepository.getLineByName(name);
        if (line.getSize() < 3) {
            displayErrorMessage(Constants.CANT_DELETE_SECTION_ERROR);
            throw new IllegalArgumentException();
        }
    }

    public static void showStationMenu() {
        System.out.println("## 역 관리 화면");
        System.out.println("1. 역 등록");
        System.out.println("2. 역 삭제");
        System.out.println("3. 역 조회");
        System.out.println("B. 돌아가기");
    }

    public static void showLineMenu() {
        System.out.println("## 노선 관리 화면");
        System.out.println("1. 노선 등록");
        System.out.println("2. 노선 삭제");
        System.out.println("3. 노선 조회");
        System.out.println("B. 돌아가기");
    }

    public static void showSectionMenu() {
        System.out.println("## 구간 관리 화면");
        System.out.println("1. 구간 등록");
        System.out.println("2. 구간 삭제");
        System.out.println("B. 돌아가기");
    }

    public static void displayAllLines(Scanner kbd) {
        System.out.println("## 지하철 노선도");
        for(Line line : LineRepository.lines()) {
            System.out.println("[INFO] " + line.getName());
            System.out.println("[INFO] ---");
            line.displayLine();
        }
        startProgram(kbd);
    }

    public static void finishProgram() {
        System.out.println("## 프로그램 종료");
    }
}