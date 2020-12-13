package subway.service;

import subway.domain.Station;
import subway.repository.StationRepository;
import subway.view.InputView;

import static subway.repository.StationRepository.stations;
import static subway.view.OutputView.*;

public class StationService {
    private final String STATION_NAME_LENGTH_WARN = "역 이름은 2글자 이상이어야 합니다.";
    private final String ASK_ADD_STATION_NAME = "등록할 역 이름을 입력하세요.";
    private final String ASK_DELETE_STATION_NAME = "삭제할 역 이름을 입력하세요.";
    private final String STATION_LIST_MESSAGE = "역 목록";
    private final String STATION_SIZE_ZERO = "등록된 역이 없습니다.";

    public boolean addStation(InputView inputView) {
        askMessage(ASK_ADD_STATION_NAME);
        String stationName = inputView.inputName();
        if (stationName.length() < 2) {
            warnMessage(STATION_NAME_LENGTH_WARN);
            return false;
        }
        return StationRepository.addStation(new Station(stationName));
    }

    public boolean deleteStation(InputView inputView) {
        askMessage(ASK_DELETE_STATION_NAME);
        String stationName = inputView.inputName();
        return StationRepository.deleteStation(stationName);
    }

    public void printStationList() {
        askMessage(STATION_LIST_MESSAGE);
        if (stations().size() == 0) {
            warnMessage(STATION_SIZE_ZERO);
            return;
        }
        stations()
                .forEach(station -> infoMessage(station.getName()));
    }
}
