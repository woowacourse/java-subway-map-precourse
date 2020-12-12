package subway;

import java.util.Arrays;
import subway.line.domain.Line;
import subway.line.domain.LineRepository;
import subway.station.domain.Station;
import subway.station.domain.StationRepository;

public class DummyData {

    public static void load() {
        Station station1 = Station.from("교대역");
        Station station2 = Station.from("강남역");
        Station station3 = Station.from("역삼역");
        Station station4 = Station.from("남부터미널역");
        Station station5 = Station.from("양재역");
        Station station6 = Station.from("양재시민의숲역");
        Station station7 = Station.from("매봉역");

        StationRepository.saveAll(
            Arrays.asList(station1, station2, station3, station4, station5, station6, station7)
        );

        Line line1 = Line.of("2호선", station1, station2);
        line1.addSection(3, station3);

        Line line2 = Line.of("3호선", station1, station4);
        line2.addSection(3, station5);
        line2.addSection(4, station7);

        Line line3 = Line.of("신분당선", station2, station5);
        line3.addSection(3, station6);

        LineRepository.saveAll(Arrays.asList(line1, line2, line3));
    }
}
