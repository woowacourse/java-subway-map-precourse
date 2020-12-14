package subway;

import java.util.Scanner;
import subway.constant.UserChoiceOptionToName;
import subway.domain.LineRepository;
import subway.domain.StationRepository;
import subway.view.InputView;
import subway.view.OutputView;

public class SubwayController {

    Scanner scanner;

    public SubwayController(Scanner scanner) {
        this.scanner = scanner;
    }


    public void mainMenu() {
        String mainMenuOptionChoice = "";

        while (!mainMenuOptionChoice.
            equals(UserChoiceOptionToName.EXIT.getUserChoiceOptionToName())) {

            OutputView.mainMenuPrint();
            mainMenuOptionChoice = InputView.scanMainMenu(scanner);

            if (mainMenuOptionChoice
                .equals(UserChoiceOptionToName.STATION_MANAGEMENT.getUserChoiceOptionToName())) {
                StationController.stationControlMenu(scanner);
            }
            if (mainMenuOptionChoice
                .equals(UserChoiceOptionToName.LINE_MANAGEMENT.getUserChoiceOptionToName())){
                LineController.lineControlMenu(scanner);
            }
        }
    }
}
