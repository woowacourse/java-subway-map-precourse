package subway.views.stationviews;

import subway.menus.StationMenu;
import subway.views.OutputView;

import java.util.Scanner;

public class StationInputView {
    private static final String INPUT_STATION_NAME_MESSAGE = "\n## 등록할 역 이름을 입력하세요.";

    private StationInputView() {
    }

    private static String userInput(Scanner scanner) {
        return scanner.nextLine();
    }

    public static StationMenu selectStationMenu(Scanner scanner) {
        try {
            OutputView.printFeatureSelectMessage();
            return StationMenu.getMenu(userInput(scanner));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return selectStationMenu(scanner);
        }
    }

    public static String inputStationName(Scanner scanner) {
        System.out.println(INPUT_STATION_NAME_MESSAGE);
        return scanner.nextLine();
    }
}
