package subway.service;

import subway.domain.Line;
import subway.domain.Station;
import subway.repository.LineRepository;
import subway.repository.StationRepository;
import subway.view.InputView;
import subway.view.OutputView;

import static subway.repository.StationRepository.*;
import static subway.view.OutputView.*;

public class LineService {
    private final String LINE_NAME_LENGTH_WARN = "노선 이름은 2글자 이상이어야 합니다.\n";
    private final String ASK_ADD_LINE_NAME = "등록할 노선 이름을 입력하세요.";
    private final String ASK_UP_STATION_NAME = "등록할 노선의 상행 종점역 이름을 입력하세요.";
    private final String ASK_DOWN_STATION_NAME = "등록할 노선의 상행 종점역 이름을 입력하세요.";
    private final String STATION_NOT_EXIST_WARN = "존재하지 않는 역 이름입니다.\n";
    private final String UP_COMMAND = "UP";
    private final String DOWN_COMMAND = "DOWN";

    public boolean addLine(InputView inputView) {
        askMessage(ASK_ADD_LINE_NAME);
        String lineName = inputView.inputName();
        if (lineName.length() < 2) {
            warnMessage(LINE_NAME_LENGTH_WARN);
            return false;
        }
        Station upStation = getStation(inputView, UP_COMMAND);
        if (!stationExistValidate(upStation)) {
            return stationExistValidate(upStation);
        }
        Station downStation = getStation(inputView, DOWN_COMMAND);
        if (!stationExistValidate(downStation)) {
            return stationExistValidate(downStation);
        }
        return LineRepository.addLine(new Line(lineName, upStation, downStation));
    }

    public boolean stationExistValidate(Station station) {
        if (station == null) {
            warnMessage(STATION_NOT_EXIST_WARN);
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
}
