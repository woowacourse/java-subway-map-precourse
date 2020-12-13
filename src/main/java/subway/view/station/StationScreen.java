package subway.view.station;

import subway.view.InputView;
import subway.view.OutputView;
import subway.view.TextCollection;

import java.util.Arrays;

public class StationScreen {

    public static Boolean selectMenu() {
        while (true) {
            showMenu();
            String input = InputView.inputFunction();
            if (!StationMenu.isValidInput(input)) {
                OutputView.printError(TextCollection.ERROR);
                continue;
            }
            if (!StationMenu.findMenuByKey(input).request()) {
                continue;
            }
            break;
        }
        return false;
    }

    private static void showMenu() {
        InputView.printQuestion(TextCollection.STATION_MANAGEMENT_MESSAGE);
        Arrays.stream(StationMenu.values()).forEach(menu -> {
            System.out.println(menu.getKey() + ". " + menu.getTitle());
        });
        System.out.println();
    }
}
