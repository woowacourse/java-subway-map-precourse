package subway.controller;

import subway.domain.type.FunctionType;
import subway.domain.type.ManagementType;
import subway.service.StationService;
import subway.view.InputView;
import subway.view.OutputView;

import java.util.List;

public class StationController implements SubwayMapController2 {

    private final StationService stationService;
    private final InputView inputView = InputView.getInstance();

    public StationController(StationService stationService) {
        this.stationService = stationService;
    }

    @Override
    public void add() {
        String stationName = inputView.inputStationName(FunctionType.REGISTER);
        stationService.addStationByName(stationName);
    }

    @Override
    public void delete() {
        String stationName = inputView.inputStationName(FunctionType.REGISTER);
        stationService.deleteStationByName(stationName);
    }

    @Override
    public void read() {
        List<String> stationNames = stationService.getStationNames();
        OutputView.printNames(ManagementType.STATION, stationNames);
    }
}
