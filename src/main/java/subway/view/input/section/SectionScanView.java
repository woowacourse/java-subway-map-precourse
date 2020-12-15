package subway.view.input.section;

import subway.view.output.section.SectionTextView;
import subway.view.output.util.ScreenView;

import java.util.Scanner;

/**
 * SectionScanView.java : 지하철 구간 기능 입력에 대한 클래스
 *
 * @author Daeun Lee
 * @version 1.0
 */
public class SectionScanView {
    public static String scanSectionInputForManagement(Scanner scanner) {
        ScreenView.printSectionManagementScreen();
        return scanner.nextLine();
    }

    public static String scanLineNameForAddition(Scanner scanner) {
        SectionTextView.printSectionAdditionLineText();
        return scanner.nextLine();
    }

    public static String scanStationNameForAddition(Scanner scanner) {
        SectionTextView.printSectionAdditionStationText();
        return scanner.nextLine();
    }

    public static String scanOrderForAddition(Scanner scanner) {
        SectionTextView.printSectionAdditionOrderText();
        return scanner.nextLine();
    }

    public static String scanLineNameForDeletion(Scanner scanner) {
        SectionTextView.printSectionDeletionLineText();
        return scanner.nextLine();
    }

    public static String scanStationNameForDeletion(Scanner scanner) {
        SectionTextView.printSectionDeletionStationText();
        return scanner.nextLine();
    }
}
