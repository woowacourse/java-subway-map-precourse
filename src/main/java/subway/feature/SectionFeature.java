package subway.feature;

import subway.domain.*;
import subway.menu.SectionMenu;
import subway.view.ErrorView;
import subway.view.OutputView;
import subway.view.SectionInputView;

import java.util.Scanner;

public class SectionFeature {
    public static void registerSection(Scanner scanner) {
        try {
            String line = SectionInputView.line(scanner);
            String station = SectionInputView.station(scanner);
            int sequence = SectionInputView.sequence(scanner);

            SectionRepository.addSection(line, station, sequence);

            OutputView.printSuccessRegisterSection();
        } catch (NumberFormatException e) {
            ErrorView.printMustBeNumber();
        } catch (IllegalArgumentException e) {
            ErrorView.printError(e.getMessage());
            SectionMenu.openScreen(scanner);
        }
    }

    public static void removeSection(Scanner scanner) {
        try {
            String line = SectionInputView.line(scanner);
            String station = SectionInputView.station(scanner);

            removeSection(SectionRepository.deleteSection(line, station));
            OutputView.printSuccessRemoveSection();
        } catch (IllegalArgumentException e) {
            ErrorView.printError(e.getMessage());
            SectionMenu.openScreen(scanner);
        }
    }

    private static void removeSection(boolean success) {
        if (!success) {
            throw new IllegalArgumentException(ErrorView.NO_EXIST_SECTION);
        }
    }

    public static void showSubwayMap() {
        OutputView.printSubwayMap();
    }
}
