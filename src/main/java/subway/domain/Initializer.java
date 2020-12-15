package subway.domain;

import java.util.Arrays;

public class Initializer {
    public static final void load() {
        Station station1 = new Station("교대역");
        Station station2 = new Station("강남역");
        Station station3 = new Station("역삼역");
        Station station4 = new Station("남부터미널역");
        Station station5 = new Station("양재역");
        Station station6 = new Station("양재시민의숲역");
        Station station7 = new Station("매봉역");
        StationRepository.addStations(Arrays.asList(station1, station2, station3, station4, station5, station6, station7));

        Line line1 = new Line("2호선", station1, station2, station3);
        Line line2 = new Line("3호선", station1, station4, station5, station7);
        Line line3 = new Line("신분당선", station2, station5, station6);
        LineRepository.addLines(Arrays.asList(line1, line2, line3));
    }
}
