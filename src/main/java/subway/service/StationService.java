package subway.service;

import subway.domain.Station;
import subway.domain.StationRepository;
import subway.view.InputView;
import subway.view.OutputView;

public class StationService {

    private final String INPUT_UPDATE_STATION_NAME = "## 등록할 역 이름을 입력하세요.";
    private final String INPUT_REMOVE_STATION_NAME = "## 삭제할 역 이름을 입력하세요.";
    private final String INFO_REMOVE_STATION = "지하철 노선이 삭제되었습니다.";
    private final String INFO_STATION_REGISTRATION = "지하철 역이 등록되었습니다.";
    private final String ERROR_NON_EXIST_STATION = "역이 존재하지 않습니다.";
    private final String ERROR_STATION_ON_LINE = "노선에 등록된 역은 삭제할 수 없습니다.";

    InputView inputView = new InputView();
    OutputView outputView = new OutputView();

    public void addStation() {
        Station input = new Station(inputView.getInput(INPUT_UPDATE_STATION_NAME));
        try {
            StationRepository.addStation(input);
            outputView.printNotificationMessage(INFO_STATION_REGISTRATION);
        } catch (IllegalArgumentException e) {
            outputView.printError(e);
        }
    }
}
