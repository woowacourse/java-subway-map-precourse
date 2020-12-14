package subway;

import subway.domain.station.StationService;
import subway.domain.station.dto.StationDeleteReqDto;
import subway.domain.station.dto.StationSaveReqDto;
import subway.service.input.InputService;
import subway.view.StationView;

public class StationManage implements Manage {
    private final InputService inputService;
    private final StationService stationService;
    private final StationView stationView;

    public StationManage(InputService inputService, StationService stationService, StationView stationView) {
        this.inputService = inputService;
        this.stationService = stationService;
        this.stationView = stationView;
    }

    @Override
    public void startManage() {
        stationView.showOptions();
        int manageStationOption = inputService.getManageStationOption();
        chooseManageStationOption(manageStationOption);
        if (isBack(manageStationOption)) {
            return;
        }
    }

    @Override
    public void showStatus() {
        stationView.printAllStations(stationService.getStations());
    }

    private void chooseManageStationOption(int manageStationOption) {
        if (manageStationOption == InputService.ADD) {
            addStation(stationView);
        }
        if (manageStationOption == InputService.DELETE) {
            deleteStation(stationView);
        }
        if (manageStationOption == InputService.FIND) {
            showStatus();
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

    private String getName() {
        String name = inputService.getName();
        return name;
    }

    private boolean isBack(int manageStationOption) {
        if (manageStationOption == InputService.OPTION_BACK) {
            return true;
        }
        return false;
    }
}
