package subway.view;

import static subway.dashboard.DashboardWords.*;

import java.util.Scanner;

public class InputView {

    private final Scanner scanner;

    public InputView(Scanner scanner) {
        this.scanner = scanner;
    }

    public String readOptionChoice() {
        System.out.println(ASK_OPTIONS);
        return scanner.nextLine();
    }

    public String readStationName() {
        System.out.println(ASK_STATION_NAME);
        return scanner.nextLine();
    }
}
