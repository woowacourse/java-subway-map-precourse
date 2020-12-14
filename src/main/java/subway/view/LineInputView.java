package subway.view;

import subway.feature.MenuFeature;
import subway.menu.SectionMenu;

import java.util.Scanner;

public class LineInputView extends View {

    private static final String LINE_NAME_TO_REGISTER = "등록할 노선 이름을 입력하세요.";
    private static final String LINE_NAME_TO_REMOVE = "삭제할 노선 이름을 입력하세요.";
    private static final String UP_BOUND_TERMINUS = "등록할 노선의 상행 종점역 이름을 입력하세요.";
    private static final String DOWN_BOUND_TERMINUS = "등록할 노선의 하행 종점역 이름을 입력하세요.";

    public static String menu(Scanner scanner) {
        System.out.println(POUND_KEY + SELECT_FEATURE);
        try {
            String selection = scanner.nextLine().trim();
            MenuFeature.mapInputToSelection(SectionMenu.class, selection);
            return selection;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return menu(scanner);
        }
    }

    public static String register(Scanner scanner) {
        newLine();
        System.out.println(POUND_KEY + LINE_NAME_TO_REGISTER);
        return scanner.nextLine().trim();
    }

    public static String remove(Scanner scanner) {
        newLine();
        System.out.println(POUND_KEY + LINE_NAME_TO_REMOVE);
        return scanner.nextLine().trim();
    }

    public static String upBoundTerminus(Scanner scanner) {
        newLine();
        System.out.println(POUND_KEY + UP_BOUND_TERMINUS);
        return scanner.nextLine().trim();
    }

    public static String downBoundTerminus(Scanner scanner) {
        newLine();
        System.out.println(POUND_KEY + DOWN_BOUND_TERMINUS);
        return scanner.nextLine().trim();
    }

}
