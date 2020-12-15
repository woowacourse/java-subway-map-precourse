package subway.service;

import subway.domain.Line;
import subway.domain.LineRepository;
import subway.domain.Station;
import subway.domain.StationRepository;
import subway.service.utils.StringToInt;
import subway.view.inputview.SectionManagementInputView;
import subway.view.outputview.SectionManagementOutputView;

import java.util.List;

public class SectionService {
    public static final int NAME_LENGTH_MIN = 2;
    public static final int STATIONS_LENGTH = 2;
    public static final String LINE_NAME_CONVENTION = "선";
    public static final String STATION_NAME_CONVENTION = "역";
    public static final String ERROR_LINE_NAME_LENGTH = "노선 이름은 2자 이상이여야 합니다.";
    public static final String ERROR_LINE_NAME_CONVENTION = "노선 이름의 마지막 글자는 \"선\" 이여야 합니다.";
    public static final String ERROR_STATION_NAME_LENGTH = "역 이름은 2자 이상이여야 합니다.";
    public static final String ERROR_STATION_NAME_CONVENTION = "역 이름의 마지막 글자는 \"역\" 이여야 합니다.";
    public static final String ERROR_NO_MATCH_LINE_NAME = "해당 이름의 노선이 존재하지 않습니다.";
    public static final String ERROR_NO_MATCH_STATION_NAME = "해당 이름의 역이 존재하지 않습니다.";
    public static final String ERROR_MINIMUM_STATIONS_LENGTH = "해당 노선에 등록된 역이 2개여서 삭제 기능을 수행할 수 없습니다.";
    public static final String SECTION_ADD_COMPLETE = "구간이 등록되었습니다.";
    public static final String SECTION_DELETE_COMPLETE = "구간이 삭제되었습니다.";

    private final SectionManagementInputView sectionManagementInputView;
    private final SectionManagementOutputView sectionManagementOutputView;

    public SectionService(SectionManagementInputView sectionManagementInputView, SectionManagementOutputView sectionManagementOutputView) {
        this.sectionManagementInputView = sectionManagementInputView;
        this.sectionManagementOutputView = sectionManagementOutputView;
    }

    public String getActionType() {
        String actionCommand;

        try {
            actionCommand = this.sectionManagementInputView.inputCommand();
        } catch (IllegalArgumentException e) {
            this.sectionManagementOutputView.printErrorMessage(e.getMessage());
            return getActionType();
        }

        return actionCommand;
    }

    public boolean add() {
        try {
            String lineName = this.sectionManagementInputView.inputLineNameForAdd();
            Line line = getLine(lineName);
            String stationName = this.sectionManagementInputView.inputStationNameForAdd();
            Station station = getStation(stationName);
            line.checkStationInLineToAdd(stationName);
            String position = this.sectionManagementInputView.inputPositionForAdd();
            int positionValue = StringToInt.convertToInt(position);
            line.insertStation(positionValue, station);
            this.sectionManagementOutputView.printActionComplete(SECTION_ADD_COMPLETE);
            return true;
        } catch (IllegalArgumentException e) {
            this.sectionManagementOutputView.printErrorMessage(e.getMessage());
            return false;
        }
    }

    public boolean delete() {
        String lineName = this.sectionManagementInputView.inputLineNameForDelete();

        try {
            Line line = getLine(lineName);
            validateStationsLength(line.getStations());
            String stationName = this.sectionManagementInputView.inputStationNameForDelete();
            Station station = getStation(stationName);
            line.checkStationInLineToDelete(stationName);
            line.deleteStation(station);
            this.sectionManagementOutputView.printActionComplete(SECTION_DELETE_COMPLETE);
            return true;
        } catch (IllegalArgumentException e) {
            this.sectionManagementOutputView.printErrorMessage(e.getMessage());
            return false;
        }
    }

    private void validateStationsLength(List<Station> stations) {
        if (stations.size() <= STATIONS_LENGTH) {
            throw new IllegalArgumentException(ERROR_MINIMUM_STATIONS_LENGTH);
        }
    }

    private Line getLine(String lineName) {
        validateLineNameLength(lineName);
        validateLineNameConvention(lineName);
        validateLineNameExistence(lineName);
        return LineRepository.findLine(lineName);
    }

    private Station getStation(String stationName) {
        validateStationNameLength(stationName);
        validateStationNameConvention(stationName);
        validateStationNameExistence(stationName);
        return StationRepository.findStation(stationName);
    }

    private void validateLineNameLength(String lineName) {
        if (lineName.length() < NAME_LENGTH_MIN) {
            throw new IllegalArgumentException(ERROR_LINE_NAME_LENGTH);
        }
    }

    private void validateLineNameConvention(String lineName) {
        if (!Character.toString(lineName.charAt(lineName.length() - 1)).equals(LINE_NAME_CONVENTION)) {
            throw new IllegalArgumentException(ERROR_LINE_NAME_CONVENTION);
        }
    }

    private void validateLineNameExistence(String lineName) {
        boolean isAnyMatch = LineRepository.lines().stream()
                .anyMatch(line -> line.getName().equals(lineName));

        if (!isAnyMatch) {
            throw new IllegalArgumentException(ERROR_NO_MATCH_LINE_NAME);
        }
    }

    private void validateStationNameLength(String stationName) {
        if (stationName.length() < NAME_LENGTH_MIN) {
            throw new IllegalArgumentException(ERROR_STATION_NAME_LENGTH);
        }
    }

    private void validateStationNameConvention(String stationName) {
        if (!Character.toString(stationName.charAt(stationName.length() - 1)).equals(STATION_NAME_CONVENTION)) {
            throw new IllegalArgumentException(ERROR_STATION_NAME_CONVENTION);
        }
    }

    private void validateStationNameExistence(String stationName) {
        boolean isAnyMatch = StationRepository.stations().stream()
                .anyMatch(station -> station.getName().equals(stationName));

        if (!isAnyMatch) {
            throw new IllegalArgumentException(ERROR_NO_MATCH_STATION_NAME);
        }
    }
}
