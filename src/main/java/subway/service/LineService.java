package subway.service;

import static subway.domain.LineRepository.addLine;
import static subway.domain.LineRepository.deleteLineByName;
import static subway.domain.SectionRepository.addSectionStations;

import java.util.ArrayList;
import java.util.List;
import subway.domain.Line;
import subway.domain.Station;
import subway.view.InputView;
import subway.view.OutputView;

public class LineService {

    private final String PREFIX = System.lineSeparator() + "## ";
    private final String INPUT_UPDATE_LINE_NAME = "등록할 노선 이름을 입력하세요.";
    private final String INPUT_UP_BOUND_STATION_NAME = "등록할 노선의 상행 종점역 이름을 입력하세요.";
    private final String INPUT_DOWN_BOUND_STATION_NAME = "등록할 노선의 하행 종점역 이름을 입력하세요.";
    private final String INPUT_REMOVE_LINE = "삭제할 노선 이름을 입력하세요.";
    private final String INFO_REMOVE_LINE = "지하철 노선이 삭제되었습니다.";
    private final String INFO_UPDATE_LINE = "지하철 노선이 등록되었습니다.";
    private final String ERROR_NON_EXIST_LINE = "노선이 존재하지 않습니다.";

    InputView inputView = new InputView();
    OutputView outputView = new OutputView();

    //노선 추가 로직
    public void addLineLogic() {
        Line inputLine = new Line(inputView.getInput(PREFIX + INPUT_UPDATE_LINE_NAME));
        addLine(inputLine);
        addSectionStations(getUpBoundDownBound());
        outputView.printNotificationMessage(INFO_UPDATE_LINE);
    }

    //상행, 하행 종점역 반환
    private List<Station> getUpBoundDownBound() {
        List<Station> upBoundDownBound = new ArrayList<>();
        upBoundDownBound.add(inputUpBoundStation());
        upBoundDownBound.add(inputDownBoundStation());
        return upBoundDownBound;
    }

    //상행 종점역
    private Station inputUpBoundStation() {
        return new Station(inputView.getInput(PREFIX + INPUT_UP_BOUND_STATION_NAME));
    }

    //하행 종점역
    private Station inputDownBoundStation() {
        return new Station(inputView.getInput(PREFIX + INPUT_DOWN_BOUND_STATION_NAME));
    }

    //노선 삭제 로직
    public void removeLineLogic() {
        String inputRemoveLine = inputView.getInput(PREFIX + INPUT_UPDATE_LINE_NAME);
        removeLine(inputRemoveLine);
        outputView.printNotificationMessage(INFO_REMOVE_LINE);
    }

    //노선 삭제
    private void removeLine(String inputRemoveLine) {
        if (!deleteLineByName(inputRemoveLine)) {
            throw new IllegalArgumentException(ERROR_NON_EXIST_LINE);
        }
    }
}
