package subway.view.input.station;

import subway.view.output.station.StationTextView;
import subway.view.output.util.ScreenView;

import java.util.Scanner;

/**
 * StationScanView.java : 지하철 역 기능 입력에 대한 클래스
 *
 * @author Daeun Lee
 * @version 1.0
 */
public class StationScanView {
    public static String scanStationInputForManagement(Scanner scanner) {
        ScreenView.printStationManagementScreen();
        return scanner.nextLine();

    }

    public static String scanStationNameForAddition(Scanner scanner) {
        StationTextView.printStationAdditionText();
        return scanner.nextLine();
    }

    public static String scanStationNameForDeletion(Scanner scanner) {
        StationTextView.printStationDeletionText();
        return scanner.nextLine();
    }
}
