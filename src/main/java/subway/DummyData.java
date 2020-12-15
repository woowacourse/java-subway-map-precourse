package subway;

import subway.domain.line.Line;
import subway.domain.line.LineRepository;
import subway.domain.station.Station;
import subway.domain.station.StationRepository;

import java.util.Arrays;

public class DummyData {

    public static void saveDummyData() {
        Station station1 = Station.getStation("교대역");
        Station station2 = Station.getStation("강남역");
        Station station3 = Station.getStation("역삼역");
        Station station4 = Station.getStation("남부터미널역");
        Station station5 = Station.getStation("양재역");
        Station station6 = Station.getStation("양재시민의숲역");
        Station station7 = Station.getStation("매봉역");

        StationRepository.saveDummyData(
                Arrays.asList(station1, station2, station3, station4, station5, station6, station7)
        );

        Line line1 = Line.getLine("2호선", station1, station2);
        Line line2 = Line.getLine("3호선", station1, station4);
        Line line3 = Line.getLine("신분당선", station2, station5);

        LineRepository.saveDummyData(Arrays.asList(line1, line2, line3));
    }
}
