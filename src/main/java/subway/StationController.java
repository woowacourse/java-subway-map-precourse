package subway;

import java.util.Scanner;
import subway.view.InputView;
import subway.view.OutputView;

public class StationController {

    private StationController() {

    }

    public static void stationControlMenu(Scanner scanner){
        String choiceMenu = InputView.scanStationMenu(scanner);
        System.out.println("당신의 선택은 " + choiceMenu);
    }
}
