package subway.domain.management;

import subway.domain.menu.ServiceList;
import subway.view.InputView;
import subway.view.OutputView;

import java.util.Scanner;

public class StationManagement {

    public StationManagement() {
    }

    public static void doStationManagement(Scanner scanner){
        OutputView.printManagementView(ServiceList.STATION);
        String inputData = InputView.inputMainMenu(scanner);
    }
}
