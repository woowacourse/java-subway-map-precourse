package subway.common;

import subway.line.domain.Line;
import subway.line.domain.LineRepository;
import subway.line.domain.Route;
import subway.station.domain.Station;
import subway.station.domain.StationRepository;

public class MapInitializer {
    private MapInitializer() {
    }

    public static void initialize() {
        Station station1 = new Station("교대역");
        Station station2 = new Station("강남역");
        Station station3 = new Station("역삼역");
        Station station4 = new Station("남부터미널역");
        Station station5 = new Station("양재역");
        Station station6 = new Station("양재시민의숲역");
        Station station7 = new Station("매봉역");

        StationRepository.register(station1);
        StationRepository.register(station2);
        StationRepository.register(station3);
        StationRepository.register(station4);
        StationRepository.register(station5);
        StationRepository.register(station6);
        StationRepository.register(station7);

        Line line1 = new Line("2호선", new Route(station1, station3));
        line1.insert(2, station2);

        Line line2 = new Line("3호선", new Route(station1, station7));
        line2.insert(2, station5);
        line2.insert(2, station4);

        Line line3 = new Line("신분당선", new Route(station2, station6));
        line3.insert(2, station5);

        LineRepository.register(line1);
        LineRepository.register(line2);
        LineRepository.register(line3);
    }
}
