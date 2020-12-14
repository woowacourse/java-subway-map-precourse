package subway.view;

import subway.menu.MenuFeature;
import subway.menu.SectionMenu;

import java.util.Scanner;

public class SectionInputView extends View {

    private static final String INPUT_LINE_NAME = "노선을 입력하세요.";
    private static final String INPUT_STATION_NAME = "역을 입력하세요.";
    private static final String INPUT_SEQUENCE = "순서를 입력하세요.";

    public static String menu(Scanner scanner) {
        System.out.println(POUND_KEY + SELECT_FEATURE);
        try {
            String selection = scanner.nextLine();
            MenuFeature.findOne(SectionMenu.class, selection);
            return selection;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return menu(scanner);
        }
    }

    public static String line(Scanner scanner) {
        newLine();
        System.out.println(POUND_KEY + INPUT_LINE_NAME);
        return scanner.nextLine();
    }

    public static String station(Scanner scanner) {
        newLine();
        System.out.println(POUND_KEY + INPUT_STATION_NAME);
        return scanner.nextLine();
    }

    public static int sequence(Scanner scanner) {
        newLine();
        System.out.println(POUND_KEY + INPUT_SEQUENCE);
        return Integer.parseInt(scanner.nextLine());
    }
}
