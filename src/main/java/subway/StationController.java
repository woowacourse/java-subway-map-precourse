package subway;

import java.util.Scanner;
import subway.view.InputView;
import subway.view.OutputView;
import subway.constant.UserChoiceOptionToName;

public class StationController {

    private StationController() {

    }

    public static void stationControlMenu(Scanner scanner) {
        OutputView.stationMenuPrint();
        String choiceMenu = InputView.scanStationMenu(scanner);
        boolean workStatus = false;
        while (choiceMenuIsNotBack(choiceMenu)) {
            if (choiceMenu.
                equals(UserChoiceOptionToName.STATION_ADD.getUserChoiceOptionToName())) {
                stationAdd(scanner);
            }
            if (choiceMenu.
                equals(UserChoiceOptionToName.STATION_DELETE.getUserChoiceOptionToName())) {
            }
            if (choiceMenu.
                equals(UserChoiceOptionToName.STATION_CHECK.getUserChoiceOptionToName())) {
            }
        }
    }

    private static boolean choiceMenuIsNotBack(String choiceMenu) {
        return !choiceMenu.equals(UserChoiceOptionToName.BACK.getUserChoiceOptionToName());
    }

    private static void stationAdd(Scanner scanner) {
        String stationName;

        stationName = InputView.scanStationName(scanner);
        System.out.println("임시 출력 문구 : 당신이 선택한 역 이름은 : " + stationName);
    }

    private static void stationCheck() {
    }

    private static void stationDelete() {
    }


}
