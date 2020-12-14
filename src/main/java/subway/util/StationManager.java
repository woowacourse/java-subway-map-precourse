package subway.util;

import java.util.Scanner;

public class StationManager {
    public static void stationMain(Scanner scanner) {
        Constants.printStation();
        String inputString = scanner.nextLine().trim();
        if(inputString.equals("B")) {
            return;
        } else if(inputString.equals("1")) {
            System.out.println(Constants.ASK_STATION_ADD);
        } else if(inputString.equals("2")) {

        } else if(inputString.equals("3")) {

        }
        return;
    }
}
