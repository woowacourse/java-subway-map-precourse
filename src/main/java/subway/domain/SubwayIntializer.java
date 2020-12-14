package subway.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubwayIntializer {
    private static final List<String> initialStationNames = new ArrayList<>(
            Arrays.asList("교대역", "강남역", "역삼역", "남부터미널역", "양재역", "양재시민의숲역", "매봉역"));
    private static final List<String> initialLineNames = new ArrayList<>(
            Arrays.asList("2호선", "3호선", "신분당선"));
    
    public static void initialize() {
        initializeStations();
        initializeLines();
        initializeRoutes();
    }
    
    private static void initializeStations() {
        for (String stationName : initialStationNames) {
            StationRepository.addStation(new Station(stationName));
        }
    }
    
    private static void initializeLines() {
        for (String lineName : initialLineNames) {
            LineRepository.addLine(new Line(lineName));
        }
    }
    
    private static void initializeRoutes() {
        LineRepository.addStationToRouteByName("2호선", "교대역");
        LineRepository.addStationToRouteByName("2호선", "강남역");
        LineRepository.addStationToRouteByName("2호선", "역삼역");
        LineRepository.addStationToRouteByName("3호선", "교대역");
        LineRepository.addStationToRouteByName("3호선", "남부터미널역");
        LineRepository.addStationToRouteByName("3호선", "양재역");
        LineRepository.addStationToRouteByName("3호선", "매봉역");
        LineRepository.addStationToRouteByName("신분당선", "강남역");
        LineRepository.addStationToRouteByName("신분당선", "양재역");
        LineRepository.addStationToRouteByName("신분당선", "양재시민의숲역");
    }
}
