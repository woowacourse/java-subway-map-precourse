package subway.service;

import subway.domain.Station;
import subway.repository.StationRepository;
import subway.view.InputView;

import static subway.view.OutputView.askStationName;
import static subway.view.OutputView.warnMessage;

public class StationService {
    private final String STATION_NAME_LENGTH_WARN = "역 이름은 2글자 이상이어야 합니다.\n";

    public boolean addStation(InputView inputView) {
        askStationName();
        String stationName = inputView.inputStationName();
        if (stationName.length() < 2) {
            warnMessage(STATION_NAME_LENGTH_WARN);
        }
        return StationRepository.addStation(new Station(stationName));
    }
}
