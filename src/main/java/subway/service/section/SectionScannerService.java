package subway.service.section;

import subway.view.output.section.SectionTextView;

import java.util.Scanner;

public class SectionScannerService {
    public static String scanLineName(Scanner scanner) {
        SectionTextView.printSectionAddingLineText();
        return scanner.nextLine();
    }

    public static String scanStationName(Scanner scanner) {
        SectionTextView.printSectionAddingStationText();
        return scanner.nextLine();
    }

    public static String scanOrder(Scanner scanner) {
        SectionTextView.printSectionAddingOrderText();
        return scanner.nextLine();
    }
}
