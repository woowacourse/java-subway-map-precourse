package subway;

import java.util.Arrays;

import subway.domain.Line;
import subway.domain.LineRepository;
import subway.domain.Station;
import subway.domain.StationRepository;

public class Init {

    public static void set() {
        Station station1 = new Station("교대역");
        Station station2 = new Station("강남역");
        Station station3 = new Station("역삼역");
        Station station4 = new Station("남부터미널역");
        Station station5 = new Station("양재역");
        Station station6 = new Station("양재시민의숲역");
        Station station7 = new Station("매봉역");

        Arrays.asList(station1, station2, station3, station4, station5, station6, station7)
            .forEach(StationRepository::addStation);

        Line line1 = new Line("2호선");
        Line line2 = new Line("3호선");
        Line line3 = new Line("신분당선");

        line1.addStationByOrder(station1, 0);
        line1.addStationByOrder(station2, 1);
        line1.addStationByOrder(station3, 2);

        line2.addStationByOrder(station1, 0);
        line2.addStationByOrder(station4, 1);
        line2.addStationByOrder(station5, 2);
        line2.addStationByOrder(station7, 3);

        line3.addStationByOrder(station2, 0);
        line3.addStationByOrder(station5, 1);
        line3.addStationByOrder(station7, 2);

        Arrays.asList(line1, line2, line3).forEach(LineRepository::addLine);
    }
}
