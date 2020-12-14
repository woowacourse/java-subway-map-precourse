package subway.service;

import subway.domain.Line;
import subway.domain.Station;
import subway.repository.LineRepository;
import subway.view.InputView;

import static subway.domain.Line.validateLineName;
import static subway.repository.LineRepository.deleteLineByName;
import static subway.repository.StationRepository.findStationByName;
import static subway.view.OutputView.askMessage;
import static subway.view.OutputView.warnMessage;

public class LineService {
    private final String ASK_ADD_LINE_NAME = "등록할 노선 이름을 입력하세요.";
    private final String ASK_DELETE_LINE_NAME = "삭제할 노선 이름을 입력하세요.";
    private final String ASK_UP_STATION_NAME = "등록할 노선의 상행 종점역 이름을 입력하세요.";
    private final String ASK_DOWN_STATION_NAME = "등록할 노선의 하행 종점역 이름을 입력하세요.";
    private final String UPSTATION_NOT_EXIST_WARN = "존재하지 않는 상행종점역 입니다.";
    private final String DOWNSTATION_NOT_EXIST_WARN = "존재하지 않는 하행종점역 입니다.";
    private final String BOTH_STATION_NOT_EXIST_WARN = "둘 다 존재하지 않는 역 입니다.";
    private final String LINE_LIST_MESSAGE = "노선 목록";
    private final String UP = "UP";
    private final String DOWN = "DOWN";

    public void addLine(InputView inputView) {
        askMessage(ASK_ADD_LINE_NAME);
        String lineName = inputView.inputName();
        if (!validateLineName(lineName)) {
            return;
        }
        Station upStation = getStation(inputView, UP);
        Station downStation = getStation(inputView, DOWN);
        if (!stationExistValidate(upStation, downStation)) {
            return;
        }
        LineRepository.addLine(new Line(lineName, upStation, downStation));
    }

    public void deleteLine(InputView inputView) {
        askMessage(ASK_DELETE_LINE_NAME);
        deleteLineByName(inputView.inputName());
    }

    public void printLineList() {
        askMessage(LINE_LIST_MESSAGE);
        LineRepository.printLineList();
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
        if (command.equals(UP)) {
            askMessage(ASK_UP_STATION_NAME);
            String stationName = inputView.inputName();
            return findStationByName(stationName);
        }
        if (command.equals(DOWN)) {
            askMessage(ASK_DOWN_STATION_NAME);
            String stationName = inputView.inputName();
            return findStationByName(stationName);
        }
        return null;
    }
}
