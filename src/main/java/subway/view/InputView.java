package subway.view;

import subway.domain.*;

import java.util.Scanner;

public class InputView {

    private static final String MAIN_MENU_MESSAGE = "## 메인 화면\n1. 역 관리\n2. 노선 관리\n" +
            "3. 구간 관리\n4. 지하철 노선도 출력\nQ. 종료\n";
    private static final String STATION_MENU_MESSAGE = "## 역 관리 화면\n1. 역 등록\n2. 역 삭제\n" +
            "3. 역 조회\nB. 돌아가기\n";
    private static final String CHOOSE_MENU_MESSAGE = "## 원하는 기능을 선택하세요.";
    private static final String INPUT_STATION_NAME_ADD_MESSAGE = "## 등록할 역 이름을 입력하세요.";
    private static final String INPUT_STATION_NAME_DELETE_MESSAGE = "## 삭제할 역 이름을 입력하세요.";
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

    public static StationMenuType inputStationMenu(Scanner scanner) {
        try {
            System.out.println(STATION_MENU_MESSAGE);
            System.out.println(CHOOSE_MENU_MESSAGE);
            return StationMenuType.validateMenu(scanner.nextLine());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return inputStationMenu(scanner);
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


}
