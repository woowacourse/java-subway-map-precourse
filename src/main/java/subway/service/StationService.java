package subway.service;

import static subway.domain.SectionRepository.hasStationOnLine;
import static subway.domain.StationRepository.addStation;
import static subway.domain.StationRepository.deleteStation;

import subway.domain.Station;
import subway.view.InputView;
import subway.view.OutputView;

public class StationService {

    private final String PREFIX = System.lineSeparator() + "## ";
    private final String INPUT_UPDATE_STATION_NAME = "등록할 역 이름을 입력하세요.";
    private final String INPUT_REMOVE_STATION_NAME = "삭제할 역 이름을 입력하세요.";
    private final String INFO_REMOVE_STATION = "지하철 노선이 삭제되었습니다.";
    private final String INFO_STATION_REGISTRATION = "지하철 역이 등록되었습니다.";
    private final String ERROR_NON_EXIST_STATION = "역이 존재하지 않습니다.";
    private final String ERROR_STATION_ON_LINE = "노선에 등록된 역은 삭제할 수 없습니다.";

    InputView inputView = new InputView();
    OutputView outputView = new OutputView();

    //역 추가 로직
    public void addStationLogic() {
        Station input = new Station(inputView.getInput(PREFIX + INPUT_UPDATE_STATION_NAME));
        addStation(input);
        outputView.printNotificationMessage(INFO_STATION_REGISTRATION);
    }

    //역 삭제
    public void removeStation() {
        if (validate(inputView.getInput(PREFIX + INPUT_REMOVE_STATION_NAME))) {
            outputView.printNotificationMessage(INFO_REMOVE_STATION);
        }
    }

    //역 유효성 확인
    private boolean validate(String inputRemoveStationName) {
        return validateStationOnLine(inputRemoveStationName)
                && validateExistStationName(inputRemoveStationName);
    }

    //노선에 등록된 역 유효성 확인
    private boolean validateStationOnLine(String inputRemoveStationName) {
        if (hasStationOnLine(inputRemoveStationName)) {
            throw new IllegalArgumentException(ERROR_STATION_ON_LINE);
        }
        return true;
    }

    //등록되지 않은 역 유효성 확인
    private boolean validateExistStationName(String inputRemoveStationName) {
        if (!deleteStation(inputRemoveStationName)) {
            throw new IllegalArgumentException(ERROR_NON_EXIST_STATION);
        }
        return true;
    }
}
