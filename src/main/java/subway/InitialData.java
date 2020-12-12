package subway;

import subway.domain.Line;
import subway.domain.LineRepository;
import subway.domain.Station;
import subway.domain.StationRepository;

public class InitialData {

    public InitialData() {
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
        Line line1 = new Line("2호선");
        Line line2 = new Line("3호선");
        Line line3 = new Line("신분당선");
        LineRepository.addLine(line1);
        LineRepository.addLine(line2);
        LineRepository.addLine(line3);
        line1.addStation(station1);
        line1.addStation(station2);
        line1.addStation(station3);
        line2.addStation(station1);
        line2.addStation(station4);
        line2.addStation(station5);
        line2.addStation(station7);
        line3.addStation(station2);
        line3.addStation(station5);
        line3.addStation(station6);

    }
}
