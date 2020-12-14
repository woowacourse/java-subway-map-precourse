package subway.service;

import subway.domain.Line;
import subway.domain.LineRepository;
import subway.domain.Station;
import subway.domain.StationRepository;
import subway.view.inputview.LineManagementInputView;
import subway.view.outputview.LineManagementOutputView;

import java.util.Comparator;
import java.util.stream.Collectors;

public class LineService {
    public static final int NAME_LENGTH_MIN = 2;
    public static final int LINES_LENGTH_MIN = 1;
    public static final String NAME_CONVENTION = "선";
    public static final String ERROR_NAME_LENGTH = "노선 이름은 2자 이상이여야 합니다.";
    public static final String ERROR_NAME_CONVENTION = "노선 이름의 마지막 글자는 \"선\" 이여야 합니다.";
    public static final String ERROR_NO_LINES = "등록되어 있는 노선이 없습니다.";
    public static final String ERROR_NO_MATCH_NAME = "해당 이름의 역이 존재하지 않습니다.";
    public static final String ERROR_UPWARD_DOWNWARD_SAME = "상행 종점역과 하행 종점역은 달라야 합니다.";
    public static final String LINE_ADD_COMPLETE = "지하철 노선이 등록되었습니다.";
    public static final String LINE_DELETE_COMPLETE = "지하철 노선이 삭제되었습니다.";

    private LineManagementInputView lineManagementInputView;
    private LineManagementOutputView lineManagementOutputView;

    public LineService(LineManagementInputView lineManagementInputView, LineManagementOutputView lineManagementOutputView) {
        this.lineManagementInputView = lineManagementInputView;
        this.lineManagementOutputView = lineManagementOutputView;
    }

    public String getActionType() {
        String actionCommand;

        try {
            actionCommand = this.lineManagementInputView.inputCommand();
        } catch (IllegalArgumentException e) {
            this.lineManagementOutputView.printErrorMessage(e.getMessage());
            return getActionType();
        }

        return actionCommand;
    }

    public boolean add() {
        String lineName = this.lineManagementInputView.inputLineNameToAdd();

        try {
            LineRepository.checkDuplication(lineName);
            validateNameLength(lineName);
            validateNameConvention(lineName);
            String upwardStation = getUpwardStation();
            String downwardStation = getDownwardStation();
            addLine(lineName, upwardStation, downwardStation);
            this.lineManagementOutputView.printActionComplete(LINE_ADD_COMPLETE);
            return true;
        } catch (IllegalArgumentException e) {
            this.lineManagementOutputView.printErrorMessage(e.getMessage());
            return false;
        }
    }

    public boolean delete() {
        String lineName = this.lineManagementInputView.inputLineNametoDelete();

        try {
            LineRepository.deleteLineByName(lineName);
            this.lineManagementOutputView.printActionComplete(LINE_DELETE_COMPLETE);
            return true;
        } catch (IllegalArgumentException e) {
            this.lineManagementOutputView.printErrorMessage(e.getMessage());
            return false;
        }
    }

    public boolean print() {
        if (LineRepository.lines().size() < LINES_LENGTH_MIN) {
            this.lineManagementOutputView.printErrorMessage(ERROR_NO_LINES);
            return false;
        }

        this.lineManagementOutputView.printLines(LineRepository
                .lines()
                .stream()
                .map(Line::getName)
                .collect(Collectors.toList()));
        return true;
    }

    private String getUpwardStation() {
        String upwardStationName = this.lineManagementInputView.inputUpwardEndStationName();
        validateNameExistence(upwardStationName);
        return upwardStationName;
    }

    private String getDownwardStation() {
        String downwardStationName = this.lineManagementInputView.inputDownwardEndStationName();
        validateNameExistence(downwardStationName);
        return downwardStationName;
    }

    private void addLine(String lineName, String upward, String downward) {
        validateSameStation(upward, downward);
        Line newLine = new Line(lineName);
        Station upwardStation = StationRepository.findStation(upward);
        Station downwardStation = StationRepository.findStation(downward);

        newLine.addUpAndDownWardStations(upwardStation, downwardStation);
        LineRepository.addLine(newLine);
    }

    private void validateSameStation(String upward, String downward) {
        if (upward.equals(downward)) {
            throw new IllegalArgumentException(ERROR_UPWARD_DOWNWARD_SAME);
        }
    }

    private void validateNameExistence(String stationName) {
        boolean isAnyMatch = StationRepository.stations().stream()
                .anyMatch(station -> station.getName().equals(stationName));

        if (!isAnyMatch) {
            throw new IllegalArgumentException(ERROR_NO_MATCH_NAME);
        }
    }

    private void validateNameLength(String lineName) {
        if (lineName.length() < NAME_LENGTH_MIN) {
            throw new IllegalArgumentException(ERROR_NAME_LENGTH);
        }
    }

    private void validateNameConvention(String lineName) {
        if (!Character.toString(lineName.charAt(lineName.length() - 1)).equals(NAME_CONVENTION)) {
            throw new IllegalArgumentException(ERROR_NAME_CONVENTION);
        }
    }
}
