package subway.service;

import subway.domain.Station;
import subway.domain.StationRepository;
import subway.view.inputview.StationManagementInputView;
import subway.view.outputview.StationManagementOutputView;

import java.util.stream.Collectors;

public class StationService {
    public static final int STATIONS_LENGTH_MIN = 1;
    public static final String ERROR_NO_STATIONS = "등록되어 있는 역이 없습니다.";
    public static final String STATION_ADD_COMPLETE = "지하철 역이 등록되었습니다.";
    public static final String STATION_DELETE_COMPLETE = "지하철 역이 삭제되었습니다.";
    private StationManagementInputView stationManagementView;
    private StationManagementOutputView stationManagementOutputView;

    public StationService(StationManagementInputView stationManagementView, StationManagementOutputView stationManagementOutputView) {
        this.stationManagementView = stationManagementView;
        this.stationManagementOutputView = stationManagementOutputView;
    }

    public String getActionType() {
        String actionCommand;

        try {
            actionCommand = this.stationManagementView.inputCommand();
        } catch (IllegalArgumentException e) {
            this.stationManagementOutputView.printErrorMessage(e.getMessage());
            return getActionType();
        }

        return actionCommand;
    }

    public boolean add() {
        String stationName = this.stationManagementView.inputStationNameToAdd();

        try {
            StationRepository.addStation(new Station(stationName));
            this.stationManagementOutputView.printActionComplete(STATION_ADD_COMPLETE);
            return true;
        } catch (IllegalArgumentException e) {
            this.stationManagementOutputView.printErrorMessage(e.getMessage());
            return false;
        }
    }

    public boolean delete() {
        String stationName = this.stationManagementView.inputStationNameToDelete();

        try {
            StationRepository.deleteStation(stationName);
            this.stationManagementOutputView.printActionComplete(STATION_DELETE_COMPLETE);
            return true;
        } catch (IllegalArgumentException e) {
            this.stationManagementOutputView.printErrorMessage(e.getMessage());
            return false;
        }
    }

    public boolean print() {
        if (StationRepository.stations().size() < STATIONS_LENGTH_MIN) {
            this.stationManagementOutputView.printErrorMessage(ERROR_NO_STATIONS);
            return false;
        }

        this.stationManagementOutputView.printStations(StationRepository
                .stations()
                .stream()
                .map(Station::getName)
                .collect(Collectors.toList()));
        return true;
    }
}
