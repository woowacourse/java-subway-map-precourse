package subway.views;

import subway.menus.LineMenu;
import subway.menus.SectionMenu;

import java.util.Scanner;

public class InputView {

    private InputView() {
    }

    private static String userInput(Scanner scanner) {
        return scanner.nextLine();
    }



    public static LineMenu selectLineMenu(Scanner scanner) {
        try {
            OutputView.printFeatureSelectMessage();
            return LineMenu.getMenu(userInput(scanner));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return selectLineMenu(scanner);
        }
    }

    public static SectionMenu selectSectionMenu(Scanner scanner) {
        try {
            OutputView.printFeatureSelectMessage();
            return SectionMenu.getMenu(userInput(scanner));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return selectSectionMenu(scanner);
        }
    }
}
