package subway;

import subway.domain.*;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        Init.initialize();
        startProgram(scanner);
    }

    public static void startProgram(Scanner kbd) {
        View.showMainMenu();
        String mainInput = inputFunction(kbd, Constants.MAIN_FUNCTIONS);
        goSubMenu(mainInput, kbd);
    }

    public static String inputFunction(Scanner kbd, List<String> functions) {
        String input = "0";
        boolean check = false;
        while(!check) {
            System.out.println("\n## 원하는 기능을 선택하세요.");
            input = kbd.nextLine();
            check = Errors.checkInput(input, functions);
        }
        return input;
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
            View.displayAllLines(kbd);
        if (input.equalsIgnoreCase(Constants.FINISH_PROGRAM))
            finishProgram();
    }

    public static void manageStation(Scanner kbd) {
        View.showStationMenu();
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
        View.showLineMenu();
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
        View.showSectionMenu();
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
        Errors.checkExistLine(lineName);
        System.out.println("\n## 역이름을 입력하세요.");
        String stationName = kbd.nextLine();
        Errors.checkExistStation(stationName);
        Line line = Errors.checkInSpecificLine(lineName, stationName);
        System.out.println("\n## 순서를 입력하세요.");
        String index = kbd.nextLine();
        Errors.checkValidIndex(line, index);
        LineRepository.addStationToLine(lineName, stationName, Integer.parseInt(index));
    }

    public static void deleteSection(Scanner kbd) {
        try {
            System.out.println("\n## 삭제할 구간의 노선을 입력하세요.");
            String lineName = kbd.nextLine();
            Errors.checkExistLine(lineName);
            Errors.checkValidLine(lineName);
            System.out.println("\n## 삭제할 구간의 역을 입력하세요.");
            String stationName = kbd.nextLine();
            Errors.checkNotInSpecificLine(lineName, stationName);
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
            Errors.checkSameStation(stationName);
            Errors.checkTextLength(stationName);
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
            Errors.checkExistStation(stationName);
            Errors.checkInLine(stationName);
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
        Errors.checkSameLine(lineName);
        Errors.checkTextLength(lineName);
        System.out.println("\n## 등록할 노선의 상행 종점역 이름을 입력하세요.");
        String firstStation = kbd.nextLine();
        Errors.checkExistStation(firstStation);
        System.out.println("\n## 등록할 노선의 하행 종점역 이름을 입력하세요.");
        String lastStation = kbd.nextLine();
        Errors.checkExistStation(lastStation);
        Errors.checkSameName(firstStation, lastStation);
        Line newLine = new Line(lineName);
        LineRepository.addLine(newLine, Arrays.asList(firstStation, lastStation));
    }

    public static void deleteLine(Scanner kbd) {
        try {
            System.out.println("\n## 삭제할 노선 이름을 입력하세요.");
            String lineName = kbd.nextLine();
            Errors.checkExistLine(lineName);
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

    public static void finishProgram() {
        System.out.println("## 프로그램 종료");
    }
}