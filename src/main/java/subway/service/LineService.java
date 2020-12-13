package subway.service;

import subway.domain.Line;
import subway.domain.Station;
import subway.repository.LineRepository;
import subway.repository.StationRepository;
import subway.view.InputView;
import subway.view.OutputView;

import static subway.repository.LineRepository.*;
import static subway.repository.StationRepository.*;
import static subway.view.OutputView.*;

public class LineService {
    private final String LINE_NAME_LENGTH_WARN = "노선 이름은 2글자 이상이어야 합니다.";
    private final String ASK_ADD_LINE_NAME = "등록할 노선 이름을 입력하세요.";
    private final String ASK_DELETE_LINE_NAME = "삭제할 노선 이름을 입력하세요.";
    private final String ASK_UP_STATION_NAME = "등록할 노선의 상행 종점역 이름을 입력하세요.";
    private final String ASK_DOWN_STATION_NAME = "등록할 노선의 상행 종점역 이름을 입력하세요.";
    private final String UPSTATION_NOT_EXIST_WARN = "존재하지 않는 상행종점역 입니다.";
    private final String DOWNSTATION_NOT_EXIST_WARN = "존재하지 않는 하행종점역 입니다.";
    private final String BOTH_STATION_NOT_EXIST_WARN = "둘 다 존재하지 않는 역 입니다.";
    private final String LINE_NOT_EXIST_WARN = "존재하지 않는 노선 입니다.";
    private final String LINE_LIST_MESSAGE = "노선 목록";
    private final String UP_COMMAND = "UP";
    private final String DOWN_COMMAND = "DOWN";
    private final int MIN_NAME_LENGTH = 2;

    public boolean addLine(InputView inputView) {
        askMessage(ASK_ADD_LINE_NAME);
        String lineName = inputView.inputName();
        if (lineName.length() < MIN_NAME_LENGTH) {
            warnMessage(LINE_NAME_LENGTH_WARN);
            return false;
        }
        Station upStation = getStation(inputView, UP_COMMAND);
        Station downStation = getStation(inputView, DOWN_COMMAND);
        if (!stationExistValidate(upStation, downStation)) {
            return false;
        }
        return LineRepository.addLine(new Line(lineName, upStation, downStation));
    }

    public boolean deleteLine(InputView inputView) {
        askMessage(ASK_DELETE_LINE_NAME);
        String lineName = inputView.inputName();
        if (!deleteLineByName(lineName)) {
            warnMessage(LINE_NOT_EXIST_WARN);
            return false;
        }
        return true;
    }

    public boolean stationExistValidate(Station upStation, Station downStation) {
        if (upStation == null && downStation == null) {
            warnMessage(BOTH_STATION_NOT_EXIST_WARN);
            return false;
        }
        if (downStation == null) {
            warnMessage(DOWNSTATION_NOT_EXIST_WARN);
            return false;
        }
        if (upStation == null) {
            warnMessage(UPSTATION_NOT_EXIST_WARN);
            return false;
        }
        return true;
    }

    public Station getStation(InputView inputView, String command) {
        if (command.equals(UP_COMMAND)) {
            askMessage(ASK_UP_STATION_NAME);
            String stationName = inputView.inputName();
            return findStationByName(stationName);
        }
        if (command.equals(DOWN_COMMAND)) {
            askMessage(ASK_DOWN_STATION_NAME);
            String stationName = inputView.inputName();
            return findStationByName(stationName);
        }
        return null;
    }

    public void printLineList() {
        askMessage(LINE_LIST_MESSAGE);
        lines().
                forEach(line -> stationMessage(line.getName()));
    }
}
