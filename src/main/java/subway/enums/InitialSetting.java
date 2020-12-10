package subway.enums;

import subway.domain.Line;
import subway.domain.LineRepository;
import subway.domain.Station;
import subway.domain.StationRepository;

import java.util.Arrays;
import java.util.List;

public enum InitialSetting {
    STATIONS(Arrays.asList("교대역", "강남역", "역삼역", "남부터미널역", "양재역", "양재시민의숲", "매봉역")),
    LINES(Arrays.asList("2호선", "3호선", "신분당선"));

    private List<String> values;

    InitialSetting(List<String> values) {
        this.values = values;
    }

    public void initializeStations() {
        values.stream()
                .map(Station::new)
                .forEach(StationRepository::addStation);
    }

    public void initializeLines() {
        values.stream()
                .map(Line::new)
                .forEach(LineRepository::addLine);
    }
}
