package subway.service.stationservice;

import subway.repository.StationRepository;
import subway.views.stationviews.StationOutputView;

public class StationsPrintService {
    public static void showAllStations() {
        StationOutputView.printStations(StationRepository.stations());
    }
}
