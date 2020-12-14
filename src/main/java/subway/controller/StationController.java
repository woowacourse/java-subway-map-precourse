package subway.controller;

import subway.service.StationService;
import subway.view.InputView;
import subway.view.OutputView;
import subway.vo.FunctionType;
import subway.vo.ManagementType;

import java.util.List;

public class StationController implements SubwayMapController {

    private final StationService stationService;
    private final InputView inputView = InputView.getInstance();

    public StationController(StationService stationService) {
        this.stationService = stationService;
    }

    @Override
    public void register() {
        String stationName = inputView.inputName(ManagementType.STATION, FunctionType.REGISTER);
        stationService.addStationByName(stationName);
    }

    @Override
    public void delete() {
        String stationName = inputView.inputName(ManagementType.STATION, FunctionType.DELETE);
        stationService.deleteStationByName(stationName);
    }

    @Override
    public void readNames() {
        List<String> stationNames = stationService.getStationNames();
        OutputView.printNames(ManagementType.STATION, stationNames);
    }

    @Override
    public void readEntireSubwayMap() {
    }
}
