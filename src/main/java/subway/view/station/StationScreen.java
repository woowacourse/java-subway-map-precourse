package subway.view.station;

import subway.exception.SubwayException;
import subway.view.InputView;
import subway.view.OutputView;
import subway.view.TextCollection;

import java.util.Arrays;

public class StationScreen {

    public static Boolean selectMenu() {
        showMenu();
        String input = InputView.inputFunction();
        if (!StationMenu.isValidInput(input)) {
            throw new SubwayException(TextCollection.WRONG_MENU_INPUT_MESSAGE);
        }
        StationMenu.findMenuByKey(input).request();
        return true;
    }

    private static void showMenu() {
        OutputView.printQuestion(TextCollection.STATION_MANAGEMENT_MESSAGE);
        Arrays.stream(StationMenu.values()).forEach(menu -> {
            System.out.println(menu.getKey() + ". " + menu.getTitle());
        });
    }
}
