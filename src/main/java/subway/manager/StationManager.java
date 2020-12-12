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
        } else if (command.equals(StationButton.REGISTER.getSymbol())) {
            registerStation();
        } else if (command.equals(StationButton.DELETE.getSymbol())) {
            deleteStation();
        } else if (command.equals(StationButton.INQUIRY.getSymbol())) {
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
        String stationName = InputView.getDeleteStationName();
        if (StationRepository.deleteStation(stationName)) {
            OutputView.printInformation(OutputView.MESSAGE_SUCCESS_DELETE_STATION);
        } else { // ELSE 삭제합시다!!!
            System.out.println("[TEST] 역 삭제 과정에서 뭔가 잘못됐어요 ~~~");
            System.out.println("[TEST] 아마도 이게 보여질 일은 없을거야~ 아마두~");
        }
    }

}
