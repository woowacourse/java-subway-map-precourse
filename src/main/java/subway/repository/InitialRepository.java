package subway.repository;

import subway.domain.Line;
import subway.domain.Station;

import java.util.Arrays;

public class InitialRepository {

    private final String[] initialLines = {"2호선", "3호선", "신분당선"};
    private final String[] initialStations = {"교대역", "강남역", "역삼역", "남부터미널역", "양재역", "양재시민의숲역", "매봉역"};

    public static void end() {
        System.exit(0);
    }

    public void initialize() {
        Arrays.stream(initialLines)
                .forEach(line -> LineRepository.addLine(new Line(line)));
        Arrays.stream(initialStations)
                .forEach(station -> StationRepository.addStation(new Station(station)));
        initialSection("2호선", "교대역");
        initialSection("2호선", "강남역");
        initialSection("2호선", "역삼역");
        initialSection("3호선", "교대역");
        initialSection("3호선", "남부터미널역");
        initialSection("3호선", "양재역");
        initialSection("3호선", "매봉역");
        initialSection("신분당선", "강남역");
        initialSection("신분당선", "양재역");
        initialSection("신분당선", "양재시민의숲역");
    }

    private void initialSection(String line, String station) {
        LineRepository.searchLine(line).addSection(StationRepository.searchStation(station));
    }
}
