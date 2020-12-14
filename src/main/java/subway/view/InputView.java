package subway.view;

import subway.domain.line.LineName;
import subway.domain.menu.MainMenuType;
import subway.domain.menu.SubMenuType;
import subway.domain.station.StationName;
import subway.utils.InputValidator;

import java.util.Scanner;

public class InputView {
    private static final String STATION = "역";
    private static final String LINE = "노선";
    private static final String NAME = "이름";
    private static final String MAIN_MENU_MESSAGE = "\n## 메인 화면\n1. 역 관리\n2. 노선 관리\n3. 구간 관리\n4. 지하철 노선도 출력\nQ. 종료";
    private static final String SUB_MENU_MESSAGE_TOP = "\n## %s 관리 화면\n";
    private static final String SUB_MENU_MESSAGE_ONE = "1. %s 등록\n";
    private static final String SUB_MENU_MESSAGE_TWO = "2. %s 삭제\n";
    private static final String SUB_MENU_MESSAGE_THREE = "3. %s 조회\n";
    private static final String SUB_MENU_MESSAGE_BOTTOM = "B. 돌아가기\n";
    private static final String CHOOSE_MENU_MESSAGE = "\n## 원하는 기능을 선택하세요.";
    private static final String INPUT_SECTION_INDEX_MESSAGE = "\n## 순서를 입력하세요.";
    private static final String INPUT_NAME_ADD_MESSAGE = "\n## 등록할 %s 이름을 입력하세요.\n";
    private static final String INPUT_UP_OR_DOWN_LAST_STATION_MESSAGE = "\n## 등록할 노선의 %s행 종점역 이름을 입력하세요.\n";
    private static final String INPUT_NAME_DELETE_MESSAGE = "\n## 삭제할 %s 이름을 입력하세요.\n";
    private static final String INPUT_SECTION_ADD_MESSAGE = "\n## %s을 입력하세요.\n";
    private static final String INPUT_SECTION_DELETE_MESSAGE = "\n## 삭제할 구간의 %s을 입력하세요.\n";

    private InputView() {
    }

    public static MainMenuType inputMainMenuType(Scanner scanner) {
        try {
            System.out.println(MAIN_MENU_MESSAGE);
            System.out.println(CHOOSE_MENU_MESSAGE);
            return MainMenuType.of(scanner.nextLine());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return inputMainMenuType(scanner);
        }
    }

    public static SubMenuType inputStationOrLineMenuType(Scanner scanner, String subMenuName, MainMenuType mainMenuType) {
        try {
            System.out.printf(SUB_MENU_MESSAGE_TOP + SUB_MENU_MESSAGE_ONE + SUB_MENU_MESSAGE_TWO
            + SUB_MENU_MESSAGE_THREE + SUB_MENU_MESSAGE_BOTTOM, subMenuName, subMenuName, subMenuName, subMenuName);
            System.out.println(CHOOSE_MENU_MESSAGE);
            return mainMenuType.validateSubMenuOfMainMenu(scanner.nextLine());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return inputStationOrLineMenuType(scanner,subMenuName, mainMenuType);
        }
    }

    public static SubMenuType inputSectionMenuType(Scanner scanner, String subMenuName, MainMenuType mainMenuType) {
        try {
            System.out.printf(SUB_MENU_MESSAGE_TOP + SUB_MENU_MESSAGE_ONE + SUB_MENU_MESSAGE_TWO
                    + SUB_MENU_MESSAGE_BOTTOM, subMenuName, subMenuName, subMenuName);
            System.out.println(CHOOSE_MENU_MESSAGE);
            return mainMenuType.validateSubMenuOfMainMenu(scanner.nextLine());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return inputSectionMenuType(scanner,subMenuName, mainMenuType);
        }
    }

    public static StationName inputStationNameToAdd(Scanner scanner, String category) {
        System.out.printf(INPUT_NAME_ADD_MESSAGE, category);
        return new StationName(scanner.nextLine());
    }

    public static StationName inputStationNameToDelete(Scanner scanner, String category) {
        System.out.printf(INPUT_NAME_DELETE_MESSAGE, category);
        return new StationName(scanner.nextLine());
    }

    public static LineName inputLineNameToAdd(Scanner scanner, String category) {
        System.out.printf(INPUT_NAME_ADD_MESSAGE, category);
        return new LineName(scanner.nextLine());
    }

    public static StationName inputUpOrDownLastStationName(Scanner scanner, String kind) {
        System.out.printf(INPUT_UP_OR_DOWN_LAST_STATION_MESSAGE, kind);
        return new StationName(scanner.nextLine());
    }

    public static LineName inputLineNameToDelete(Scanner scanner, String category) {
        System.out.printf(INPUT_NAME_DELETE_MESSAGE, category);
        return new LineName(scanner.nextLine());
    }

    public static LineName inputLineNameToAddSection(Scanner scanner) {
        System.out.printf(INPUT_SECTION_ADD_MESSAGE, LINE);
        return new LineName(scanner.nextLine());
    }

    public static StationName inputStationNameToAddSection(Scanner scanner) {
        System.out.printf(INPUT_SECTION_ADD_MESSAGE, STATION+NAME);
        return new StationName(scanner.nextLine());
    }

    public static int inputIndexToAddSection(Scanner scanner) {
        System.out.println(INPUT_SECTION_INDEX_MESSAGE);
        return InputValidator.validateInteger(scanner.nextLine());
    }

    public static LineName inputLineNameToDeleteSection(Scanner scanner) {
        System.out.printf(INPUT_SECTION_DELETE_MESSAGE, LINE);
        return new LineName(scanner.nextLine());
    }

    public static StationName inputStationNameToDeleteSection(Scanner scanner) {
        System.out.printf(INPUT_SECTION_DELETE_MESSAGE, STATION);
        return new StationName(scanner.nextLine());
    }
}
