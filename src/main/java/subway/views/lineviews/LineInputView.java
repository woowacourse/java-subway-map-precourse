package subway.views.lineviews;

import subway.menus.LineMenu;
import subway.views.InputView;
import subway.views.OutputView;

import java.util.Scanner;

public class LineInputView implements InputView {
    private LineInputView() {
    }

    public static LineMenu selectLineMenu(Scanner scanner) {
        try {
            OutputView.printFeatureSelectMessage();
            return LineMenu.getMenu(InputView.userInput(scanner));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return selectLineMenu(scanner);
        }
    }
}
