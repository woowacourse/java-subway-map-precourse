package subway.service;

import subway.repository.StationRepository;
import subway.view.InputView;

import static subway.domain.Station.createStation;
import static subway.view.OutputView.askMessage;

public class StationService {
    private final String ASK_ADD_STATION_NAME = "등록할 역 이름을 입력하세요.";
    private final String ASK_DELETE_STATION_NAME = "삭제할 역 이름을 입력하세요.";
    private final String STATION_LIST_MESSAGE = "역 목록";

    public void addStation(InputView inputView) {
        askMessage(ASK_ADD_STATION_NAME);
        createStation(inputView.inputName());
    }

    public void deleteStation(InputView inputView) {
        askMessage(ASK_DELETE_STATION_NAME);
        StationRepository.deleteStation(inputView.inputName());
    }

    public void printStationList() {
        askMessage(STATION_LIST_MESSAGE);
        StationRepository.printStationList();
    }
}
