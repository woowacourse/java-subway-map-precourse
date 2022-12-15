package subway.controller.subController;

import java.util.EnumMap;
import java.util.Map;
import subway.domain.Station;
import subway.domain.StationRepository;
import subway.domain.option.StationOption;
import subway.view.InputView;
import subway.view.OutputView;

public class StationManagementController implements Controllable {

    private final InputView inputView;
    private final OutputView outputView;
    private final Map<StationOption, Runnable> stationManagementGuide = new EnumMap<>(StationOption.class);

    public StationManagementController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
        initializeStationManagementGuide();
    }

    private void initializeStationManagementGuide() {
        stationManagementGuide.put(StationOption.STATION_REGISTER, this::registerStation);
        stationManagementGuide.put(StationOption.STATION_DELETE, this::deleteStation);
        stationManagementGuide.put(StationOption.STATION_SEARCH, this::searchStation);
    }

    @Override
    public void process() {
        try {
            outputView.printStationOption();
            stationManagementGuide.get(inputView.readStationOption()).run();
        } catch (NullPointerException ignored) {
        }
    }

    private void registerStation() {
        Station newStation = inputView.readStationToRegister();
        StationRepository.addStation(newStation);
        outputView.printRegisterStation();
    }

    private void deleteStation() {
        if(StationRepository.deleteStation(inputView.readStationToDelete())){
         outputView.printDeleteSuccess();
        }
    }

    private void searchStation() {
    }


}
