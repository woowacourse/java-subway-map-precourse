package subway.service;

import static subway.domain.LineRepository.hasLine;
import static subway.domain.SectionRepository.addSection;
import static subway.domain.SectionRepository.hasSectionStation;
import static subway.domain.SectionRepository.removeSection;
import static subway.domain.SectionRepository.removeSectionRange;
import static subway.domain.SectionRepository.validateOrderRange;
import static subway.domain.StationRepository.updateStation;

import subway.domain.Line;
import subway.domain.Station;
import subway.view.InputView;
import subway.view.OutputView;

public class SectionService {

    private final String PREFIX = System.lineSeparator() + "## ";
    private final String INPUT_LINE = "노선을 입력하세요.";
    private final String INPUT_STATION_NAME = "역이름을 입력하세요.";
    private final String INPUT_ORDER = "순서를 입력하세요.";
    private final String INPUT_REMOVE_LINE = "삭제할 구간의 노선을 입력해주세요";
    private final String INPUT_REMOVE_STATION_NAME = "삭제할 구간의 역을 입력하세요.";
    private final String INFO_UPDATE_SECTION = "구간이 등록되었습니다.";
    private final String INFO_REMOVE_SECTION = "구간이 삭제되었습니다.";
    private final String ERROR_NON_EXIST_LINE = "노선이 존재하지 않습니다.";
    private final String ERROR_NON_EXIST_STATION = "역이 존재하지 않습니다.";
    private final String ERROR_ALREADY_EXIST = "이미 등록되어 있습니다.";
    private final String ERROR_SECTION_LENGTH = "노선에 포함된 역이 두 개 이하입니다.";

    InputView inputView = new InputView();
    OutputView outputView = new OutputView();

    //구간 추가 로직
    public void addSectionLogic() {
        Line line = inputLineName();
        Station station = inputStationName(line);
        int order = inputStationOrder();
        addSection(order, line, station);
        outputView.printNotificationMessage(INFO_UPDATE_SECTION);
    }

    //노선 입력
    private Line inputLineName() {
        Line inputLine = new Line(inputView.getInput(PREFIX + INPUT_LINE));
        validateLine(inputLine);
        return inputLine;
    }

    //등록되지 않은 노선 유효성 확인
    private void validateLine(Line inputLine) {
        if (!hasLine(inputLine)) {
            throw new IllegalArgumentException(ERROR_NON_EXIST_LINE);
        }
    }

    //역 입력
    private Station inputStationName(Line line) {
        Station inputStationName = new Station(inputView.getInput(PREFIX + INPUT_STATION_NAME));
        validateSectionStation(line, inputStationName);
        updateStation(inputStationName);
        return inputStationName;
    }

    //역이 구간에 등록되어 있는지 유효성 확인
    private void validateSectionStation(Line line, Station inputStationName) {
        if (hasSectionStation(line, inputStationName)) {
            throw new IllegalArgumentException(ERROR_ALREADY_EXIST);
        }
    }

    //순서 입력
    private int inputStationOrder() {
        int inputStationOrder = Integer.parseInt(inputView.getInput(PREFIX + INPUT_ORDER));
        validateOrderRange(inputStationOrder);
        return inputStationOrder;
    }

    //구간 삭제 로직
    public void removeSectionLogic() {
        Line inputRemoveLine = inputLineName();
        Station inputRemoveStation = inputStationNameToDelete();
        validate(inputRemoveLine, inputRemoveStation);
        outputView.printNotificationMessage(INFO_REMOVE_SECTION);
    }

    //삭제할 역 입력
    private Station inputStationNameToDelete() {
        return new Station(inputView.getInput(PREFIX + INPUT_REMOVE_STATION_NAME));
    }

    //삭제 유효성 확인
    private void validate(Line inputRemoveLine, Station inputRemoveStation) {
        validateSectionRange(inputRemoveLine);
        validateSection(inputRemoveLine, inputRemoveStation);
    }

    //삭제할 역 유효성 확인
    private void validateSection(Line inputRemoveLine, Station inputRemoveStation) {
        if (!removeSection(inputRemoveLine, inputRemoveStation)) {
            throw new IllegalArgumentException(ERROR_NON_EXIST_STATION);
        }
    }

    //삭제할 노선의 역 개수 유효성 확인
    private void validateSectionRange(Line inputRemoveLine) {
        if (!removeSectionRange(inputRemoveLine)) {
            throw new IllegalArgumentException(ERROR_SECTION_LENGTH);
        }
    }
}
