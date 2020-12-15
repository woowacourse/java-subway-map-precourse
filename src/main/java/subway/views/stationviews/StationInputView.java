package subway.views.stationviews;

import subway.menus.StationMenu;
import subway.views.InputView;
import subway.views.OutputView;

import java.util.Scanner;

public class StationInputView implements InputView {
    private StationInputView() {
    }

    public static StationMenu selectStationMenu(Scanner scanner) {
        try {
            OutputView.printFeatureSelectMessage();
            return StationMenu.getMenu(InputView.userInput(scanner));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return selectStationMenu(scanner);
        }
    }
}
