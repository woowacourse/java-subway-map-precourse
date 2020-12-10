package subway.enums;

import subway.domain.Station;
import subway.domain.StationRepository;

import java.util.Arrays;
import java.util.List;

public enum InitialSetting {
    STATIONS(Arrays.asList("교대역", "강남역", "역삼역", "남부터미널역", "양재역", "양재시민의숲", "매봉역"));

    private List<String> initialStations;

    InitialSetting(List<String> initialStations) {
        this.initialStations = initialStations;
    }

    public void initializeStations() {
        initialStations.stream()
                .map(Station::new)
                .forEach(StationRepository::addStation);
    }
}
