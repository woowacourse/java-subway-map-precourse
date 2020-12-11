package subway.view;

import subway.domain.line.Line;
import subway.domain.line.LineName;
import subway.domain.line.LineRepository;
import subway.domain.menu.MainMenuType;
import subway.domain.menu.SubMenuType;
import subway.domain.station.Station;
import subway.domain.station.StationName;
import subway.domain.station.StationRepository;
import subway.utils.InputValidator;

import java.util.Scanner;

public class InputView {

    private static final String MAIN_MENU_MESSAGE = "## 메인 화면\n1. 역 관리\n2. 노선 관리\n" +
            "3. 구간 관리\n4. 지하철 노선도 출력\nQ. 종료\n";
    private static final String SUB_MENU_MESSAGE_TOP = "## %s 관리 화면\n";
    private static final String SUB_MENU_MESSAGE_ONE = "1. %s 등록\n";
    private static final String SUB_MENU_MESSAGE_TWO = "2. %s 삭제\n";
    private static final String SUB_MENU_MESSAGE_THREE = "3. %s 조회\n";
    private static final String SUB_MENU_MESSAGE_BOTTOM = "B. 돌아가기\n";

    private static final String CHOOSE_MENU_MESSAGE = "## 원하는 기능을 선택하세요.";
    private static final String INPUT_STATION_NAME_ADD_MESSAGE = "## 등록할 역 이름을 입력하세요.";
    private static final String INPUT_LINE_NAME_ADD_MESSAGE = "## 등록할 노선 이름을 입력하세요.";
    private static final String INPUT_FIRST_STATION_ADD_MESSAGE = "## 등록할 노선의 상행 종점역 이름을 입력하세요.";
    private static final String INPUT_LAST_STATION_ADD_MESSAGE = "## 등록할 노선의 하행 종점역 이름을 입력하세요.";
    private static final String INPUT_STATION_NAME_DELETE_MESSAGE = "## 삭제할 역 이름을 입력하세요.";
    private static final String INPUT_LINE_NAME_DELETE_MESSAGE = "## 삭제할 노선 이름을 입력하세요.";
    private static final String INPUT_SECTION_LINE_ADD_MESSAGE = "## 노선을 입력하세요.";
    private static final String INPUT_SECTION_STATION_ADD_MESSAGE = "## 역이름을 입력하세요.";
    private static final String INPUT_SECTION_INDEX_MESSAGE = "## 순서를 입력하세요.";
    private static final String INPUT_SECTION_STATION_DELETE_MESSAGE = "## 삭제할 구간의 역을 입력하세요.";
    private static final String INPUT_SECTION_LINE_DELETE_MESSAGE = "## 삭제할 구간의 노선을 입력하세요.";
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

    public static SubMenuType inputStationOrLineMenu(Scanner scanner, String subMenuName, MainMenuType mainMenuType) {
        try {
            System.out.printf(SUB_MENU_MESSAGE_TOP + SUB_MENU_MESSAGE_ONE + SUB_MENU_MESSAGE_TWO
            + SUB_MENU_MESSAGE_THREE + SUB_MENU_MESSAGE_BOTTOM, subMenuName, subMenuName, subMenuName, subMenuName);
            System.out.println(CHOOSE_MENU_MESSAGE);
            return mainMenuType.validateSubMenu(scanner.nextLine());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return inputStationOrLineMenu(scanner,subMenuName, mainMenuType);
        }
    }

    public static SubMenuType inputSectionMenu(Scanner scanner, String subMenuName, MainMenuType mainMenuType) {
        try {
            System.out.printf(SUB_MENU_MESSAGE_TOP + SUB_MENU_MESSAGE_ONE + SUB_MENU_MESSAGE_TWO
                    + SUB_MENU_MESSAGE_BOTTOM, subMenuName, subMenuName, subMenuName);
            System.out.println(CHOOSE_MENU_MESSAGE);
            return mainMenuType.validateSubMenu(scanner.nextLine());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return inputSectionMenu(scanner,subMenuName, mainMenuType);
        }
    }



    public static LineName inputLineNameAdd(Scanner scanner) {
        System.out.println(INPUT_LINE_NAME_ADD_MESSAGE);
        return new LineName(scanner.nextLine());
    }

//    public static Station inputFirstStationName(Scanner scanner) {
//        System.out.println(INPUT_FIRST_STATION_ADD_MESSAGE);
//        Station firstStation = new Station(scanner.nextLine());
//        StationRepository.validateNameExist(firstStation);
//        return firstStation;
//    }
//
//    public static Station inputLastStationName(Scanner scanner) {
//        System.out.println(INPUT_LAST_STATION_ADD_MESSAGE);
//        Station lastStation = new Station(scanner.nextLine());
//        StationRepository.validateNameExist(lastStation);
//        return lastStation;
//    }

    public static LineName inputLineNameDelete(Scanner scanner) {
        System.out.println(INPUT_LINE_NAME_DELETE_MESSAGE);
        return new LineName(scanner.nextLine());
    }

//    public static void inputSectionAdd(Scanner scanner) {
//        try {
//            System.out.println(INPUT_SECTION_LINE_ADD_MESSAGE);
//            Line line = LineRepository.getLineByName(scanner.nextLine());
//            System.out.println(INPUT_SECTION_STATION_ADD_MESSAGE);
//            Station station = new Station(scanner.nextLine());
//            StationRepository.validateNameExist(station);
//            line.validateDuplicateStationToLine(station);
//            System.out.println(INPUT_SECTION_INDEX_MESSAGE);
//            int index = InputValidator.validateInteger(scanner.nextLine());
//            line.addStationToLine(station, index);
//        }catch (IllegalArgumentException e) {
//            System.out.println(e.getMessage());
//        }
//    }
//
//    public static void inputSectionDelete(Scanner scanner) {
//        try {
//            System.out.println(INPUT_SECTION_LINE_DELETE_MESSAGE);
//            Line line = LineRepository.getLineByName(scanner.nextLine());
//            System.out.println(INPUT_SECTION_STATION_DELETE_MESSAGE);
//            Station station = new Station(scanner.nextLine());
//            line.validateExistStationToLine(station);
//            line.deleteStationToLine(station);
//        }catch (IllegalArgumentException e) {
//            System.out.println(e.getMessage());
//        }
//    }

}
