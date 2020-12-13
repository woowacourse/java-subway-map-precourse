package subway.view;

import subway.domain.line.LineName;
import subway.domain.line.LineRepository;
import subway.domain.menu.MainMenuType;
import subway.domain.menu.SubMenuType;
import subway.domain.station.StationName;
import subway.domain.station.StationRepository;
import subway.utils.InputValidator;

import java.util.Scanner;

public class InputView implements ViewConstant{

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

    public static StationName inputStationNameAdd(Scanner scanner, String category) {
        System.out.printf(INPUT_NAME_ADD_MESSAGE, category);
        return new StationName(scanner.nextLine());
    }

    public static StationName inputStationNameDelete(Scanner scanner, String category) {
        System.out.printf(INPUT_NAME_DELETE_MESSAGE, category);
        return new StationName(scanner.nextLine());
    }

    public static LineName inputLineNameAdd(Scanner scanner, String category) {
        System.out.printf(INPUT_NAME_ADD_MESSAGE, category);
        return new LineName(scanner.nextLine());
    }

    public static StationName inputUpOrDownLastStationName(Scanner scanner, String kind) {
        System.out.printf(INPUT_UP_OR_DOWN_LAST_STATION_MESSAGE, kind);
        return new StationName(scanner.nextLine());
    }

    public static LineName inputLineNameDelete(Scanner scanner, String category) {
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
