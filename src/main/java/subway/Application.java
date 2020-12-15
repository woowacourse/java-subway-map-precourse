package subway;

import subway.domain.Line;
import subway.domain.LineRepository;
import subway.domain.Station;
import subway.domain.StationRepository;
import subway.manager.MainManager;

import java.util.Arrays;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        initializeRepositories();
        MainManager.initializeMainManager();
    }

    private static void initializeRepositories() {
        initializeStationRepository();
        initializeLineRepository();
    }

    private static void initializeLineRepository() {
        Line line2 = new Line("2호선");
        LineRepository.addLineWithStationNames(line2, Arrays.asList("교대역", "강남역", "역삼역"));
        Line line3 = new Line("3호선");
        LineRepository.addLineWithStationNames(line3, Arrays.asList("교대역", "남부터미널역", "양재역", "매봉역"));
        Line sinbundangLine = new Line("신분당선");
        LineRepository.addLineWithStationNames(sinbundangLine, Arrays.asList("강남역", "양재역", "양재시민의숲역"));
    }

    private static void initializeStationRepository() {
        List<String> stationNames = Arrays.asList("교대역", "강남역", "역삼역", "남부터미널역", "양재역", "양재시민의숲역", "매봉역");
        stationNames.forEach(stationName -> StationRepository.addStation(new Station(stationName)));
    }
}
