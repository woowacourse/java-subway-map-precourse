package subway.service;

import subway.domain.Station;
import subway.domain.StationRepository;
import subway.exception.CannotFindStationByNameException;
import subway.view.OutputView;

public class StationService {

    public static final String STATION_REGISTER_SUCCESS = "지하철 역이 등록되었습니다.";
    public static final String STATION_UNREGISTER_SUCCESS = "지하철 역이 삭제되었습니다.";

    public static void resisterStationByName(String name) {
        Station.from(name).save();
        OutputView.printInfo(STATION_REGISTER_SUCCESS);
    }

    public static void removeStationByName(String name) {
        if (StationRepository.deleteStation(name)) {
            OutputView.printInfo(STATION_UNREGISTER_SUCCESS);
            return;
        }
        throw new CannotFindStationByNameException(name);
    }

    public static void listAllStations() {
        StationRepository.stations().forEach(station -> OutputView.printInfo(station.getName()));
    }
}
