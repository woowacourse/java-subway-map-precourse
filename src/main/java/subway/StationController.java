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
        while (isWorkSuccess(workStatus)) {
            if (choiceMenu.
                equals(UserChoiceOptionToName.STATION_ADD.getUserChoiceOptionToName())) {
                workStatus = stationAdd();
            }
            if (choiceMenu.
                equals(UserChoiceOptionToName.STATION_DELETE.getUserChoiceOptionToName())) {
                workStatus = stationDelete();
            }
            if (choiceMenu.
                equals(UserChoiceOptionToName.STATION_CHECK.getUserChoiceOptionToName())) {
                workStatus = stationCheck();
            }
            if (choiceMenu.equals(UserChoiceOptionToName.BACK.getUserChoiceOptionToName())){
                workStatus = true;
            }
        }
    }

    private static boolean isWorkSuccess(boolean workStatus){
        return !workStatus;
    }

    private static boolean stationAdd() {
        return true;
    }

    private static boolean stationCheck() {
        return true;
    }

    private static boolean stationDelete() {
        return true;
    }


}
