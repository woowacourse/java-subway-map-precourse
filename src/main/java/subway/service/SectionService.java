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
    private final String INPUT_NUMBER_WARN = "0 이상의 숫자를 입력해주세요.";


    public void addSection(InputView inputView) {
        askMessage(ASK_LINE_NAME);
        Line findLine = findLineByName(inputView.inputName());
        if (findLine == null) {
            return;
        }

        askMessage(ASK_STATION_NAME);
        Station findStation = findStationByName(inputView.inputName());
        if (findStation == null) {
            return;
        }

        askMessage(ASK_ORDER_NAME);
        int orderNum = inputView.inputNumber();
        if (orderNum == -1) {
            warnMessage(INPUT_NUMBER_WARN);
            return;
        }

        LineRepository.addSection(findLine, findStation, orderNum);
    }

    public void deleteSection(InputView inputView) {
        askMessage(ASK_DELETE_LINE_NAME);
        Line findLine = findLineByName(inputView.inputName());
        if (findLine == null) {
            return;
        }

        askMessage(ASK_DELETE_STATION_NAME);
        Station findStation = findStationByName(inputView.inputName());
        if (findStation == null) {
            return;
        }

        LineRepository.deleteSection(findLine, findStation);
    }
}
