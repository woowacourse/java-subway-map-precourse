package subway.view;

import subway.domain.*;

import java.util.Scanner;

public class InputView {

    private static final String MAIN_MENU_MESSAGE = "## 메인 화면\n1. 역 관리\n2. 노선 관리\n" +
            "3. 구간 관리\n4. 지하철 노선도 출력\nQ. 종료\n";
    private static final String SUB_MENU_MESSAGE_TOP = "## %s 관리 화면\n";
    private static final String SUB_MENU_MESSAGE_ONE = "1. %s 등록\n";
    private static final String SUB_MENU_MESSAGE_TWO = "2. %s 삭제\n";
    private static final String SUB_MENU_MESSAGE_THREE = "3. %s 조회\n";
    private static final String SUB_MENU_MESSAGE_BOTTOM = "B. 돌아가기\n";

    private static final String SECTION = "구간";
    private static final String CHOOSE_MENU_MESSAGE = "## 원하는 기능을 선택하세요.";
    private static final String INPUT_STATION_NAME_ADD_MESSAGE = "## 등록할 역 이름을 입력하세요.";
    private static final String INPUT_LINE_NAME_ADD_MESSAGE = "## 등록할 노선 이름을 입력하세요.";
    private static final String INPUT_FIRST_STATION_ADD_MESSAGE = "## 등록할 노선의 상행 종점역 이름을 입력하세요.";
    private static final String INPUT_LAST_STATION_ADD_MESSAGE = "## 등록할 노선의 하행 종점역 이름을 입력하세요.";
    private static final String INPUT_STATION_NAME_DELETE_MESSAGE = "## 삭제할 역 이름을 입력하세요.";
    private static final String INPUT_LINE_NAME_DELETE_MESSAGE = "## 삭제할 노선 이름을 입력하세요.";
    private InputView() {

    }

    public static MainMenuType inputMainMenu(Scanner scanner) {
        try {
            System.out.println(MAIN_MENU_MESSAGE);
            System.out.println(CHOOSE_MENU_MESSAGE);
            return MainMenuType.validateMenu(scanner.nextLine());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return inputMainMenu(scanner);
        }
    }

    public static Menu inputSubMenu(Scanner scanner, String subMenuName) {
        try {
            System.out.printf(SUB_MENU_MESSAGE_TOP + SUB_MENU_MESSAGE_ONE + SUB_MENU_MESSAGE_TWO
            + SUB_MENU_MESSAGE_THREE + SUB_MENU_MESSAGE_BOTTOM, subMenuName, subMenuName, subMenuName, subMenuName);
            System.out.println(CHOOSE_MENU_MESSAGE);
            return SubMenuType.validateMenu(scanner.nextLine());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return inputSubMenu(scanner,subMenuName);
        }
    }

    public static void inputStationNameAdd(Scanner scanner) {
        try {
            System.out.println(INPUT_STATION_NAME_ADD_MESSAGE);
            StationRepository.addStation(new Station(scanner.nextLine()));
        }catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void inputStationNameDelete(Scanner scanner) {
        try {
            System.out.println(INPUT_STATION_NAME_DELETE_MESSAGE);
            StationRepository.deleteStation(scanner.nextLine());

        }catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void inputLineNameAdd(Scanner scanner) {
        try {
            System.out.println(INPUT_LINE_NAME_ADD_MESSAGE);
            Line line = new Line(scanner.nextLine());
            LineRepository.validateDuplicate(line);
            inputFirstLastStationName(scanner, line);
            LineRepository.addLine(line);
        }catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void inputFirstLastStationName(Scanner scanner, Line line) {
        System.out.println(INPUT_FIRST_STATION_ADD_MESSAGE);
        Station firstStation = new Station(scanner.nextLine());
        StationRepository.validateNameExist(firstStation);
        System.out.println(INPUT_LAST_STATION_ADD_MESSAGE);
        Station lastStation = new Station(scanner.nextLine());
        StationRepository.validateNameExist(lastStation);
        line.init(firstStation, lastStation);
    }

    public static void inputLineNameDelete(Scanner scanner) {
        try {
            System.out.println(INPUT_LINE_NAME_DELETE_MESSAGE);
            LineRepository.deleteLineByName(scanner.nextLine());
        }catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

}
