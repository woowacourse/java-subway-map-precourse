package subway;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import subway.domain.line.Line;
import subway.domain.line.LineRepository;
import subway.domain.station.Station;
import subway.domain.station.StationRepository;

public class DummySetup {

    private static final List<String> dummyStationNames = new ArrayList<>(Arrays.asList(
            "교대역",
            "강남역",
            "역삼역",
            "남부터미널역",
            "양재역",
            "양재시민의숲역",
            "매봉역"
    ));

    private static final List<String> dummyLineNames = new ArrayList<>(Arrays.asList(
            "2호선",
            "3호선",
            "신분당선"
    ));

    public static void initialize() {
        initializeStations();
        initializeLines();
        connectStationsAndLines();
    }

    public static void initializeStations() {
        dummyStationNames.stream()
                .map(Station::new)
                .forEach(StationRepository::addStation);
    }

    private static void initializeLines() {
        dummyLineNames.stream()
                .map(Line::new)
                .forEach(LineRepository::addLine);
    }

    private static void connectStationsAndLines() {
        connectSecondLine();
        connectThirdLine();
        connectNewBundangLine();
    }

    private static void connectSecondLine() {
        Line secondLine = LineRepository.get("2호선");
        secondLine.add(StationRepository.get("교대역"));
        secondLine.add(StationRepository.get("강남역"));
        secondLine.add(StationRepository.get("역삼역"));
    }

    private static void connectThirdLine() {
        Line thirdLine = LineRepository.get("3호선");
        thirdLine.add(StationRepository.get("교대역"));
        thirdLine.add(StationRepository.get("남부터미널역"));
        thirdLine.add(StationRepository.get("양재역"));
        thirdLine.add(StationRepository.get("매봉역"));
    }

    private static void connectNewBundangLine() {
        Line newBundangLine = LineRepository.get("신분당선");
        newBundangLine.add(StationRepository.get("강남역"));
        newBundangLine.add(StationRepository.get("양재역"));
        newBundangLine.add(StationRepository.get("양재시민의숲역"));
    }
}
