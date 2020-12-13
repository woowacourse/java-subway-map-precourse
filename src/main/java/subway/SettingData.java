package subway;


import java.util.Arrays;
import java.util.List;
import subway.domain.Line;
import subway.domain.LineRepository;
import subway.domain.Station;
import subway.domain.StationRepository;

public class SettingData {
    public static void load() {
        List<Station> stations = Arrays.asList(
            new Station("교대역"), new Station("강남역")
            , new Station("역삼역"), new Station("남부터미널역")
            , new Station("양재역"), new Station("양재시민의숲역"),
            new Station("매봉역")
        );
        for (Station station : stations) {
            StationRepository.addStation(station);
        }
        LineRepository.addLine(new Line("2호선"),new Station("교대역"), new Station("역삼역") );
        LineRepository.addSection(new Line("2호선"),new Station("강남역"),1);
        LineRepository.addLine(new Line("3호선"),new Station("교대역"), new Station("매봉역") );
        LineRepository.addSection(new Line("3호선"),new Station("남부터미널역"),1);
        LineRepository.addSection(new Line("3호선"),new Station("양재역"),2);
        LineRepository.addLine(new Line("신분당선"),new Station("강남역"), new Station("양재시민의숲역") );
        LineRepository.addSection(new Line("신분당선"),new Station("양재역"),1);
    }
}
