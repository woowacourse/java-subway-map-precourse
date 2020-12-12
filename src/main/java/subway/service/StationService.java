package subway.service;

import subway.domain.Station;
import subway.domain.StationRepository;
import subway.exception.CannotFindStationByNameException;
import subway.view.OutputView;

public class StationService {

    public static final String STATION_REGISTER_SUCCESS = "지하철 역이 등록되었습니다.";
    public static final String STATION_UNREGISTER_SUCCESS = "지하철 역이 삭제되었습니다.";

    /**
     * 역 등록
     */
    public static void resisterStationByName(String name) {
        Station.from(name).save();
        OutputView.printInfo(STATION_REGISTER_SUCCESS);
    }

    /**
     * 역 삭제
     */
    public static void removeStationByName(String name) {
        if (!StationRepository.exists(name)) {
            throw new CannotFindStationByNameException(name);
        }
        StationRepository.deleteStation(name);
        OutputView.printInfo(STATION_UNREGISTER_SUCCESS);
    }

    /**
     * 역 조회
     */
    public static void listAllStations() {
        StationRepository.stations().forEach(OutputView::printInfo);
    }

}
