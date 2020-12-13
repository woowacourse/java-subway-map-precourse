package subway.util;

import subway.domain.line.model.Line;
import subway.domain.line.model.LineRepository;
import subway.domain.station.model.Station;
import subway.domain.station.model.StationRepository;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class DummyData {

    public static void init() {
        initStations();
        initLines();
    }

    private static void initStations() {
        String stationNames = "교대역,강남역,역삼역,남부터미널역,양재역,양재시민의숲역,매봉역";
        Arrays.stream(stationNames.split(","))
                .map(Station::new)
                .forEach(StationRepository::addStation);
    }

    private static void initLines() {
        initSubwayLineTwo();
        initSubwayLineThree();
        initSubwayShinbundangLine();
    }

    private static void initSubwayLineTwo() {
        String stationNames = "교대역,강남역,역삼역";
        List<Station> stations = Arrays.stream(stationNames.split(","))
                .map(Station::new)
                .collect(Collectors.toList());
        LineRepository.addLine(new Line("2호선", stations));
    }

    private static void initSubwayLineThree() {
        String stationNames = "교대역,남부터미널역,양재역,매봉역";
        List<Station> stations = Arrays.stream(stationNames.split(","))
                .map(Station::new)
                .collect(Collectors.toList());
        LineRepository.addLine(new Line("3호선", stations));
    }

    private static void initSubwayShinbundangLine() {
        String stationNames = "강남역,양재역,양재시민의숲역";
        List<Station> stations = Arrays.stream(stationNames.split(","))
                .map(Station::new)
                .collect(Collectors.toList());
        LineRepository.addLine(new Line("신분당선", stations));
    }
}
