package subway.view;

import subway.menu.MenuFeature;
import subway.menu.StationMenu;

import java.util.Scanner;

public class StationInputView extends View {

    private static final String INPUT_STATION_NAME_TO_REGISTER = "등록할 역 이름을 입력하세요.";
    private static final String INPUT_STATION_NAME_TO_REMOVE = "삭제할 역 이름을 입력하세요.";

    public static String menu(Scanner scanner) {
        System.out.println(POUND_KEY + SELECT_FEATURE);
        try {
            String selection = scanner.nextLine();
            MenuFeature.findOne(StationMenu.class, selection);
            return selection;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return menu(scanner);
        }
    }

    public static String register(Scanner scanner) {
        newLine();
        System.out.println(POUND_KEY + INPUT_STATION_NAME_TO_REGISTER);
        String name = scanner.nextLine();
        return name;
    }

    public static String remove(Scanner scanner) {
        newLine();
        System.out.println(POUND_KEY + INPUT_STATION_NAME_TO_REMOVE);
        String name = scanner.nextLine();
        return name;
    }

}
