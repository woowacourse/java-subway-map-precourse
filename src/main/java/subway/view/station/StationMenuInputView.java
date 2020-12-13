package subway.view.station;

import java.util.Scanner;

public class StationMenuInputView {

    private static final String STATION_ENROLL_MENU = "1";
    private static final String STATION_DELETE_MENU = "2";
    private static final String STATION_PRINTALL_MENU = "3";
    private static final String INVALID_INPUT = "[ERROR] 선택할 수 없는 기능입니다.";
    private static final String BACK_MENU = "B";

    public static String getStationMenuCommand(Scanner scanner) {
        StationMenuOutputView.printStation();
        try {
            String stationMenuCommand = scanner.nextLine();
            validateStationMenuCommand(stationMenuCommand);
            return stationMenuCommand;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return getStationMenuCommand(scanner);
        }
    }

    private static void validateStationMenuCommand(String stationMenuCommand) {
        if (!stationMenuCommand.equals(STATION_ENROLL_MENU) && !stationMenuCommand.equals(STATION_DELETE_MENU) &&
                !stationMenuCommand.equals(STATION_PRINTALL_MENU) && !stationMenuCommand.equals(BACK_MENU)) {
            throw new IllegalArgumentException(INVALID_INPUT);
        }
    }
}
