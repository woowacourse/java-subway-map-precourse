package subway.views.sectionviews;

import subway.menus.SectionMenu;
import subway.views.InputView;
import subway.views.OutputView;

import java.util.Scanner;

public class SectionInputView implements InputView {
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
}
