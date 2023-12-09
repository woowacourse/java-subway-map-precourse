package subway.config;

import subway.domain.LineRepository;
import subway.domain.StationRepository;

public class AppConfig {

    public static void initializeStationLine() {
        StationRepository.initialize();
        LineRepository.initialize();
    }
}
