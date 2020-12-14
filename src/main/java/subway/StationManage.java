package subway;

import subway.domain.station.StationService;
import subway.domain.station.dto.StationDeleteReqDto;
import subway.domain.station.dto.StationSaveReqDto;
import subway.service.input.InputService;
import subway.service.output.OutputService;
import subway.view.StationView;

public class StationManage {
    private final InputService inputService;
    private final OutputService outputService;
    private final StationService stationService;

    public StationManage(InputService inputService, OutputService outputService, StationService stationService) {
        this.inputService = inputService;
        this.outputService = outputService;
        this.stationService = stationService;
    }

    public void startMange() {
        StationView stationView = new StationView(outputService);
        stationView.showOptions();
        int manageStationOption = inputService.getManageStationOption();
        chooseManageStationOption(manageStationOption, stationView);
        if (isBack(manageStationOption)) {
            return;
        }
    }

    private void chooseManageStationOption(int manageStationOption, StationView stationView) {
        if (manageStationOption == InputService.ADD) {
            addStation(stationView);
        }
        if (manageStationOption == InputService.DELETE) {
            deleteStation(stationView);
        }
        if (manageStationOption == InputService.FIND) {
            stationView.printAllStations(stationService.getStations());
        }
    }

    private void addStation(StationView stationView) {
        stationView.showAdd();
        String stationName = getName();
        stationService.saveStation(new StationSaveReqDto(stationName));
        stationView.showAfterAdd();
    }

    private void deleteStation(StationView stationView) {
        stationView.showDelete();
        String stationName = getName();
        stationService.deleteStation(new StationDeleteReqDto(stationName));
        stationView.showAfterDelete();
    }

    private boolean isBack(int manageStationOption) {
        if (manageStationOption == InputService.OPTION_BACK) {
            return true;
        }
        return false;
    }

    private String getName() {
        String name = inputService.getName();
        return name;
    }
}
