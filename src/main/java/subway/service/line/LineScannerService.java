package subway.service.line;

import subway.view.output.line.LineTextView;

import java.util.Scanner;

public class LineScannerService {
    public static String scanLineName(Scanner scanner) {
        LineTextView.printLineAddingText();
        return scanner.nextLine();
    }

    public static String scanUpStationName(Scanner scanner) {
        LineTextView.printLineUpStationNameText();
        return scanner.nextLine();
    }

    public static String scanDownStationName(Scanner scanner) {
        LineTextView.printLineDownStationNameText();
        return scanner.nextLine();
    }
}
