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

    public String readDeletingStationName() {
        System.out.println(ASK_DELETE_STATION_NAME);
        return scanner.nextLine();
    }

    public String readLineName() {
        System.out.println(ASK_LINE_NAME);
        return scanner.nextLine();
    }

    public String readDeletingLineName() {
        System.out.println(ASK_DELETE_LINE_NAME);
        return scanner.nextLine();
    }

    public String readFirstStationName() {
        System.out.println(ASK_LINE_FIRST_STATION);
        return scanner.nextLine();
    }


    public String readLastStationName() {
        System.out.println(ASK_LINE_LAST_STATION);
        return scanner.nextLine();
    }
}
