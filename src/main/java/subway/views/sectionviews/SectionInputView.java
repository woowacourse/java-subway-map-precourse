package subway.views.sectionviews;

import subway.menus.SectionMenu;
import subway.views.InputView;
import subway.views.OutputView;

import java.util.Scanner;

public class SectionInputView implements InputView {
    private static final String INPUT_LINE_MESSAGE = "\n## 노선을 입력하세요.";
    private static final String INPUT_STATION_MESSAGE = "\n## 역이름을 입력하세요.";
    private static final String INPUT_SECTION_ORDER_MESSAGE = "\n## 순서를 입력하세요.";

    private SectionInputView() {
    }

    public static SectionMenu selectSectionMenu(Scanner scanner) {
        try {
            OutputView.printFeatureSelectMessage();
            return SectionMenu.getMenu(InputView.userInput(scanner));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return selectSectionMenu(scanner);
        }
    }

    public static String inputLine(Scanner scanner) {
        System.out.println(INPUT_LINE_MESSAGE);
        return scanner.nextLine();
    }

    public static String inputStation(Scanner scanner) {
        System.out.println(INPUT_STATION_MESSAGE);
        return scanner.nextLine();
    }

    public static String inputOrder(Scanner scanner) {
        System.out.println(INPUT_SECTION_ORDER_MESSAGE);
        return scanner.nextLine();
    }
}
