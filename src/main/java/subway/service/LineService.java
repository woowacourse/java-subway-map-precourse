package subway.service;

import java.util.ArrayList;
import java.util.List;
import subway.domain.Line;
import subway.domain.LineRepository;
import subway.domain.SectionRepository;
import subway.domain.Station;
import subway.view.InputView;
import subway.view.OutputView;

public class LineService {

    private final String INPUT_UPDATE_LINE_NAME = "## 등록할 노선 이름을 입력하세요.";
    private final String INPUT_UP_BOUND_STATION_NAME = "## 등록할 노선의 상행 종점역 이름을 입력하세요.";
    private final String INPUT_DOWN_BOUND_STATION_NAME = "## 등록할 노선의 하행 종점역 이름을 입력하세요.";
    private final String INPUT_REMOVE_LINE = "## 삭제할 노선 이름을 입력하세요.";
    private final String INFO_REMOVE_LINE = "지하철 노선이 삭제되었습니다.";
    private final String ERROR_NON_EXIST_LINE = "노선이 존재하지 않습니다.";

    InputView inputView = new InputView();
    OutputView outputView = new OutputView();

    public void inputAddLine() {
        Line inputLine = new Line(inputView.getInput(INPUT_UPDATE_LINE_NAME));
        try {
            LineRepository.addLine(inputLine);
            SectionRepository.addSections(inputLine, getUpBoundDownBound());
        } catch (IllegalArgumentException e) {
            outputView.printError(e);
        }
    }

    private List<Station> getUpBoundDownBound() {
        List<Station> upBoundDownBound = new ArrayList<>();
        upBoundDownBound.add(inputUpBoundStation());
        upBoundDownBound.add(inputDownBoundStation());
        return upBoundDownBound;
    }

    private Station inputUpBoundStation() {
        return new Station(inputView.getInput(INPUT_UP_BOUND_STATION_NAME));
    }

    private Station inputDownBoundStation() {
        return new Station(inputView.getInput(INPUT_DOWN_BOUND_STATION_NAME));
    }

    public void inputRemoveLine() {
        String inputRemoveLine = inputView.getInput(INPUT_UPDATE_LINE_NAME);
        try {
            removeLine(inputRemoveLine);
            SectionRepository.removeSections(new Line(inputRemoveLine));
        } catch (IllegalArgumentException e) {
            outputView.printError(e);
        }
    }

    public void removeLine(String inputRemoveLine) {
        if (!LineRepository.deleteLineByName(inputRemoveLine)) {
            throw new IllegalArgumentException(ERROR_NON_EXIST_LINE);
        }
        outputView.printNotificationMessage(INFO_REMOVE_LINE);
    }
}
