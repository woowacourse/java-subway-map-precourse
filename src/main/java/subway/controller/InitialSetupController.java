package subway.controller;

import subway.domain.Line;
import subway.domain.LineRepository;
import subway.domain.Station;
import subway.domain.StationRepository;

import java.util.Arrays;
import java.util.List;

public class InitialSetupController {
    private static final List<String> preregisterStations = Arrays.asList("교대역", "강남역", "역삼역", "남부터미널역", "양재역", "양재시민의숲역", "매봉역");
    private static final List<String> preregisterLines = Arrays.asList("2호선", "3호선", "신분당선");

    public static void initialSetup() {
        for (String station : preregisterStations) {
            StationRepository.addStation(new Station(station));
        }
        for (String line : preregisterLines) {
            LineRepository.addLine(new Line(line));
        }
    }
}
