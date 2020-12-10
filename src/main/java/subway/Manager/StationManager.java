package subway.Manager;

import subway.domain.Station;
import subway.domain.StationRepository;
import view.InputView;
import view.OutputView;

import java.util.Scanner;

public class StationManager {
    private static final String STATION_INSERT = "1";
    private static final String STATION_DELETE = "2";
    private static final String STATION_LOOKUP = "3";

    private final Scanner scanner;
    private StationRepository stationRepository;

    public StationManager(Scanner scanner) {
        stationRepository = new StationRepository();
        this.scanner = scanner;
    }

    public void execute(String input) {

        if (input.equals(STATION_INSERT)) {
            String stationName = InputView.inputStation(scanner);
            StationRepository.addStation(new Station(stationName));
            OutputView.stationInsertView();
        }
        if (input.equals(STATION_DELETE)) {
            InputView.inputDeleteStation(scanner);
        }
        if (input.equals(STATION_LOOKUP)) {
            OutputView.stationLookup(stationRepository.toString());
        }
    }
}
