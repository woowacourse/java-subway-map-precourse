package subway.view.line;


import subway.exception.SubwayException;
import subway.view.InputView;
import subway.view.OutputView;
import subway.view.TextCollection;
import subway.view.station.StationMenu;

import java.util.Arrays;

public class LineScreen {

    public static Boolean selectMenu() {
        showMenu();
        String input = InputView.inputFunction();
        if (!LineMenu.isValidInput(input)) {
            throw new SubwayException(TextCollection.WRONG_MENU_INPUT_MESSAGE);
        }
        LineMenu.findMenuByKey(input).request();
        return true;
    }

    private static void showMenu() {
        OutputView.printQuestion(TextCollection.LINE_MANAGEMENT_MESSAGE);
        Arrays.stream(LineMenu.values()).forEach(menu -> {
            System.out.println(menu.getKey() + ". " + menu.getTitle());
        });
    }
}
