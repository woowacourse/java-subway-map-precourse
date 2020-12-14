package subway.views.stationviews;

import subway.menus.StationMenu;
import subway.views.InputView;
import subway.views.OutputView;

import java.util.Scanner;

public class StationInputView implements InputView {
    private static final String INPUT_STATION_NAME_MESSAGE = "\n## 등록할 역 이름을 입력하세요.";

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

    public static String inputStationName(Scanner scanner) {
        System.out.println(INPUT_STATION_NAME_MESSAGE);
        return InputView.userInput(scanner);
    }
}
