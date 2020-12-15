package subway.domain.util;

import java.util.Arrays;
import java.util.List;
import subway.domain.line.Line;
import subway.domain.line.LineRepository;
import subway.domain.station.Station;
import subway.domain.station.StationRepository;

public class DataFactory {

    public void makeSubwayData() {
        Station station1 = new Station("교대역");
        Station station2 = new Station("강남역");
        Station station3 = new Station("역삼역");
        Station station4 = new Station("남부터미널역");
        Station station5 = new Station("양재역");
        Station station6 = new Station("양재시민의숲역");
        Station station7 = new Station("매봉역");

        List<Station> stations = Arrays
            .asList(station1, station2, station3, station4, station5, station6, station7);
        makeStationData(stations);
        makeLineData(stations);
    }

    private void makeStationData(List<Station> stations) {
        StationRepository.addAllStation(stations);
    }

    private void makeLineData(List<Station> stations) {
        Line line1 = new Line("2호선");
        line1.addAllStation(Arrays.asList(stations.get(0), stations.get(1), stations.get(2)));
        LineRepository.addLine(line1);

        Line line2 = new Line("3호선");
        line2.addAllStation(
            Arrays.asList(stations.get(0), stations.get(3), stations.get(4), stations.get(6)));
        LineRepository.addLine(line2);

        Line line3 = new Line("신분당선");
        line3.addAllStation(Arrays.asList(stations.get(1), stations.get(4), stations.get(5)));
        LineRepository.addLine(line3);
    }
}
