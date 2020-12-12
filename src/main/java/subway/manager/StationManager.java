package subway.manager;

import subway.domain.Station;
import subway.domain.StationRepository;
import view.InputView;
import view.OutputView;

import java.util.Arrays;
import java.util.List;

enum StationButton {
    REGISTER("1"), DELETE("2"), INQUIRY("3"), BACK("B");

    private final String symbol;

    StationButton(String symbol) {
        this.symbol = symbol;
    }

    public String getSymbol() {
        return symbol;
    }
}

public class StationManager {

    private static final List<String> choices = Arrays.asList(
            StationButton.REGISTER.getSymbol(),
            StationButton.DELETE.getSymbol(),
            StationButton.INQUIRY.getSymbol(),
            StationButton.BACK.getSymbol()
    );

    public static void execute() {
        OutputView.printStationManagement();
        String command = InputView.getFunctionSelect(choices);
        nextProcedure(command);
    }

    public static void nextProcedure(String command) {
        if (command.equals(StationButton.BACK.getSymbol())) {
            MainManager.execute();
            return;
        }
        if (command.equals(StationButton.REGISTER.getSymbol())) {
            registerStation();
        }
        if (command.equals(StationButton.DELETE.getSymbol())) {
            deleteStation();
        }
        if (command.equals(StationButton.INQUIRY.getSymbol())) {
            OutputView.printTotalStation();
        }
        MainManager.execute();
    }

    public static void registerStation() {
        String stationName = InputView.getRegisterStationName();
        StationRepository.addStation(new Station(stationName));
        OutputView.printInformation(OutputView.MESSAGE_SUCCESS_REGISTER_STATION);
    }

    public static void deleteStation() {
        if (StationRepository.isEmpty()) {
            OutputView.printError(OutputView.MESSAGE_ERROR_EMPTY_STATION_REPOSITORY);
            return;
        }
        String stationName = InputView.getDeleteStationName();
        StationRepository.deleteStation(stationName);
        OutputView.printInformation(OutputView.MESSAGE_SUCCESS_DELETE_STATION);
    }

}
