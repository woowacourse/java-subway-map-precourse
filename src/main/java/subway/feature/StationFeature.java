package subway.feature;

import subway.domain.Station;
import subway.domain.StationRepository;
import subway.menu.StationMenu;
import subway.view.ErrorView;
import subway.view.OutputView;
import subway.view.StationInputView;

import java.util.Scanner;

public class StationFeature {
    public static void registerStation(Scanner scanner) {
        try {
            String station = StationInputView.register(scanner).trim();
            StationRepository.addStation(new Station(station));

            OutputView.printSuccessRegisterStation();
        } catch (IllegalArgumentException e) {
            ErrorView.printError(e.getMessage());
            StationMenu.openScreen(scanner);
        }
    }

    public static void removeStation(Scanner scanner) {
        try {
            String station = StationInputView.remove(scanner);
            removeStation(StationRepository.deleteStation(station));

            OutputView.printSuccessRemoveStation();
        } catch (IllegalArgumentException e) {
            ErrorView.printError(e.getMessage());
            StationMenu.openScreen(scanner);
        }
    }

    private static void removeStation(boolean success) {
        if (!success) {
            throw new IllegalArgumentException(ErrorView.NO_EXIST_STATION);
        }
    }

    public static void inquiryStation() {
        OutputView.printStations();
    }
}
