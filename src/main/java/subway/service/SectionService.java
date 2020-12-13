package subway.service;

import subway.domain.Line;
import subway.domain.Station;
import subway.repository.LineRepository;
import subway.repository.StationRepository;
import subway.view.InputView;
import subway.view.OutputView;

import static subway.repository.LineRepository.*;
import static subway.repository.StationRepository.*;
import static subway.view.OutputView.askMessage;
import static subway.view.OutputView.warnMessage;

public class SectionService {
    private final String ASK_LINE_NAME = "노선 이름을 입력하세요.";
    private final String ASK_DELETE_LINE_NAME = "삭제할 노선 이름을 입력하세요.";
    private final String ASK_STATION_NAME = "역 이름을 입력하세요.";
    private final String ASK_DELETE_STATION_NAME = "삭제할 역 이름을 입력하세요.";
    private final String ASK_ORDER_NAME = "순서를 입력하세요.";
    private final String LINE_NOT_EXIST_WARN = "존재하지 않는 노선 입니다.";
    private final String STATION_NOT_EXIST_WARN = "존재하지 않는 역 입니다.";

    public boolean addSection(InputView inputView) {
        askMessage(ASK_LINE_NAME);
        Line findLine = findLineByName(inputView.inputName());
        if (findLine == null) {
            warnMessage(LINE_NOT_EXIST_WARN);
            return false;
        }
        askMessage(ASK_STATION_NAME);
        Station findStation = findStationByName(inputView.inputName());
        if (findStation == null) {
            warnMessage(STATION_NOT_EXIST_WARN);
            return false;
        }
        askMessage(ASK_ORDER_NAME);
        int orderNum = inputView.inputNumber();
        return LineRepository.addSection(findLine, findStation, orderNum);
    }

    public boolean deleteSection(InputView inputView) {
        askMessage(ASK_DELETE_LINE_NAME);
        Line findLine = findLineByName(inputView.inputName());
        if (findLine == null) {
            warnMessage(LINE_NOT_EXIST_WARN);
            return false;
        }
        askMessage(ASK_DELETE_STATION_NAME);
        Station findStation = findStationByName(inputView.inputName());
        if (findStation == null) {
            warnMessage(STATION_NOT_EXIST_WARN);
            return false;
        }
        return LineRepository.deleteSection(findLine, findStation);
    }
}
