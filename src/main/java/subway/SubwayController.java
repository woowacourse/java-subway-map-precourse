package subway;

import java.util.Scanner;
import subway.constant.UserChoiceOptionToName;
import subway.view.InputView;
import subway.view.OutputView;

public class SubwayController {

    Scanner scanner;

    public SubwayController(Scanner scanner) {
        this.scanner = scanner;
    }

    /**
     * 메인 메뉴 문구 출력
     * 기능 선택
     */
    public void mainMenu() {
        String mainMenuOptionChoice = new String();

        while (!mainMenuOptionChoice.
            equals(UserChoiceOptionToName.EXIT.getUserChoiceOptionToName())) {

            OutputView.mainMenuPrint();
            mainMenuOptionChoice = InputView.scanMainMenu(scanner);

            if (mainMenuOptionChoice
                .equals(UserChoiceOptionToName.STATION_MANAGEMENT.getUserChoiceOptionToName())) {
                StationController.stationControlMenu(scanner);
            }
        }
    }
}
