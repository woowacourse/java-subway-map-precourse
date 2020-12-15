package subway.util;

import java.util.ArrayList;
import subway.domain.Line;
import subway.repository.LineRepository;
import subway.domain.Station;
import subway.repository.StationRepository;
import subway.service.LineService;

public class DummyUtils {

    public static void makeDummy() {
        Station station1 = new Station("교대역");
        Station station2 = new Station("강남역");
        Station station3 = new Station("역삼역");
        Station station4 = new Station("남부터미널역");
        Station station5 = new Station("양재역");
        Station station6 = new Station("양재시민의숲역");
        Station station7 = new Station("매봉역");

        StationRepository.addStation(station1);
        StationRepository.addStation(station2);
        StationRepository.addStation(station3);
        StationRepository.addStation(station4);
        StationRepository.addStation(station5);
        StationRepository.addStation(station6);
        StationRepository.addStation(station7);

        Line line1 = new Line("2호선", new ArrayList<>());
        Line line2 = new Line("3호선", new ArrayList<>());
        Line line3 = new Line("신분당선", new ArrayList<>());

        LineRepository.addLine(line1);
        LineRepository.addLine(line2);
        LineRepository.addLine(line3);

        LineService.addStationInLine(line1.getName(), station1.getName(), 0);
        LineService.addStationInLine(line1.getName(), station2.getName(), 0);
        LineService.addStationInLine(line1.getName(), station3.getName(), 0);

        LineService.addStationInLine(line2.getName(), station1.getName(), 0);
        LineService.addStationInLine(line2.getName(), station4.getName(), 0);
        LineService.addStationInLine(line2.getName(), station5.getName(), 0);
        LineService.addStationInLine(line2.getName(), station7.getName(), 0);

        LineService.addStationInLine(line3.getName(), station2.getName(), 0);
        LineService.addStationInLine(line3.getName(), station5.getName(), 0);
        LineService.addStationInLine(line3.getName(), station6.getName(), 0);
    }
}
