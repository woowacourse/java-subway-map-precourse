package subway.service;

import subway.domain.Line;
import subway.domain.LineRepository;
import subway.domain.Station;
import subway.domain.StationRepository;

import java.util.Arrays;
import java.util.List;

public class InitializationService {
    public static final List<String> stationNames = Arrays.asList("교대역", "강남역", "역삼역", "남부터미널역", "양재역", "양재시민의숲역", "매봉역");
    public static final List<String> lines = Arrays.asList("2호선", "3호선", "신분당선");

    private InitializationService() {
    }

    public static void init() {
        addStations();
        addLines();
    }

    private static void addStations() {
        stationNames.forEach(stationName -> StationRepository.addStation(new Station(stationName)));
    }

    // Line.insertStation()에서 +1을 해준 이유는 index 0을 기준으로 입력받는 것이 아닌, 1을 기준으로 하는 사용자 입력 방식 기준으로 입력받는 것을 표현하기 위해서다.
    private static void addLines() {
        Line line = new Line(lines.get(0));
        line.addUpAndDownWardStations(StationRepository.findStation(stationNames.get(0)), StationRepository.findStation(stationNames.get(2)));
        line.insertStation(1 + 1, StationRepository.findStation(stationNames.get(1)));
        LineRepository.addLine(line);

        line = new Line(lines.get(1));
        line.addUpAndDownWardStations(StationRepository.findStation(stationNames.get(0)), StationRepository.findStation(stationNames.get(6)));
        line.insertStation(1 + 1, StationRepository.findStation(stationNames.get(3)));
        line.insertStation(2 + 1, StationRepository.findStation(stationNames.get(4)));
        LineRepository.addLine(line);

        line = new Line(lines.get(2));
        line.addUpAndDownWardStations(StationRepository.findStation(stationNames.get(1)), StationRepository.findStation(stationNames.get(5)));
        line.insertStation(1 + 1, StationRepository.findStation(stationNames.get(4)));
        LineRepository.addLine(line);
    }
}
