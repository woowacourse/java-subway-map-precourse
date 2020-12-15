package subway.view.input.line;

import subway.view.output.line.LineTextView;
import subway.view.output.util.ScreenView;

import java.util.Scanner;

/**
 * LineScanView.java : 지하철 노선 기능 입력에 대한 클래스
 *
 * @author Daeun Lee
 * @version 1.0
 */
public class LineScanView {
    public static String scanLineInputForManagement(Scanner scanner) {
        ScreenView.printLineManagementScreen();
        return scanner.nextLine();
    }

    public static String scanLineNameForAddition(Scanner scanner) {
        LineTextView.printLineAdditionText();
        return scanner.nextLine();
    }

    public static String scanUpStationNameForAddition(Scanner scanner) {
        LineTextView.printLineUpStationNameText();
        return scanner.nextLine();
    }

    public static String scanDownStationNameForAddition(Scanner scanner) {
        LineTextView.printLineDownStationNameText();
        return scanner.nextLine();
    }

    public static String scanLineNameForDeletion(Scanner scanner) {
        LineTextView.printLineDeletionText();
        return scanner.nextLine();
    }
}
